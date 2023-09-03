package com.likipay.money.adapter.out.persistence;

import com.likipay.money.application.port.out.IncreaseMoneyPort;
import com.likipay.common.PersistenceAdapter;
import com.likipay.money.domain.MemberMoney.MembershipId;
import com.likipay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.likipay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.likipay.money.domain.MoneyChangingRequest.Uuid;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

  private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

  private final SpringDataMemberMoneyRepository memberMoneyRepository;

  @Override
  public MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      TargetMembershipId targetMembershipId,
      MoneyChangingType moneyChangingType,
      ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingStatus moneyChangingStatus,
      Uuid uuid) {

    MoneyChangingRequestJpaEntity save = moneyChangingRequestRepository.save(
        new MoneyChangingRequestJpaEntity(
            targetMembershipId.getTargetMembershipId(),
            moneyChangingType.getMoneyChangingType(),
            changingMoneyAmount.getChangingMoneyAmount(),
            new Timestamp(System.currentTimeMillis()),
            moneyChangingStatus.getChangingMoneyStatus(),
            UUID.randomUUID()
        )
    );

    return save;
  }

  @Override
  public MemberMoneyJpaEntity increaseMoney(MembershipId memberId, int increaseMoneyAmount) {
    MemberMoneyJpaEntity entity;
    try {
      List<MemberMoneyJpaEntity> entityList =  memberMoneyRepository.findByMembershipId(Long.parseLong(memberId.getMembershipId()));
      entity = entityList.get(0);

      entity.setBalance(entity.getBalance() + increaseMoneyAmount);
      return  memberMoneyRepository.save(entity);
    } catch (Exception e){
      entity = new MemberMoneyJpaEntity(
          Long.parseLong(memberId.getMembershipId()),
          increaseMoneyAmount
      );
      entity = memberMoneyRepository.save(entity);
      return entity;
    }

  }
}
