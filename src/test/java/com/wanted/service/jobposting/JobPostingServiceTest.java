package com.wanted.service.jobposting;

import com.wanted.common.JobPostingException;
import com.wanted.domain.company.Company;
import com.wanted.domain.jobposting.JobPosting;
import com.wanted.dto.jobposting.request.JobPostingCreateRequest;
import com.wanted.dto.jobposting.request.JobPostingUpdateRequest;
import com.wanted.repository.company.CompanyRepository;
import com.wanted.repository.jobposting.JobPostingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @InjectMocks
    private JobPostingService jobPostingService;

    @Mock
    private JobPostingRepository jobPostingRepository;

    @Mock
    private CompanyRepository companyRepository;

    @DisplayName("채용 공고를 등록할 수 있다.")
    @Test
    void create() {
        // given
        JobPostingCreateRequest request = new JobPostingCreateRequest(
                1L,
                "백엔드 주니어 개발자",
                1000000,
                "원티드랩은 백엔드 주니어 개발자를 적극 채용합니다.",
                "java"
        );
        given(companyRepository.findCompanyById(request.getCompanyId())).willReturn(Optional.of(new Company(
                1L,
                "회사1",
                "한국",
                "서울",
                List.of()
        )));

        // when
        // then
        jobPostingService.create(request);
    }

    @DisplayName("채용 공고를 등록할 때 회사가 존재하지 않을 경우 오류를 반환한다.")
    @Test
    void create_fail() {
        // given
        JobPostingCreateRequest request = new JobPostingCreateRequest(
                1L,
                "백엔드 주니어 개발자",
                1000000,
                "원티드랩은 백엔드 주니어 개발자를 적극 채용합니다.",
                "java"
        );
        given(companyRepository.findCompanyById(request.getCompanyId())).willReturn(Optional.empty());

        // when
        // then
        JobPostingException exception = assertThrows(JobPostingException.class, () -> jobPostingService.create(request));
        assertEquals(exception.getMessage(), "존재하지 않는 회사입니다.");
    }

    @DisplayName("채용 공고를 수정할 수 있다.")
    @Test
    void update() {
        // given
        JobPostingUpdateRequest request = new JobPostingUpdateRequest(
                "백엔드 시니어 개발자",
                1000000,
                "원티드랩은 백엔드 시니어 개발자를 적극 채용합니다.",
                "java"
        );
        given(jobPostingRepository.findById(1L)).willReturn(Optional.of(new JobPosting(
                1L,
                "백엔드 주니어 개발자",
                1500000,
                "원티드랩은 백엔드 주니어 개발자를 채용합니다.",
                "java",
                null
        )));

        // when
        // then
        jobPostingService.update(1L, request);
    }

    @DisplayName("채용 공고를 수정할 때 채용 공고가 존재하지 않을 경우 오류를 반환한다.")
    @Test
    void update_fail() {
        // given
        JobPostingUpdateRequest request = new JobPostingUpdateRequest(
                "백엔드 주니어 개발자",
                1000000,
                "원티드랩은 백엔드 주니어 개발자를 적극 채용합니다.",
                "java"
        );
        given(jobPostingRepository.findById(1L)).willReturn(Optional.empty());

        // when
        // then
        JobPostingException exception = assertThrows(JobPostingException.class, () -> jobPostingService.update(1L, request));
        assertEquals(exception.getMessage(), "존재하지 않는 채용 공고입니다.");
    }
}