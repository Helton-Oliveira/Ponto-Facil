package com.digisphere.pontofacil.domain.company;

import com.digisphere.pontofacil.domain.adress.Address;
import com.digisphere.pontofacil.dtos.company.CompanyDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "com_companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String image;

  @Embedded
  private Address address;

  public CompanyDTO toDto() {
    return new CompanyDTO(
      id,
      name,
      image,
      address
    );
  }
}
