package com.wanted.domain.jobposting;

import com.wanted.domain.company.Company;
import com.wanted.dto.jobposting.request.JobPostingUpdateRequest;
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
    @Column(name = "job_posting_id")
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

    @Comment("회사 ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public void update(JobPostingUpdateRequest request) {
        this.position = request.getPosition();
        this.compensation = request.getCompensation();
        this.detail = request.getDetail();
        this.tech = request.getTech();
    }
}




