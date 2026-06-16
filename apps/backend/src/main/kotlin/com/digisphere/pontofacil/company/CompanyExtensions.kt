package com.digisphere.pontofacil.company

import com.digisphere.pontofacil.company.api.CompanyDTO
import com.digisphere.pontofacil.company.domain.Company

fun Company.toDTO() = CompanyDTO(
  id = this.id,
  name = this.name,
  image = this.image,
  address = this.address
)

fun CompanyDTO.toEntity() = Company(
  name = this.name,
  image = this.image,
  address = this.address
)
