package com.likipay.banking.adapter.out.persistence;

import com.likipay.banking.application.port.out.RegisterBankAccountPort;
import com.likipay.banking.application.port.out.RequestFirmBankingPort;
import com.likipay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import com.likipay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import com.likipay.banking.domain.FirmBankingRequest.FromBankName;
import com.likipay.banking.domain.FirmBankingRequest.MoneyAmount;
import com.likipay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import com.likipay.banking.domain.FirmBankingRequest.ToBankName;
import com.likipay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.likipay.banking.domain.RegisteredBankAccount.BankName;
import com.likipay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.likipay.banking.domain.RegisteredBankAccount.MembershipId;
import com.likipay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

  private final SpringDataRequestFirmBankingRepository firmBankingRepository;


  @Override
  public FirmBankingRequestJpaEntity createFirmBankingRequest(
      FromBankName fromBankName,
      FromBankAccountNumber fromBankAccountNumber,
      ToBankName toBankName,
      ToBankAccountNumber toBankAccountNumber,
      MoneyAmount moneyAmount,
      FirmBankingStatus firmBankingStatus) {

    FirmBankingRequestJpaEntity save = firmBankingRepository.save(
        new FirmBankingRequestJpaEntity(
            fromBankName.getFromBankName(),
            fromBankAccountNumber.getFromBankAccountNumber(),
            toBankName.getToBankName(),
            toBankAccountNumber.getToBankAccountNumber(),
            moneyAmount.getMoneyAmount(),
            firmBankingStatus.getFirmBankStatus()
        )
    );

    return save;
  }
}
