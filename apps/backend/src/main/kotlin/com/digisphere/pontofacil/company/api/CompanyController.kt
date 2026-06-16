package com.digisphere.pontofacil.company.api

import com.digisphere.pontofacil.company.service.CompanyService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/companies")
class CompanyController(private val service: CompanyService) {

  @PostMapping
  fun create(@RequestBody @Valid dto: CompanyDTO): ResponseEntity<CompanyDTO> =
    service.create(dto).fold(
      onSuccess = { ResponseEntity.status(HttpStatus.CREATED).body(it) },
      onFailure = { throw it }
    )

  @GetMapping("/{id}")
  fun findById(@PathVariable id: Long): ResponseEntity<CompanyDTO> =
    service.findById(id).fold(
      onSuccess = { ResponseEntity.ok(it) },
      onFailure = { throw it }
    )

  @GetMapping
  fun findAll(): ResponseEntity<List<CompanyDTO>> =
    service.findAll().fold(
      onSuccess = { ResponseEntity.ok(it) },
      onFailure = { throw it }
    )
}
