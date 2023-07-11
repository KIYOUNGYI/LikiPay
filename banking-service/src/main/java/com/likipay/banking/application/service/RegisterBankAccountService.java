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


//@Component
@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;

  private final RequestBankAccountInfoPort requestBankAccountInfoPort;

  @Override
  public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

    // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)
    // command.getMembershipId() //<- 사실은 membershipId 도 유효한지 검증하는 API 가 있긴 해야함 (근데 지금은 생략)




    // 1. 등록된 계좌인지 확인한다.
    // 외부의 은행에 이 계좌 정상인지? 확인을 해야해요
    // Biz Logic -> External System
    // Port -> Adapter -> External System

    command.getBankName();
    command.getBankAccountNumber();

    //실제 외부의 은행 계좌 정보를 Get
    BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));


    // 2. 등록가능한 꼐좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
    // 2-1. 등록가능하지 않은 계좌라면 에러를 리턴

    if (accountInfo.isValid()) {
      RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity = registerBankAccountPort
          .createRegisteredBankAccount(
              new MembershipId(command.getMembershipId()),
              new BankName(command.getBankName()),
              new BankAccountNumber(command.getBankAccountNumber()),
              new LinkedStatusIsValid(command.isValid())
          );

      RegisteredBankAccount registeredBankAccount = RegisteredBankAccountMapper.mapToDomainEntity(
          registeredBankAccountJpaEntity);
      return registeredBankAccount;
    } else {
      return null;

    }

  }
}
