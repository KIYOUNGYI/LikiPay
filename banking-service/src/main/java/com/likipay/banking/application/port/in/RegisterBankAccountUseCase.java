package com.likipay.banking.application.port.in;


import com.likipay.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

  RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
