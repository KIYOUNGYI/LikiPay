package com.likipay.banking.application.service;

import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.likipay.banking.application.port.in.RegisterBankAccountCommand;
import com.likipay.banking.application.port.in.RegisterBankAccountUseCase;
import com.likipay.banking.application.port.out.RegisterBankAccountPort;
import com.likipay.banking.domain.RegisteredBankAccount;
import com.likipay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.likipay.banking.domain.RegisteredBankAccount.BankName;
import com.likipay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.likipay.banking.domain.RegisteredBankAccount.MembershipId;
import com.likipay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


//@Component
@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;


  @Override
  public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

    RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity = registerBankAccountPort.createRegisteredBankAccount(
        new MembershipId(command.getMembershipId()),
        new BankName(command.getBankName()),
        new BankAccountNumber(command.getBankAccountNumber()),
        new LinkedStatusIsValid(command.isValid())
    );

    RegisteredBankAccount registeredBankAccount = RegisteredBankAccountMapper.mapToDomainEntity(
        registeredBankAccountJpaEntity);

    return registeredBankAccount;
  }
}
