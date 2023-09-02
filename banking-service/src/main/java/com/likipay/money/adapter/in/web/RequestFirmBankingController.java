package com.likipay.money.adapter.in.web;

import com.likipay.money.application.port.in.FirmBankingRequestCommand;
import com.likipay.money.application.port.in.RequestFirmBankingUseCase;
import com.likipay.money.domain.FirmBankingRequest;
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

  @PostMapping("/banking/firmbanking/request")
  FirmBankingRequest firmBankingRequest(@RequestBody RequestFirmBankingRequest request) {

//    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
//        .membershipId(request.getMembershipId())
//        .bankName(request.getBankName())
//        .bankAccountNumber(request.getBankAccountNumber())
//        .isValid(request.isValid())
//        .build();
//
//    RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
//    if (registeredBankAccount == null) {
//      //TODO : Error Handling
//      return null;
//    }
//    return registerBankAccountUseCase.registerBankAccount(command);

    FirmBankingRequestCommand command = FirmBankingRequestCommand
        .builder()
        .fromBankName(request.getFromBankName())
        .fromBankAccountNumber(request.getFromBankAccountNumber())
        .toBankName(request.getToBankName())
        .toBankAccountNumber(request.getToBankAccountNumber())
        .build();

    FirmBankingRequest firmBankingRequest = requestFirmBankingUseCase.requestFirmBanking(command);
    return firmBankingRequest;
  }
}
