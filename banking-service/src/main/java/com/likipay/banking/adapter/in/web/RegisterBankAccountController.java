package com.likipay.banking.adapter.in.web;

import com.likipay.banking.application.port.in.RegisterBankAccountCommand;
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

  @PostMapping("/membership/register")
  RegisteredBankAccount registerMembership(@RequestBody RegistereBankAccountRequest request) {

    //request~~

    //request -> command

    // usecase -> (request)

    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
        .membershipId(request.getMembershipId())
        .bankName(request.getBankName())
        .bankAccountNumber(request.getBankAccountNumber())
        .isValid(request.isValid())
        .build();

    return registerMembershipUseCase.registerBankAccount(command);

  }
}
