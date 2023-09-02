package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.FirmBankingRequest;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class RequestFirmBankingMapper {

  public static FirmBankingRequest mapToDomainEntity(
      FirmBankingRequestJpaEntity requestFirmBankingJpaEntity,
      UUID uuid
  ) {

    return FirmBankingRequest.generateFirmBankingRequest(
        new FirmBankingRequest.FirmBankingRequestId(requestFirmBankingJpaEntity.getRequestFirmBankingId()),
        new FirmBankingRequest.FromBankName(requestFirmBankingJpaEntity.getFromBankName()),
        new FirmBankingRequest.FromBankAccountNumber(requestFirmBankingJpaEntity.getFromBankAccountNumber()),
        new FirmBankingRequest.ToBankName(requestFirmBankingJpaEntity.getToBankName()),
        new FirmBankingRequest.ToBankAccountNumber(requestFirmBankingJpaEntity.getToBankAccountNumber()),
        new FirmBankingRequest.MoneyAmount(requestFirmBankingJpaEntity.getMoneyAmount()),
        new FirmBankingRequest.FirmBankingStatus(requestFirmBankingJpaEntity.getFirmBankingStatus()),
        uuid

    );
  }


}
