package com.likipay.money.application.port.in;


import com.likipay.money.domain.MoneyChangingRequest;

public interface RegisterBankAccountUseCase {

  MoneyChangingRequest registerBankAccount(RegisterBankAccountCommand command);
}
