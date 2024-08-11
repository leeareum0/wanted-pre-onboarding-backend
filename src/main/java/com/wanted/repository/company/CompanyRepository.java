package com.wanted.repository.company;

import com.wanted.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findCompanyById(Long Id);

}
