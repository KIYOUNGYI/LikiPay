package com.likipay.money.adapter.in.web;

import com.likipay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.likipay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.likipay.common.WebAdapter;
import com.likipay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankingAccountInfoController {


  private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

  @PostMapping("/money/increase/register")
  MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {

    IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
        .targetMembershipId(request.getTargetMembershipId())
        .amount(request.getAmount())
        .build();
    MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);

    MoneyChangingResultDetail result = new MoneyChangingResultDetail();

    return result;
  }

  @PostMapping("/money/decrease/register")
  MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {

//    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
//        .membershipId(request.getMembershipId())
//        .bankName(request.getBankName())
//        .bankAccountNumber(request.getBankAccountNumber())
//        .isValid(request.isValid())
//        .build();
//    MoneyChangingRequest registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
//    if (registeredBankAccount == null) {
//      //TODO : Error Handling
//      return null;
//    }
//    return registerBankAccountUseCase.registerBankAccount(command);
    return null;
  }
}
