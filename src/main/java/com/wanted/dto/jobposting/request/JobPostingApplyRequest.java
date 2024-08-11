package com.wanted.dto.jobposting.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JobPostingApplyRequest {

    @NotNull(message = "채용 공고 id를 입력해 주세요.")
    private Long jobPostingId;

    @NotNull(message = "사용자 id를 입력해 주세요.")
    private Long userId;
}
