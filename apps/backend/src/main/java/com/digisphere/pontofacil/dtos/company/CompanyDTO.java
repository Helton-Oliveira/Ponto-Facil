package com.digisphere.pontofacil.dtos.company;

import com.digisphere.pontofacil.domain.adress.Address;
import com.digisphere.pontofacil.domain.company.Company;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompanyDTO(
  Long id,

  @NotBlank
  @Min(3)
  String name,

  String image,

  @NotNull
  Address address
) {

  public Company toEntity() {
    return new Company(
      id,
      name,
      image,
      address
    );
  }

}
