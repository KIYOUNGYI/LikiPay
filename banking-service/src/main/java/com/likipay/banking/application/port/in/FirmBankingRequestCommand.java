package com.likipay.banking.application.port.in;

import com.likipay.common.SelfValidating;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class FirmBankingRequestCommand extends SelfValidating<FirmBankingRequestCommand> {

  @NotNull
  private final String fromBankName;
  @NotNull
  private final String fromBankAccountNumber;
  @NotNull
  private final String toBankName;
  @NotNull
  private final String toBankAccountNumber;

  private final int moneyAmount;

  public FirmBankingRequestCommand(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount) {
    this.fromBankName = fromBankName;
    this.fromBankAccountNumber = fromBankAccountNumber;
    this.toBankName = toBankName;
    this.toBankAccountNumber = toBankAccountNumber;
    this.moneyAmount = moneyAmount;
    this.validateSelf();
  }
}
