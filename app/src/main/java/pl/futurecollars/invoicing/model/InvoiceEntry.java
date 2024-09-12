package pl.futurecollars.invoicing.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEntry {

  @Schema(description = "Product/service description", example = "Dell laptop")
  private String description;

  @Schema(description = "Number of items", example = "85")
  private int quantity;

  @Schema(description = "Product/service price", example = "1234.12")
  private BigDecimal price;

  @Schema(description = "Product/service tax value", example = "123.45")
  private BigDecimal vatValue;

  @Schema(description = "Tax rate")
  private Vat vatRate;
}
