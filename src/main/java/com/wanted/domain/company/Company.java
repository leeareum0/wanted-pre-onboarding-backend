package com.wanted.domain.company;

import com.wanted.domain.jobposting.JobPosting;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Comment("회사")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Company {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Comment("회사명")
    private String name;

    @Comment("국가")
    @Column(nullable = false)
    private String nation;

    @Comment("지역")
    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "company")
    private List<JobPosting> jobPostings = new ArrayList<>();
}
