package com.wanted.service.jobposting;

import com.wanted.domain.company.Company;
import com.wanted.domain.jobposting.JobPosting;
import com.wanted.dto.jobposting.request.JobPostingCreateRequest;
import com.wanted.common.JobPostingException;
import com.wanted.repository.company.CompanyRepository;
import com.wanted.repository.jobposting.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final CompanyRepository companyRepository;

    public void create(JobPostingCreateRequest request) {
        Optional<Company> company = companyRepository.findCompanyById(request.getCompanyId());
        if (company.isEmpty()) {
            throw new JobPostingException("존재하지 않는 회사입니다.");
        }
        jobPostingRepository.save(JobPosting.builder()
                .position(request.getPosition())
                .compensation(request.getCompensation())
                .detail(request.getDetail())
                .tech(request.getTech())
                .company(company.get())
                .build());
    }
}
