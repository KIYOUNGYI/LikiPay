package com.likipay.banking.application.port.in;

import com.likipay.common.SelfValidating;
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

  @NotNull
  private final String membershipId;

  @NotNull
  private final String bankName;

  @NotNull
  @NotBlank
  private final String bankAccountNumber;

  @NotNull
  private final boolean isValid;

  public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber, boolean isValid) {
    this.membershipId = membershipId;
    this.bankName = bankName;
    this.bankAccountNumber = bankAccountNumber;
    this.isValid = isValid;

    this.validateSelf();
  }
}
