package com.likipay.money.adapter.in.web;

import com.likipay.money.application.port.in.RegisterBankAccountCommand;
import com.likipay.money.application.port.in.RegisterBankAccountUseCase;
import com.likipay.money.domain.RegisteredBankAccount;
import com.likipay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankingAccountInfoController {


  private final RegisterBankAccountUseCase registerBankAccountUseCase;

  @PostMapping("/banking/account")
  RegisteredBankAccount registerBankingAccount(@RequestBody RegisterBankingAccountInfoRequest request) {

    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
        .membershipId(request.getMembershipId())
        .bankName(request.getBankName())
        .bankAccountNumber(request.getBankAccountNumber())
        .isValid(request.isValid())
        .build();

    RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
    if (registeredBankAccount == null) {
      //TODO : Error Handling
      return null;
    }
    return registerBankAccountUseCase.registerBankAccount(command);
  }
}
