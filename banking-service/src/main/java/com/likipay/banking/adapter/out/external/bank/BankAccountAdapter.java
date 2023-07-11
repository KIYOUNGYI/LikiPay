package com.likipay.banking.adapter.out.external.bank;

import com.likipay.banking.application.port.out.RequestBankAccountInfoPort;
import com.likipay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;


@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {


  @Override
  public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
    return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
  }
}
