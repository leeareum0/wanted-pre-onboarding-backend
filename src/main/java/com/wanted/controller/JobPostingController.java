package com.wanted.controller;

import com.wanted.common.BaseResponse;
import com.wanted.dto.jobposting.request.JobPostingApplyRequest;
import com.wanted.dto.jobposting.request.JobPostingCreateRequest;
import com.wanted.dto.jobposting.request.JobPostingUpdateRequest;
import com.wanted.dto.jobposting.response.JobPostingDetailResponse;
import com.wanted.dto.jobposting.response.JobPostingResponse;
import com.wanted.service.jobposting.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @PostMapping(value = "/job-posting")
    public BaseResponse create(@Validated @RequestBody JobPostingCreateRequest request) {
        jobPostingService.create(request);
        return new BaseResponse();
    }

    @PutMapping(value = "/job-posting/{jobPostingId}")
    public BaseResponse update(@PathVariable Long jobPostingId, @Validated @RequestBody JobPostingUpdateRequest request) {
        jobPostingService.update(jobPostingId, request);
        return new BaseResponse();
    }

    @DeleteMapping(value = "/job-posting/{jobPostingId}")
    public BaseResponse delete(@PathVariable Long jobPostingId) {
        jobPostingService.delete(jobPostingId);
        return new BaseResponse();
    }

    @GetMapping(value = "/job-posting")
    public List<JobPostingResponse> getList(@RequestParam(required = false) String search) {
        return jobPostingService.getList(search);
    }

    @GetMapping(value = "/job-posting/{jobPostingId}")
    public JobPostingDetailResponse getDetail(@PathVariable Long jobPostingId) {
        return jobPostingService.getDetail(jobPostingId);
    }

    @PostMapping(value = "/job-posting/apply")
    public BaseResponse apply(@Validated @RequestBody JobPostingApplyRequest request) {
        jobPostingService.apply(request);
        return new BaseResponse();
    }
}
