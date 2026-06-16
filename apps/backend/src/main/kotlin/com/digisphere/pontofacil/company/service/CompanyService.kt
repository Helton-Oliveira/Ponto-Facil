package com.digisphere.pontofacil.company.service

import com.digisphere.pontofacil.company.api.CompanyDTO
import com.digisphere.pontofacil.company.repository.CompanyRepository
import com.digisphere.pontofacil.company.toDTO
import com.digisphere.pontofacil.company.toEntity
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CompanyService(private val repository: CompanyRepository) {

  private val logger = LoggerFactory.getLogger(javaClass)

  fun create(dto: CompanyDTO): Result<CompanyDTO> = runCatching {
    repository.save(dto.toEntity()).toDTO()
  }.onFailure {
    logger.error("Unexpected error while creating company", it)
  }

  @Transactional(readOnly = true)
  fun findById(id: Long): Result<CompanyDTO> = runCatching {

    val company = repository.findByIdOrNull(id)
    requireNotNull(company) { "Company not found with id: $id" }
    company.toDTO()

  }.onFailure {
    logger.error("Unexpected error while finding company by id: $id", it)
  }

  @Transactional(readOnly = true)
  fun findAll(): Result<List<CompanyDTO>> = runCatching {
    repository.findAll().map { it.toDTO() }
  }.onFailure {
    logger.error("Unexpected error while fetching all companies", it)
  }
}
