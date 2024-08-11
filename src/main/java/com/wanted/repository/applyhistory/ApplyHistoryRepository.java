package com.wanted.repository.applyhistory;

import com.wanted.domain.applyhistory.ApplyHistory;
import com.wanted.domain.jobposting.JobPosting;
import com.wanted.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplyHistoryRepository extends JpaRepository<ApplyHistory, Long> {

    Optional<ApplyHistory> findByJobPostingAndUser(JobPosting jobPosting, User user);
}
