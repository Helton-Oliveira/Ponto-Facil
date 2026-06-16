package com.digisphere.pontofacil.company.domain

import com.digisphere.pontofacil.base.BaseEntity
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "com_companies")
@Table(name = "com_companies")
class Company(
  name: String,
  image: String,
  address: Address
) : BaseEntity() {

  var name: String = name
    protected set

  var image: String = image
    protected set

  @Embedded
  var address: Address = address
    protected set
}
