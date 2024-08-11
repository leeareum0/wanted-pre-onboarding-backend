package com.wanted.repository.jobposting;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wanted.dto.jobposting.response.JobPostingResponse;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.wanted.domain.company.QCompany.company;
import static com.wanted.domain.jobposting.QJobPosting.jobPosting;
import static org.springframework.util.StringUtils.hasText;

public class JobPostingRepositoryImpl implements JobPostingRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public JobPostingRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<JobPostingResponse> getList(String search) {
        return queryFactory.select(Projections.constructor(JobPostingResponse.class,
                        jobPosting.id,
                        company.name,
                        company.nation,
                        company.region,
                        jobPosting.position,
                        jobPosting.compensation,
                        jobPosting.tech
                ))
                .from(jobPosting)
                .join(jobPosting.company, company)
                .where(whereSearch(search))
                .fetch();
    }

    private BooleanExpression whereSearch(String search) {
        if (!hasText(search)) {
            return null;
        }
        return company.name.contains(search)
                .or(jobPosting.position.contains(search));
    }
}
