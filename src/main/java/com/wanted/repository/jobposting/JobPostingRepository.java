package com.wanted.repository.jobposting;

import com.wanted.domain.company.Company;
import com.wanted.domain.jobposting.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long>, JobPostingRepositoryCustom {

    List<JobPosting> findAllByCompany(Company company);
}
