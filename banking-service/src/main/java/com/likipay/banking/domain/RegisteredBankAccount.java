package com.likipay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class RegisteredBankAccount {

  @Getter
  private final String registeredBankAccountId;

  @Getter
  private final String memberShipId;

  @Getter
  private final String bankName;

  @Getter
  private final String bankAccountNumber;

  @Getter
  private final boolean linkedStatusIsValid;

  public static RegisteredBankAccount generateRegisteredBankAccount(
      RegisteredBankAccount.RegisteredBankAccountId registeredBankAccountId,
      RegisteredBankAccount.MembershipId membershipId,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
  ) {

    return new RegisteredBankAccount(
        registeredBankAccountId.registeredBankAccountId,
        membershipId.membershipId,
        bankName.bankName,
        bankAccountNumber.bankAccountNumber,
        linkedStatusIsValid.linkedStatusIsValid
    );

  }

  @Value
  public static class RegisteredBankAccountId {

    public RegisteredBankAccountId(String value) {
      this.registeredBankAccountId = value;
    }

    String registeredBankAccountId;
  }

  // Membership 오염되면 안됨 (굳이 이렇게까지??)
  @Value
  public static class MembershipId {

    public MembershipId(String membershipId) {
      this.membershipId = membershipId;
    }

    String membershipId;
  }

  @Value
  public static class BankName {

    public BankName(String value) {
      this.bankName = value;
    }

    String bankName;
  }

  @Value
  public static class BankAccountNumber {

    public BankAccountNumber(String value) {
      this.bankAccountNumber = value;
    }

    String bankAccountNumber;
  }

  @Value
  public static class LinkedStatusIsValid {

    public LinkedStatusIsValid(boolean value) {
      this.linkedStatusIsValid = value;
    }

    boolean linkedStatusIsValid;
  }


}
