package com.digisphere.pontofacil.company.repository

import com.digisphere.pontofacil.company.domain.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : JpaRepository<Company, Long>
