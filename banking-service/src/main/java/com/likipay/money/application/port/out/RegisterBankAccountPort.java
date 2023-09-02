package com.likipay.money.application.port.out;


import com.likipay.money.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.likipay.money.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

  RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      RegisteredBankAccount.MembershipId membershipEmail,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
  );
}
