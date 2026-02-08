package com.purushotam.Insurance.entities;

import com.purushotam.Insurance.ENUMS.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name = "users_seq_gen",
//            sequenceName = "users_seq",
//            allocationSize = 1
//    )
    @Column(name = "usr_user_id")
    private Long id;

    @Column(name = "usr_first_name")
    private String firstName;

    @Column(name = "usr_last_name")
    private String lastName;

    @Column(name = "usr_email")
    private String email;

    @Column(name = "usr_password")
    private String password;

    @Column(name = "usr_password_change_date")
    @UpdateTimestamp
    private Date passwordChangeDate;

    @Column(name = "usr_role")
    @Enumerated(value = EnumType.STRING)
    private UserRoles role;
}
