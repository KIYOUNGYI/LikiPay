package com.likipay.banking.application.port.in;

import com.likipay.common.SelfValidating;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

  private String membershipId;
  private String bankName;
  private String bankAccountNumber;
  private boolean isValid;

  public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber,
      boolean isValid) {
    this.membershipId = membershipId;
    this.bankName = bankName;
    this.bankAccountNumber = bankAccountNumber;
    this.isValid = isValid;

    this.validateSelf();
  }
}
