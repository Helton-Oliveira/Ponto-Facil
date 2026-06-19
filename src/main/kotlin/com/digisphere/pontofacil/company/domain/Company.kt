package com.digisphere.pontofacil.company.domain

import com.digisphere.pontofacil.config.root.BaseEntity
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity(name = "com_companies")
@Table(name = "com_companies")
class Company(
  name: String,
  email: String,
  phone: String,
  image: String,
  address: Address,
) : BaseEntity() {

  var name: String = name
    private set

  var email: String = email
    private set

  var phone: String = phone
    private set

  var image: String = image
    private set

  @Embedded
  var address: Address = address
    private set
}
