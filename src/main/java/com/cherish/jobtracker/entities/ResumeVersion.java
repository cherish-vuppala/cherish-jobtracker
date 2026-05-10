package com.cherish.jobtracker.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resume_versions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeVersion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeVersionId;

    @Column(nullable = false)
    private String resumeName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String fileType;

    private Long fileSize;

    private Integer atsScore;

    @Column(length = 500)
    private String notes;

    /*
        Many resumes belong to one user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    /*
        One resume version can be used
        in multiple applications
     */
    @OneToMany(mappedBy = "resumeVersion")
    private List<Application> applications = new ArrayList<>();
}