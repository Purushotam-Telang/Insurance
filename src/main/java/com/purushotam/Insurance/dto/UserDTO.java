package com.purushotam.Insurance.dto;

import com.purushotam.Insurance.annotations.UserRoleValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String firstName;
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @PastOrPresent
    private Date passwordChangeDate;
    @NotEmpty
    @UserRoleValidation
    private String role;

}
