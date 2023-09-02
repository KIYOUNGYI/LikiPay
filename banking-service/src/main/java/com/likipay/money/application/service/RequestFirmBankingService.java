package com.likipay.money.application.service;

import static com.likipay.money.domain.FirmBankingRequest.*;

import com.likipay.money.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.likipay.money.adapter.out.external.bank.FirmBankingResult;
import com.likipay.money.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.likipay.money.adapter.out.persistence.FirmBankingRequestMapper;
import com.likipay.money.application.port.in.FirmBankingRequestCommand;
import com.likipay.money.application.port.in.RequestFirmBankingUseCase;
import com.likipay.money.application.port.out.RequestExternalFirmBankingPort;
import com.likipay.money.application.port.out.RequestFirmBankingPort;
import com.likipay.money.domain.FirmBankingRequest;
import com.likipay.money.domain.FirmBankingRequest.FromBankAccountNumber;
import com.likipay.money.domain.FirmBankingRequest.FromBankName;
import com.likipay.money.domain.FirmBankingRequest.ToBankAccountNumber;
import com.likipay.money.domain.FirmBankingRequest.ToBankName;
import com.likipay.common.UseCase;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

  private final RequestFirmBankingPort requestFirmBankingPort;

  private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;


  @Override
  public FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand command) {


    // Business Logic
    // a->b 계좌

    // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로

    // 2. 외부 은행에 펌뱅킹 요청

    // 3. 결과에 따라서 1번에서 작성했던 FirmBankingRequest 정보를 Update

    // 4. 결과를 리턴

    FirmBankingRequestJpaEntity saved = requestFirmBankingPort.createFirmBankingRequest(
        new FromBankName(command.getFromBankName()),
        new FromBankAccountNumber(command.getFromBankAccountNumber()),
        new ToBankName(command.getToBankName()),
        new ToBankAccountNumber(command.getToBankAccountNumber()),
        new MoneyAmount(command.getMoneyAmount()),
        new FirmBankingStatus(0)
    );

    FirmBankingResult externalFirmBankingResult = requestExternalFirmBankingPort.requestExternalFirmBanking(
        new ExternalFirmBankingRequest(
            command.getFromBankName(),
            command.getFromBankAccountNumber(),
            command.getToBankName(),
            command.getToBankAccountNumber()
        )
    );

    UUID randomUUID = UUID.randomUUID();
    saved.setUuid(randomUUID.toString());

    if (externalFirmBankingResult.getResultCode() == 0) {

      saved.setFirmBankingStatus(1);
    } else {

      saved.setFirmBankingStatus(0);
    }

    // 5. 결과를 저장하기 전에 바뀐 상태 값을 기준으로 다시 save
    FirmBankingRequestJpaEntity result = requestFirmBankingPort.modifyFirmBankingRequest(saved);


    FirmBankingRequest firmBankingRequest = FirmBankingRequestMapper.mapToDomainEntity(result, randomUUID);
    return firmBankingRequest;
  }


}
