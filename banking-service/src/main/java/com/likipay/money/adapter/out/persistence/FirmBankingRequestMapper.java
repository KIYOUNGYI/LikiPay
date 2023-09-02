package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.FirmBankingRequest;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class FirmBankingRequestMapper {

  public static FirmBankingRequest mapToDomainEntity(
      FirmBankingRequestJpaEntity firmBankingRequestJpaEntity,
      UUID uuid
      ) {

    return FirmBankingRequest.generateFirmBankingRequest(
        new FirmBankingRequest.FirmBankingRequestId(firmBankingRequestJpaEntity.getRequestFirmBankingId()),
        new FirmBankingRequest.FromBankName(firmBankingRequestJpaEntity.getFromBankName()),
        new FirmBankingRequest.FromBankAccountNumber(firmBankingRequestJpaEntity.getFromBankAccountNumber()),
        new FirmBankingRequest.ToBankName(firmBankingRequestJpaEntity.getToBankName()),
        new FirmBankingRequest.ToBankAccountNumber(firmBankingRequestJpaEntity.getToBankAccountNumber()),
        new FirmBankingRequest.MoneyAmount(firmBankingRequestJpaEntity.getMoneyAmount()),
        new FirmBankingRequest.FirmBankingStatus(firmBankingRequestJpaEntity.getFirmBankingStatus()),
        uuid
    );
  }


}
