package com.likipay.banking.adapter.out.persistence;

import com.likipay.banking.application.port.out.RegisterBankAccountPort;
import com.likipay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.likipay.banking.domain.RegisteredBankAccount.BankName;
import com.likipay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.likipay.banking.domain.RegisteredBankAccount.MembershipId;
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

    return bankAccountRepository.save(new RegisteredBankAccountJpaEntity(
        membershipId.getMembershipId(),
        bankName.getBankName(),
        bankAccountNumber.getBankAccountNumber(),
        linkedStatusIsValid.isLinkedStatusIsValid()
    ));
  }
}
