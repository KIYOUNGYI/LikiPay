package com.likipay.money.application.port.out;


import com.likipay.money.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.likipay.money.domain.MoneyChangingRequest;

public interface RegisterBankAccountPort {

  RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      MoneyChangingRequest.MembershipId membershipEmail,
      MoneyChangingRequest.BankName bankName,
      MoneyChangingRequest.BankAccountNumber bankAccountNumber,
      MoneyChangingRequest.LinkedStatusIsValid linkedStatusIsValid
  );
}
