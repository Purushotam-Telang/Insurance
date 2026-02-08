package com.purushotam.Insurance.entities;

import com.purushotam.Insurance.ENUMS.CCYCodes;
import com.purushotam.Insurance.ENUMS.RSOSectionStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "RSO", uniqueConstraints = {
        @UniqueConstraint(name = "rso_uk",columnNames = {"rso_spd_ref","rso_spd_year","rso_spd_renewal"})
})
public class RSOEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rso_next")
    Long rsoNext;

    @Column(name = "rso_ccy_code", length = 3)
    @Enumerated(value = EnumType.STRING)
    CCYCodes rsoCcyCode;

    @Column(name = "rso_clm_ind")
    Boolean rsoClmInd;

    @Column(name = "rso_complete_ind")
    Boolean rsoCompleteInd;

    @Column(name = "rso_exp_date")
    LocalDateTime rsoExpDate;

    @Column(name = "rso_inception_date")
    LocalDateTime rsoInceptionDate;

    @Column(name = "rso_created_usr")
    Long rsoCreatedUsr;

    @Column(name = "rso_modified_usr")
    Long rsoModifiedUsr;

    @Column(name = "rso_no_days")
    Integer rsoNoDays;

    @Column(name = "rso_notice_date")
    LocalDateTime rsoNoticeDate;

    @Column(name = "rso_section", length = 10)
    String rsoSection;

    @Column(name = "rso_spd_ref")
    String rsoSpdRef;

    @Column(name = "rso_spd_yr")
    Integer rsoSpdYr;

    @Column(name = "rso_spd_renewal")
    Integer rsoSpdRenewal;

    @ManyToOne
    @JoinColumn(name = "rso_spd_next")
    SPDEntity rsoSpdNext;

    @Column(name = "rso_split_pcnt", precision = 7, scale = 4)
    BigDecimal rsoSplitPcnt;

    @Column(name = "rso_endorsement_no", length = 3)
    Integer rsoEndorsementNo;

    @Column(name = "rso_latest_endorsement_ind")
    Boolean rsoLatestEndorsementInd;

    @Column(name = "rso_section_status")
    @Enumerated(value = EnumType.STRING)
    RSOSectionStatus rsoSectionStatus;

}
