package com.likipay.money.application.port.in;


import com.likipay.money.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

  RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
