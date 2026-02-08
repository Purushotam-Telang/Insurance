package com.purushotam.Insurance.entities;

import com.purushotam.Insurance.ENUMS.SPDStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "SPD", uniqueConstraints = {
        @UniqueConstraint(name = "spd_ref_year_uk",columnNames = {"spd_ref","spd_year"})
})
public class SPDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "spd_next")
    Long spdNext;

    @Column(name = "spd_ref",nullable = false)
    String spdRef;

    @Column(name = "spd_year",nullable = false)
    String spdYear;

    @Column(name = "spd_assured_name")
    String spdAssuredName;

    @Column(name = "spd_orig_inc_date")
    LocalDateTime spdOriginalInceptionDate;

    @Column(name = "spd_renewal")
    int spdRenewal;

    @Column(name = "spd_status")
    @Enumerated(value = EnumType.STRING)
    SPDStatus spdStatus;

    @Column(name = "spd_bkr_broker_code")
    String spdBKRBrokerCode;

    @CreationTimestamp
    @Column(name = "spd_created_date")
    LocalDateTime spdCreatedDate;

    @UpdateTimestamp
    @Column(name = "spd_modified_date")
    LocalDateTime spdModifiedDate;

    @Column(name = "spd_created_user",nullable = false,updatable = false)
    Long spdCreatedUser;

}
