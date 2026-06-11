package com.digisphere.pontofacil.domain.adress;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private String street;
  private Integer number;
  private String city;
  private String neighborhood;

  @Enumerated(EnumType.STRING)
  private UF UF;

}
