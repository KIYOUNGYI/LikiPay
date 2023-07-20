package com.likipay.banking.application.port.out;

import com.likipay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.likipay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {

  FirmBankingRequestJpaEntity createFirmBankingRequest(
//      FirmBankingRequest.FirmBankingRequestId firmBankingRequestId,
      FirmBankingRequest.FromBankName fromBankName,
      FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
      FirmBankingRequest.ToBankName toBankName,
      FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
      FirmBankingRequest.MoneyAmount moneyAmount,
      FirmBankingRequest.FirmBankingStatus firmBankingStatus
  );

}
