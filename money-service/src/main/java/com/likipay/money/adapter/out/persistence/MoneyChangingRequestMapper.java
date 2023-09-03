package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.MoneyChangingRequest;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingType;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {

  public static MoneyChangingRequest mapToDomainEntity(
      MoneyChangingRequestJpaEntity entity) {

    return MoneyChangingRequest.generateMoneyChangingRequest(
        new MoneyChangingRequest.MoneyChangingRequestId(entity.getMoneyChangingRequestId() + ""),
        new MoneyChangingRequest.TargetMembershipId(entity.getTargetMembershipId() + ""),
        new MoneyChangingType(entity.getMoneyChangingType()),
        new MoneyChangingRequest.ChangingMoneyAmount(entity.getMoneyAmount()),
        new MoneyChangingRequest.MoneyChangingStatus(entity.getChangingMoneyStatus()),
        new MoneyChangingRequest.Uuid(entity.getUuid())

    );
  }


}
