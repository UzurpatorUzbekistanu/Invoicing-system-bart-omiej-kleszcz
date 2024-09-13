package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntry {

  @ApiModelProperty(value = "Product/service description", required = true, example = "Dell laptop")
  private String description;
  @ApiModelProperty(value = "Number of items", required = true, example = "85")
  private int quantity;
  @ApiModelProperty(value = "Product/service price", required = true, example = "1234.12")
  private BigDecimal price;
  @ApiModelProperty(value = "Product/service tax value", required = true, example = "123.45")
  private BigDecimal vatValue;
  @ApiModelProperty(value = "Tax rate", required = true)
  private Vat vatRate;

}
