package com.wanted.service.jobposting;

import com.wanted.domain.company.Company;
import com.wanted.domain.jobposting.JobPosting;
import com.wanted.dto.jobposting.request.JobPostingCreateRequest;
import com.wanted.common.JobPostingException;
import com.wanted.dto.jobposting.request.JobPostingUpdateRequest;
import com.wanted.dto.jobposting.response.JobPostingDetailResponse;
import com.wanted.dto.jobposting.response.JobPostingResponse;
import com.wanted.repository.company.CompanyRepository;
import com.wanted.repository.jobposting.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    public void update(Long jobPostingId, JobPostingUpdateRequest request) {
        Optional<JobPosting> jobPosting = jobPostingRepository.findById(jobPostingId);
        if (jobPosting.isEmpty()) {
            throw new JobPostingException("존재하지 않는 채용 공고입니다.");
        }
        jobPosting.get().update(request);
    }

    public void delete(Long jobPostingId) {
        jobPostingRepository.deleteById(jobPostingId);
    }

    public List<JobPostingResponse> getList(String search) {
        return jobPostingRepository.getList(search);
    }

    public JobPostingDetailResponse getDetail(Long jobPostingId) {
        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(jobPostingId);
        if (jobPostingOptional.isEmpty()) {
            throw new JobPostingException("존재하지 않는 채용 공고입니다.");
        }
        JobPosting jobPosting = jobPostingOptional.get();
        Company company = jobPosting.getCompany();

        // 회사가 올린 다른 채용 공고
        List<Long> jobPostingIdList = jobPostingRepository.findAllByCompany(company).stream()
                .map(JobPosting::getId)
                .filter(id -> !id.equals(jobPostingId))
                .toList();

        return JobPostingDetailResponse.builder()
                .jobPostingId(jobPostingId)
                .companyName(company.getName())
                .companyNation(company.getNation())
                .companyRegion(company.getRegion())
                .position(jobPosting.getPosition())
                .compensation(jobPosting.getCompensation())
                .tech(jobPosting.getTech())
                .detail(jobPosting.getDetail())
                .jobPostingIdList(jobPostingIdList)
                .build();
    }
}
