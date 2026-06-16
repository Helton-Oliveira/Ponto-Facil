package com.digisphere.pontofacil.company.api

import com.digisphere.pontofacil.company.domain.Address
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CompanyDTO(
  val id: Long? = null,

  @field:NotBlank
  @field:Size(min = 3)
  val name: String,

  val image: String,

  @field:NotNull
  val address: Address
)
