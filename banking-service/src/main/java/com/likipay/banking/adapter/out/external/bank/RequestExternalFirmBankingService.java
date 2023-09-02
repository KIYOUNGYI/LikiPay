package com.likipay.banking.adapter.out.external.bank;

import com.likipay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.likipay.common.ExternalSystemAdapter;
import org.springframework.stereotype.Service;

//@Service
@ExternalSystemAdapter
public class RequestExternalFirmBankingService implements RequestExternalFirmBankingPort {

  @Override
  public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {
    // 실제로 외부 은행에 http 통신을 통해서
    // 펌뱅킹 요청을 하고

    // 그 결과를
    // 외부 은행의 실제 결과를 -> 패캠 페이의 FirmBankingResult 파싱
    return new FirmBankingResult(0);
  }
}
