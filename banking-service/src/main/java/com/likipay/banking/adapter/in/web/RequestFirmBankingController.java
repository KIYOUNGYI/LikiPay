package com.likipay.banking.adapter.in.web;

import com.likipay.banking.application.port.in.FirmBankingRequestCommand;
import com.likipay.banking.application.port.in.RequestFirmBankingUseCase;
import com.likipay.banking.domain.FirmBankingRequest;
import com.likipay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {


  private final RequestFirmBankingUseCase requestFirmBankingUseCase;

  @PostMapping("/banking/firmBanking/reguest")
  FirmBankingRequest registerMembership(@RequestBody RequestFirmBankingRequest request) {

    //request~~

    //request -> command

    // usecase -> (request)

    FirmBankingRequestCommand command = FirmBankingRequestCommand.builder()
        .fromBankName(request.getFromBankName())
        .fromBankAccountNumber(request.getFromBankAccountNumber())
        .toBankName(request.getToBankName())
        .toBankAccountNumber(request.getToBankAccountNumber())
        .moneyAmount(request.getMoneyAmount())
        .build();

    FirmBankingRequest firmBankingRequest = requestFirmBankingUseCase.requestFirmBanking(command);

    if (firmBankingRequest == null) {
      //TODO : Error handling
      return null;
    }
    return firmBankingRequest;
  }
}
