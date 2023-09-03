package com.likipay.money.application.service;


import com.likipay.common.UseCase;
import com.likipay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.likipay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.likipay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.likipay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.likipay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.likipay.money.application.port.out.IncreaseMoneyPort;
import com.likipay.money.domain.MemberMoney;
import com.likipay.money.domain.MoneyChangingRequest;
import com.likipay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.likipay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.likipay.money.domain.MoneyChangingRequest.Uuid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

  private final IncreaseMoneyPort increaseMoneyPort;

  private final MoneyChangingRequestMapper moneyChangingRequestMapper;


  @Override
  public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

    //머니의 충전, 증액이라는 과정
    // 1. 고객 정보 확인 (멤버 서비스)

    // 2. 고객 연동된 계좌 있는지, 그리고 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

    // 3. 법인 계좌 상태도 정상인 확인 (뱅킹)

    // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)

    // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (배킹)

    // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴

    // 성공 시에 멤버의 MemberMoney 값 증액이 필요해요

    // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴

    MemberMoneyJpaEntity memberMoneyJpaEntity = increaseMoneyPort.increaseMoney(
        new MemberMoney.MembershipId(command.getTargetMembershipId())
        ,command.getAmount());



    MoneyChangingRequestJpaEntity moneyChangingRequest = increaseMoneyPort.createMoneyChangingRequest(
        new TargetMembershipId(command.getTargetMembershipId()),
        new MoneyChangingType(1),
        new ChangingMoneyAmount(command.getAmount()),
        new MoneyChangingStatus(1),
        new Uuid(UUID.randomUUID())
    );

    MoneyChangingRequest moneyChangingRequest1 = MoneyChangingRequestMapper.mapToDomainEntity(moneyChangingRequest);



    return moneyChangingRequest1;
  }
}
