package com.likipay.banking.adapter.in.web;

import com.likipay.banking.application.port.in.FirmBankingRequestCommand;
import com.likipay.banking.application.port.in.RegisterBankAccountUseCase;
import com.likipay.banking.domain.RegisteredBankAccount;
import com.likipay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {


  private final RegisterBankAccountUseCase registerMembershipUseCase;

  @PostMapping("/banking/account/register")
  RegisteredBankAccount registerMembership(@RequestBody RegistereBankAccountRequest request) {

    //request~~

    //request -> command

    // usecase -> (request)

    FirmBankingRequestCommand command = FirmBankingRequestCommand.builder()
        .membershipId(request.getMembershipId())
        .bankName(request.getBankName())
        .bankAccountNumber(request.getBankAccountNumber())
        .isValid(request.isValid())
        .build();

    RegisteredBankAccount registeredBankAccount = registerMembershipUseCase.registerBankAccount(command);

    if (registeredBankAccount == null) {
      //TODO : Error handling
      return null;
    }
    return registeredBankAccount;
  }
}
