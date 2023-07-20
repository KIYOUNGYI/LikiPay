package com.likipay.banking.application.service;

import com.likipay.banking.adapter.out.persistence.RequestFirmBankingMapper;
import com.likipay.banking.application.port.in.FirmBankingRequestCommand;
import com.likipay.banking.application.port.in.RequestFirmBankingUseCase;
import com.likipay.banking.application.port.out.RequestFirmBankingPort;
import com.likipay.banking.domain.FirmBankingRequest;
import com.likipay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

//  private final RequestFirmBankingMapper requestFirmBankingMapper;

  private final RequestFirmBankingPort requestFirmBankingPort;


  @Override
  public FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand command) {

    //Business Logic

    //a->b 계좌

    // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로

    // 2. 외부 은행에 펌뱅킹 요청

    // 3. 결과에 따라서 1번에서 작성했던 FirmBankingRequest 정보를 update

    // 4. 결과를 return

    return null;
  }
}
