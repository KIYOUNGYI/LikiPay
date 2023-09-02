package com.likipay.money.application.port.out;


import com.likipay.money.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.likipay.money.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {

  FirmBankingRequestJpaEntity createFirmBankingRequest(
      FirmBankingRequest.FromBankName fromBankName,
      FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
      FirmBankingRequest.ToBankName toBankName,
      FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
      FirmBankingRequest.MoneyAmount moneyAmount,
      FirmBankingRequest.FirmBankingStatus firmBankingStatus
  );

  FirmBankingRequestJpaEntity modifyFirmBankingRequest(
      FirmBankingRequestJpaEntity entity
  );
}
