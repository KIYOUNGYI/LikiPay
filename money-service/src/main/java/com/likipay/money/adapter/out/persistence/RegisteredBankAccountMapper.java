package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

  public static MoneyChangingRequest mapToDomainEntity(
      RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {

    return MoneyChangingRequest.generateRegisteredBankAccount(
        new MoneyChangingRequest.RegisteredBankAccountId(registeredBankAccountJpaEntity.getRegisteredBankAccountId() + ""),
        new MoneyChangingRequest.MembershipId(registeredBankAccountJpaEntity.getMembershipId() + ""),
        new MoneyChangingRequest.BankName(registeredBankAccountJpaEntity.getBankName()),
        new MoneyChangingRequest.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
        new MoneyChangingRequest.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
    );
  }


}
