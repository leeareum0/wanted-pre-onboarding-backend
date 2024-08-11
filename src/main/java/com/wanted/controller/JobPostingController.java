package com.wanted.controller;

import com.wanted.common.BaseResponse;
import com.wanted.dto.jobposting.request.JobPostingCreateRequest;
import com.wanted.service.jobposting.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @PostMapping(value = "/job-posting")
    public BaseResponse create(@Validated @RequestBody JobPostingCreateRequest request) {
        jobPostingService.create(request);
        return new BaseResponse();
    }
}
