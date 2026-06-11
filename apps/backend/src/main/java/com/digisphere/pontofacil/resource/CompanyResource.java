package com.digisphere.pontofacil.resource;

import com.digisphere.pontofacil.dtos.company.CompanyDTO;
import com.digisphere.pontofacil.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("api/companies")
public class CompanyResource {

  private final CompanyService companyService;

  public CompanyResource(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping
  public ResponseEntity<CompanyDTO> save(@RequestBody @Valid CompanyDTO dto) {
    return companyService.save(dto)
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.badRequest().build());
  }

  @GetMapping
  public ResponseEntity<Stream<CompanyDTO>> getAll() {
    return ResponseEntity.ok(companyService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompanyDTO> getById(@PathVariable Long id) {
    return companyService.getById(id)
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
