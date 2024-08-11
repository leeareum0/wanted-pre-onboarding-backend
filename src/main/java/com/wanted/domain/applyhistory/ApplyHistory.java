package com.wanted.domain.applyhistory;

import com.wanted.domain.jobposting.JobPosting;
import com.wanted.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Comment("지원내역")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
public class ApplyHistory {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_history_id")
    private Long id;

    @Comment("채용 공고 ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_posting_id", nullable = false)
    private JobPosting jobPosting;

    @Comment("사용자 ID")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
