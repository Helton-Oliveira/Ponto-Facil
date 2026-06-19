package com.digisphere.pontofacil.company

import com.digisphere.pontofacil.company.api.CompanyDTO
import com.digisphere.pontofacil.company.domain.Company

fun Company.toDTO() = CompanyDTO(
  id = this.id,
  name = this.name,
  email = this.email,
  phone = this.phone,
  image = this.image,
  address = this.address,
  edited = false,
)

fun CompanyDTO.toEntity() = Company(
  name = this.name,
  email = this.email,
  phone = this.phone,
  image = this.image,
  address = this.address,
).apply { id = this@toEntity.id }
