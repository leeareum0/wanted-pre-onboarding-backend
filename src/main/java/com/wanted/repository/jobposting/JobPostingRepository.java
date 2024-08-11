package com.wanted.repository.jobposting;

import com.wanted.domain.jobposting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long>, JobPostingRepositoryCustom {

}
