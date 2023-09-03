package com.likipay.money.application.port.in;

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
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {


  @NotNull
  private final String targetMembershipId;

  @NotNull
  private final int amount;

  public IncreaseMoneyRequestCommand(@NotNull String targetMembershipId, @NotNull int amount) {
    this.targetMembershipId = targetMembershipId;
    this.amount = amount;
    this.validateSelf();
  }
}
