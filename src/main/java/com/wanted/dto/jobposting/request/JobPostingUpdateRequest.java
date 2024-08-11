package com.wanted.dto.jobposting.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobPostingUpdateRequest {

    @NotBlank(message = "포지션을 입력해 주세요.")
    private String position;

    @NotNull(message = "보상금을 입력해 주세요.")
    private Integer compensation;

    @NotBlank(message = "채용 내용을 입력해 주세요.")
    private String detail;

    @NotBlank(message = "사용 기술을 입력해 주세요.")
    private String tech;
}
