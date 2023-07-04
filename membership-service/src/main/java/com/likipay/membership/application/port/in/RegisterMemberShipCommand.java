package com.likipay.membership.application.port.in;

import common.SelfValidating;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMemberShipCommand extends SelfValidating<RegisterMemberShipCommand> {

  @NotNull
  private final String name;

//  private final String email;
//
//  private final String address;



  public RegisterMemberShipCommand(String name) {

    this.name = name;

    this.validateSelf();

  }


}
