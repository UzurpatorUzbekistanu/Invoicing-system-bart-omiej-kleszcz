package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Company {

  @ApiModelProperty(value = "Tax id number", required = true, example = "123-123-123")
  private String taxIdentification;
  @ApiModelProperty(value = "Company address", required = true, example = "Abbey Road str. 123, 11-111 London")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "Invoice house Company")
  private String name;

  public Company(String taxIdentification, String address, String name) {
    this.taxIdentification = taxIdentification;
    this.address = address;
    this.name = name;
  }
}
