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
public class ModifyMemberShipCommand extends SelfValidating<RegisterBankAccountCommand> {


  @NotNull
  private final String membershipId;

  @NotNull
  private final String name;

  @NotNull
  private final String email;

  @NotNull
  @NotBlank
  private final String address;

  @AssertTrue
  private final boolean isValid;

  private final boolean isCorp;

  public ModifyMemberShipCommand(String membershipId, String name, String email, String address, boolean isValid, boolean isCorp) {
    this.membershipId = membershipId;
    this.name = name;
    this.email = email;
    this.address = address;
    this.isValid = isValid;
    this.isCorp = isCorp;
    this.validateSelf();
  }
}
