package com.wanted.dto.jobposting.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JobPostingResponse {

    private long jobPostingId;
    private String companyName;
    private String companyNation;
    private String companyRegion;
    private String position;
    private Integer compensation;
    private String tech;
}
