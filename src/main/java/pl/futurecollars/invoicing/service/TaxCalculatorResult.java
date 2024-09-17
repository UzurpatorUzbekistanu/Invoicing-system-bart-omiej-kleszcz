package pl.futurecollars.invoicing.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaxCalculatorResult {

  private final BigDecimal income;
  private final BigDecimal costs;
  private final BigDecimal incomeMinusCosts;
  private final BigDecimal pensionInsurance;
  private final BigDecimal incomeMinusCostsMinusPensionInsurance;
  private final BigDecimal incomeMinusCostsMinusPensionInsuranceRounded;
  private final BigDecimal incomeTax;
  private final BigDecimal healthInsurancePaid;
  private final BigDecimal healthInsuranceToSubtract;
  private final BigDecimal incomeTaxMinusHealthInsurance;
  private final BigDecimal finalIncomeTax;

  private final BigDecimal collectedVat;
  private final BigDecimal paidVat;
  private final BigDecimal vatToReturn;

  @JsonCreator
  public TaxCalculatorResult(
      @JsonProperty("income") BigDecimal income,
      @JsonProperty("costs") BigDecimal costs,
      @JsonProperty("incomeMinusCosts") BigDecimal incomeMinusCosts,
      @JsonProperty("pensionInsurance") BigDecimal pensionInsurance,
      @JsonProperty("incomeMinusCostsMinusPensionInsurance") BigDecimal incomeMinusCostsMinusPensionInsurance,
      @JsonProperty("incomeMinusCostsMinusPensionInsuranceRounded") BigDecimal incomeMinusCostsMinusPensionInsuranceRounded,
      @JsonProperty("incomeTax") BigDecimal incomeTax,
      @JsonProperty("healthInsurancePaid") BigDecimal healthInsurancePaid,
      @JsonProperty("healthInsuranceToSubtract") BigDecimal healthInsuranceToSubtract,
      @JsonProperty("incomeTaxMinusHealthInsurance") BigDecimal incomeTaxMinusHealthInsurance,
      @JsonProperty("finalIncomeTax") BigDecimal finalIncomeTax,
      @JsonProperty("collectedVat") BigDecimal collectedVat,
      @JsonProperty("paidVat") BigDecimal paidVat,
      @JsonProperty("vatToReturn") BigDecimal vatToReturn
  ) {
    this.income = income;
    this.costs = costs;
    this.incomeMinusCosts = incomeMinusCosts;
    this.pensionInsurance = pensionInsurance;
    this.incomeMinusCostsMinusPensionInsurance = incomeMinusCostsMinusPensionInsurance;
    this.incomeMinusCostsMinusPensionInsuranceRounded = incomeMinusCostsMinusPensionInsuranceRounded;
    this.incomeTax = incomeTax;
    this.healthInsurancePaid = healthInsurancePaid;
    this.healthInsuranceToSubtract = healthInsuranceToSubtract;
    this.incomeTaxMinusHealthInsurance = incomeTaxMinusHealthInsurance;
    this.finalIncomeTax = finalIncomeTax;
    this.collectedVat = collectedVat;
    this.paidVat = paidVat;
    this.vatToReturn = vatToReturn;
  }

}
