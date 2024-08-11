package com.wanted.repository.jobposting;

import com.wanted.dto.jobposting.response.JobPostingResponse;

import java.util.List;

public interface JobPostingRepositoryCustom {

    List<JobPostingResponse> getList(String search);

}
