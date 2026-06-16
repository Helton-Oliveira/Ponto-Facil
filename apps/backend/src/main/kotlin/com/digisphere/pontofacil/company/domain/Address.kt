package com.digisphere.pontofacil.company.domain

import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
class Address(
  val street: String,
  val number: Int,
  val city: String,
  val neighborhood: String,
  @Enumerated(EnumType.STRING)
  val UF: UF
)
