package com.purushotam.Insurance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "users_seq_gen",
            sequenceName = "users_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date passwordChangeDate;
    private String role;
}
