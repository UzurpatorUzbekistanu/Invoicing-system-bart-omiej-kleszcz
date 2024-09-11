package pl.futurecollars.invoicing.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company {

  @Schema(description = "Tax id number", example = "123-123-123")
  private String taxIdentification;

  @Schema(description = "Company address", example = "Abbey Road str. 123, 11-111 London")
  private String address;

  @Schema(description = "Company name", example = "Invoice house Company")
  private String name;

  public Company(String taxIdentification, String address, String name) {
    this.taxIdentification = taxIdentification;
    this.address = address;
    this.name = name;
  }
}
