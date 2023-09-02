package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

  public static RegisteredBankAccount mapToDomainEntity(
      RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {

    return RegisteredBankAccount.generateRegisteredBankAccount(
        new RegisteredBankAccount.RegisteredBankAccountId(registeredBankAccountJpaEntity.getRegisteredBankAccountId() + ""),
        new RegisteredBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId() + ""),
        new RegisteredBankAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
        new RegisteredBankAccount.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
        new RegisteredBankAccount.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
    );
  }


}
