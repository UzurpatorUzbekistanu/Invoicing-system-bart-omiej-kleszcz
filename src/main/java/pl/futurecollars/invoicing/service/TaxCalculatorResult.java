package pl.futurecollars.invoicing.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
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
      @JsonProperty("income") double income,
      @JsonProperty("costs") double costs,
      @JsonProperty("incomeMinusCosts") double incomeMinusCosts,
      @JsonProperty("pensionInsurance") double pensionInsurance,
      @JsonProperty("incomeMinusCostsMinusPensionInsurance") double incomeMinusCostsMinusPensionInsurance,
      @JsonProperty("incomeMinusCostsMinusPensionInsuranceRounded") double incomeMinusCostsMinusPensionInsuranceRounded,
      @JsonProperty("incomeTax") double incomeTax,
      @JsonProperty("healthInsurancePaid") double healthInsurancePaid,
      @JsonProperty("healthInsuranceToSubtract") double healthInsuranceToSubtract,
      @JsonProperty("incomeTaxMinusHealthInsurance") double incomeTaxMinusHealthInsurance,
      @JsonProperty("finalIncomeTax") double finalIncomeTax,
      @JsonProperty("collectedVat") double collectedVat,
      @JsonProperty("paidVat") double paidVat,
      @JsonProperty("vatToReturn") double vatToReturn
  ) {
    this.income = BigDecimal.valueOf(income);
    this.costs = BigDecimal.valueOf(costs);
    this.incomeMinusCosts = BigDecimal.valueOf(incomeMinusCosts);
    this.pensionInsurance = BigDecimal.valueOf(pensionInsurance);
    this.incomeMinusCostsMinusPensionInsurance = BigDecimal.valueOf(incomeMinusCostsMinusPensionInsurance);
    this.incomeMinusCostsMinusPensionInsuranceRounded = BigDecimal.valueOf(incomeMinusCostsMinusPensionInsuranceRounded);
    this.incomeTax = BigDecimal.valueOf(incomeTax);
    this.healthInsurancePaid = BigDecimal.valueOf(healthInsurancePaid);
    this.healthInsuranceToSubtract = BigDecimal.valueOf(healthInsuranceToSubtract);
    this.incomeTaxMinusHealthInsurance = BigDecimal.valueOf(incomeTaxMinusHealthInsurance);
    this.finalIncomeTax = BigDecimal.valueOf(finalIncomeTax);
    this.collectedVat = BigDecimal.valueOf(collectedVat);
    this.paidVat = BigDecimal.valueOf(paidVat);
    this.vatToReturn = BigDecimal.valueOf(vatToReturn);
  }

}
