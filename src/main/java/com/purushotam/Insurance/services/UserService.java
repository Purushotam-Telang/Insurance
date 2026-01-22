package com.purushotam.Insurance.services;

import com.purushotam.Insurance.dto.UserDTO;
import com.purushotam.Insurance.entities.UserEntity;
import com.purushotam.Insurance.exceptions.ResourceNotFoundException;
import com.purushotam.Insurance.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserService(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepo.findAll();
        return userEntities
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(long id) {
        Optional<UserEntity> userEntity = userRepo.findById(id);
        return  userEntity.map(userEntity1 -> modelMapper.map(userEntity1, UserDTO.class));
//        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public UserDTO createNewUser(UserDTO newUser) {
        UserEntity toSave = modelMapper.map(newUser, UserEntity.class);
        UserEntity savedUser = userRepo.save(toSave);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public Optional<UserDTO> updateUserById(long userId, UserDTO user) {

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setId(userId);
        Optional<UserEntity> savedUser = Optional.of(userRepo.save(userEntity));
        return savedUser.map(savedUser1 -> modelMapper.map(savedUser1, UserDTO.class));
    }

    public void isExistsByUserId(Long userId)  throws ResourceNotFoundException {
        boolean exists = userRepo.existsById(userId);
        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+userId);
    }

    public UserDTO updatePartialUserById(long userId, Map<String, Object> updates) {
        isExistsByUserId(userId);

        UserEntity userEntity = userRepo.findById(userId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.getRequiredField(UserEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, userEntity, value);
        });
        return modelMapper.map(userRepo.save(userEntity), UserDTO.class);
    }

    public Boolean deleteUserById(long userId) {
        isExistsByUserId(userId);
        return true;
    }
}
