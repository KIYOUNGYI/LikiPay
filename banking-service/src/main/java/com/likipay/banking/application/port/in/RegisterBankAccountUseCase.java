package com.likipay.banking.application.port.in;

import com.likipay.banking.domain.RegisteredBankAccount;

//@UseCase
public interface RegisterBankAccountUseCase {

  RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
