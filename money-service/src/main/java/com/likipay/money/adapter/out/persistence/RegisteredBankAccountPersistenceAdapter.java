package com.likipay.money.adapter.out.persistence;

import com.likipay.money.application.port.out.RegisterBankAccountPort;
import com.likipay.money.domain.MoneyChangingRequest.BankAccountNumber;
import com.likipay.money.domain.MoneyChangingRequest.BankName;
import com.likipay.money.domain.MoneyChangingRequest.LinkedStatusIsValid;
import com.likipay.money.domain.MoneyChangingRequest.MembershipId;
import com.likipay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

  private final SpringDataRegisteredBankAccountRepository bankAccountRepository;


  @Override
  public RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      MembershipId membershipId,
      BankName bankName,
      BankAccountNumber bankAccountNumber,
      LinkedStatusIsValid linkedStatusIsValid) {

    RegisteredBankAccountJpaEntity save = bankAccountRepository.save(
        new RegisteredBankAccountJpaEntity(
            membershipId.getMembershipId(),
            bankName.getBankName(),
            bankAccountNumber.getBankAccountNumber(),
            linkedStatusIsValid.isLinkedStatusIsValid()
        )

    );

    return save;
  }
}
