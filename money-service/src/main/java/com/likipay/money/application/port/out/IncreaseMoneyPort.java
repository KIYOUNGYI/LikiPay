package com.likipay.money.application.port.out;


import com.likipay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.likipay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.likipay.money.domain.MemberMoney;
import com.likipay.money.domain.MemberMoney.MoneyBalance;
import com.likipay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

  MoneyChangingRequestJpaEntity createMoneyChangingRequest(
      MoneyChangingRequest.TargetMembershipId targetMembershipId,
      MoneyChangingRequest.MoneyChangingType moneyChangingType,
      MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
      MoneyChangingRequest.Uuid uuid
  );

  MemberMoneyJpaEntity increaseMoney(
      MemberMoney.MembershipId memberId,
      int increaseMoneyAmount
  );

}
