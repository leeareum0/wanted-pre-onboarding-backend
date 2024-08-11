package com.wanted.domain.jobposting;

import com.wanted.domain.company.Company;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Comment("채용공고")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Builder
public class JobPosting {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("채용포지션")
    @Column(nullable = false)
    private String position;

    @Comment("채용보상금")
    @Column(nullable = false)
    private Integer compensation;

    @Comment("채용내용")
    @Column(nullable = false)
    private String detail;

    @Comment("사용기술")
    @Column(nullable = false)
    private String tech;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}




