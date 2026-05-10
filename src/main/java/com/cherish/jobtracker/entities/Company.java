package com.cherish.jobtracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, unique = true)
    private String companyName;

    private String websiteUrl;

    @Column(columnDefinition = "TEXT")
    private String about;

    @OneToMany(
            mappedBy = "company",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<Job> jobs = new HashSet<>();
}