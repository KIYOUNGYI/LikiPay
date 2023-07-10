package com.likipay.banking.application.port.out;


import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.likipay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

  RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      RegisteredBankAccount.MembershipId membershipEmail,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
  );
}
