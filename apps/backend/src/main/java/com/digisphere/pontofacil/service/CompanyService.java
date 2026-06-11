package com.digisphere.pontofacil.service;

import com.digisphere.pontofacil.domain.company.Company;
import com.digisphere.pontofacil.dtos.company.CompanyDTO;
import com.digisphere.pontofacil.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
public class CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Optional<CompanyDTO> save(CompanyDTO dto) {
    final var entity = dto.toEntity();

    return Optional.of(
      companyRepository
        .save(entity)
        .toDto()
    );
  }

  public Optional<CompanyDTO> getById(Long id) {
    return Optional.of(companyRepository.findById(id)
      .map(Company::toDto)
      .orElseThrow());
  }

  public Stream<CompanyDTO> getAll() {
    return companyRepository.findAll()
      .stream()
      .map(Company::toDto);
  }


}
