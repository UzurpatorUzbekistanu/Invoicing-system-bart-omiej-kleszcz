package pl.futurecollars.invoicing.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaxCalculatorResult {

  private final BigDecimal income;
  private final BigDecimal costs;
  private final BigDecimal earnings;
  private final BigDecimal incomingVat;
  private final BigDecimal outgoingVat;
  private final BigDecimal vatToReturn;

  @JsonCreator
  public TaxCalculatorResult(
      @JsonProperty("income") BigDecimal income,
      @JsonProperty("costs") BigDecimal costs,
      @JsonProperty("earnings") BigDecimal earnings,
      @JsonProperty("incomingVat") BigDecimal incomingVat,
      @JsonProperty("outgoingVat") BigDecimal outgoingVat,
      @JsonProperty("vatToReturn") BigDecimal vatToReturn
  ) {
    this.income = income;
    this.costs = costs;
    this.earnings = earnings;
    this.incomingVat = incomingVat;
    this.outgoingVat = outgoingVat;
    this.vatToReturn = vatToReturn;
  }
}
