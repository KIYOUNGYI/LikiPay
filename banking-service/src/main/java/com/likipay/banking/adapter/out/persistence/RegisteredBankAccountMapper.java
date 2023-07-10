package com.likipay.banking.adapter.out.persistence;

import com.likipay.banking.domain.RegisteredBankAccount;
import com.likipay.banking.domain.RegisteredBankAccount.RegisteredBankAccountId;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

  public static RegisteredBankAccount mapToDomainEntity(
      RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {

    return RegisteredBankAccount.generateRegisteredBankAccount(
        new RegisteredBankAccount.RegisteredBankAccountId(
            registeredBankAccountJpaEntity.getMembershipId() + ""),
        new RegisteredBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId()),
        new RegisteredBankAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
        new RegisteredBankAccount.BankAccountNumber(
            registeredBankAccountJpaEntity.getBankAccountNumber()),
        new RegisteredBankAccount.LinkedStatusIsValid(
            registeredBankAccountJpaEntity.isLinkedStatusIsValid())
    );
  }


}
