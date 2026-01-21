package com.purushotam.Insurance.controllers;

import com.purushotam.Insurance.dto.UserDTO;
import com.purushotam.Insurance.exceptions.ResourceNotFoundException;
import com.purushotam.Insurance.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    //Constructor DI
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
        Optional<UserDTO> userDTO = userService.getUserById(id);
        try {
            return userDTO
                    .map(userDTO1 -> ResponseEntity.ok(userDTO1))
                    .orElseThrow(()-> new ResourceNotFoundException("User not found with id :  "+id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUser){
        return new ResponseEntity<>(userService.createNewUser(newUser),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable(name = "id") long userId, @RequestBody UserDTO user){
        Optional<UserDTO> userDTO = userService.updateUserById(userId,user);
        try {
            return userDTO
                    .map(userDTO1 -> ResponseEntity.ok(userDTO1))
                    .orElseThrow(()-> new ResourceNotFoundException("User not found with id :  "+userId));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserDTO> updatePartialUserById(@PathVariable(name = "id") long userId, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(userService.updatePartialUserById(userId, updates));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable(name = "id") long userId){
//        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
//        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userService.deleteUserById(userId));

    }

}
