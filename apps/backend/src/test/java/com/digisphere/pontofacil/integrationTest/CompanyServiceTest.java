package com.digisphere.pontofacil.integrationTest;

import com.digisphere.pontofacil.domain.adress.Address;
import com.digisphere.pontofacil.domain.adress.UF;
import com.digisphere.pontofacil.domain.company.Company;
import com.digisphere.pontofacil.dtos.company.CompanyDTO;
import com.digisphere.pontofacil.repository.CompanyRepository;
import com.digisphere.pontofacil.service.CompanyService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
public class CompanyServiceTest {

  @Autowired
  private CompanyService companyService;

  @Autowired
  private CompanyRepository companyRepository;

  private Address defaultAddress;

  @BeforeEach
  void setUp() {
    defaultAddress = new Address("Rua Teste", 123, "Cidade", "Bairro Teste", UF.SC);
  }

  @Nested
  @DisplayName("Cenários do método save")
  class SaveMethodTests {

    @Test
    @DisplayName("Deve salvar uma empresa com sucesso quando os dados forem válidos")
    @Commit
    void shouldSaveCompanySuccessfully() {
      // Arrange
      CompanyDTO dto = new CompanyDTO(null, "Empresa Alfa", "logo.png", defaultAddress);

      // Act
      Optional<CompanyDTO> savedDtoOpt = companyService.save(dto);

      // Assert
      assertThat(savedDtoOpt).isPresent();
      CompanyDTO savedDto = savedDtoOpt.get();
      assertThat(savedDto.id()).isNotNull();
      assertThat(savedDto.name()).isEqualTo("Empresa Alfa");

      // Verifica se realmente foi persistido no banco de dados
      boolean existsInDb = companyRepository.existsById(savedDto.id());
      assertThat(existsInDb).isTrue();
    }

    @Nested
    @DisplayName("Cenários do método getById")
    class GetByIdMethodTests {

      @Test
      @DisplayName("Deve retornar a empresa correta quando o ID existir no banco")
      void shouldReturnCompanyWhenIdExists() {
        // Arrange - Persistindo uma entidade direto via repositório para preparar o ambiente
        Company company = new Company(null, "Empresa Beta", "beta.png", defaultAddress);
        Company savedEntity = companyRepository.save(company);

        // Act
        Optional<CompanyDTO> foundDtoOpt = companyService.getById(savedEntity.getId());

        // Assert
        assertThat(foundDtoOpt).isPresent();
        assertThat(foundDtoOpt.get().id()).isEqualTo(savedEntity.getId());
        assertThat(foundDtoOpt.get().name()).isEqualTo("Empresa Beta");
      }

      @Test
      @DisplayName("Deve lançar NoSuchElementException quando o ID não existir no banco")
      void shouldThrowExceptionWhenIdDoesNotExist() {
        // Arrange
        Long nonExistingId = 999L;

        // Act & Assert
        assertThatThrownBy(() -> companyService.getById(nonExistingId))
          .isInstanceOf(NoSuchElementException.class);
        // O comportamento esperado do .orElseThrow() sem argumentos é lançar NoSuchElementException
      }
    }

    @Nested
    @DisplayName("Cenários do método getAll")
    class GetAllMethodTests {

      @Test
      @DisplayName("Deve retornar um stream com todas as empresas cadastradas")
      void shouldReturnStreamOfAllCompanies() {
        // Arrange - Limpa o estado se necessário e insere dados controlados
        companyRepository.deleteAll();

        Company c1 = new Company(null, "Empresa 1", "img1.png", defaultAddress);
        Company c2 = new Company(null, "Empresa 2", "img2.png", defaultAddress);
        companyRepository.saveAll(List.of(c1, c2));

        // Act
        List<CompanyDTO> resultList = companyService.getAll().collect(Collectors.toList());

        // Assert
        assertThat(resultList).hasSize(2);
        assertThat(resultList).extracting(CompanyDTO::name)
          .containsExactlyInAnyOrder("Empresa 1", "Empresa 2");
      }

      @Test
      @DisplayName("Deve retornar um stream vazio se não houver empresas no banco")
      void shouldReturnEmptyStreamWhenNoCompaniesExist() {
        // Arrange
        companyRepository.deleteAll();

        // Act
        List<CompanyDTO> resultList = companyService.getAll().collect(Collectors.toList());

        // Assert
        assertThat(resultList).isEmpty();
      }
    }
  }
}
