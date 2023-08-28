package com.likipay.banking.application.service;

import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.likipay.banking.application.port.in.RegisterBankAccountCommand;
import com.likipay.banking.application.port.in.RegisterBankAccountUseCase;
import com.likipay.banking.application.port.out.RegisterBankAccountPort;
import com.likipay.banking.domain.RegisteredBankAccount;
import com.likipay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;

  @Override
  public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

//    registerBankAccountPort.createRegisteredBankAccount(new BankingA)
    return null;
  }
}
