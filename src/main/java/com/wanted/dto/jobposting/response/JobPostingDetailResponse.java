package com.wanted.dto.jobposting.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class JobPostingDetailResponse {

    private long jobPostingId;
    private String companyName;
    private String companyNation;
    private String companyRegion;
    private String position;
    private Integer compensation;
    private String tech;
    private String detail;
    private List<Long> jobPostingIdList;
}
