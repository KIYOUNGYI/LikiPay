package com.likipay.banking.application.service;

import com.likipay.banking.adapter.out.external.bank.BankAccount;
import com.likipay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.likipay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.likipay.banking.application.port.in.RegisterBankAccountCommand;
import com.likipay.banking.application.port.in.RegisterBankAccountUseCase;
import com.likipay.banking.application.port.out.RegisterBankAccountPort;
import com.likipay.banking.application.port.out.RequestBankAccountInfoPort;
import com.likipay.banking.domain.RegisteredBankAccount;
import com.likipay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.likipay.banking.domain.RegisteredBankAccount.BankName;
import com.likipay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.likipay.banking.domain.RegisteredBankAccount.MembershipId;
import com.likipay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;

  private final RequestBankAccountInfoPort requestBankAccountInfoPort;

  private final RegisteredBankAccountMapper registeredBankAccountMapper;

  @Override
  public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

    //은행 계좌를 등록해야하는 서비스 (비즈니스 로직)

    //1.등록된 계좌인지 확인한다.
    //외부의 은행에 이 계좌 정상인지? 확인을 해야해요.
    //Biz Logic -> External System
    // Port -> Adapter -> External System

    String bankName = command.getBankName();
    String bankAccountNumber = command.getBankAccountNumber();

    BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));

    //2. 등록가능한 계좌라면, 등록한다.
    //2-1 등록가능하지 않은 계좌라면, 에러를 리턴

    if (accountInfo.isValid() == true) {

      RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
          new MembershipId(command.getMembershipId() + ""),
          new BankName(command.getBankName() + ""),
          new BankAccountNumber(command.getBankAccountNumber() + ""),
          new LinkedStatusIsValid(command.isValid())
      );

      return RegisteredBankAccountMapper.mapToDomainEntity(savedAccountInfo);

    } else {

      return null;
    }

  }
}
