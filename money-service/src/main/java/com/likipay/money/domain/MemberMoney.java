package com.likipay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MemberMoney {

  @Getter
  private final String memberMoneyId;

  @Getter
  private final String membershipId;

  @Getter
  private final int balance;//잔액?

  public static MemberMoney generateMoneyChangingRequest(
      MemberMoneyId memberMoneyId,
      MembershipId membershipId,
      MoneyBalance moneyBalance
  ) {

    return new MemberMoney(
        memberMoneyId.getMemberMoneyId(),
        membershipId.getMembershipId(),
        moneyBalance.getMoneyBalance()
    );

  }

  @Value
  public static class MemberMoneyId {

    public MemberMoneyId(String memberMoneyId) {
      this.memberMoneyId = memberMoneyId;
    }

    String memberMoneyId;
  }

  @Value
  public static class MembershipId {

    public MembershipId(String membershipId) {
      this.membershipId = membershipId;
    }

    String membershipId;
  }

  @Value
  public static class MoneyBalance {

    public MoneyBalance(int balance) {
      this.moneyBalance = balance;
    }

    int moneyBalance;
  }

}
