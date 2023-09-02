package com.likipay.banking.adapter.out.persistence;

import com.likipay.banking.application.port.out.RequestFirmBankingPort;
import com.likipay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import com.likipay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import com.likipay.banking.domain.FirmBankingRequest.FromBankName;
import com.likipay.banking.domain.FirmBankingRequest.MoneyAmount;
import com.likipay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import com.likipay.banking.domain.FirmBankingRequest.ToBankName;
import com.likipay.common.PersistenceAdapter;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestFirmBankingPersistenceAdapter implements RequestFirmBankingPort {

  private final SpringDataFirmBankingRequestRepository firmBankingRequestRepository;


  @Override
  public FirmBankingRequestJpaEntity createFirmBankingRequest(
      FromBankName fromBankName,
      FromBankAccountNumber fromBankAccountNumber,
      ToBankName toBankName,
      ToBankAccountNumber toBankAccountNumber,
      MoneyAmount moneyAmount,
      FirmBankingStatus firmBankingStatus
      ) {

    FirmBankingRequestJpaEntity save = firmBankingRequestRepository.save(
        new FirmBankingRequestJpaEntity(
            fromBankName.getFromBankName(),
            fromBankAccountNumber.getFromBankAccountNumber(),
            toBankName.getToBankName(),
            toBankAccountNumber.getToBankAccountNumber(),
            moneyAmount.getMoneyAmount(),
            firmBankingStatus.getFirmBankStatus(),
            UUID.randomUUID()
        )
    );

    return save;
  }

  @Override
  public FirmBankingRequestJpaEntity modifyFirmBankingRequest(FirmBankingRequestJpaEntity entity) {

    return firmBankingRequestRepository.save(entity);
  }
}
