package com.cherish.jobtracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "jobs")
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    private String externalJobId;

    @Column(nullable = false)
    private String role;

    private Integer minExperience;

    private Integer maxExperience;

    private LocalDate lastDateToApply;

    private String city;

    private String state;

    private String country;

    private BigDecimal minCtc;

    private BigDecimal maxCtc;

    private String currency;

    private String jobUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}