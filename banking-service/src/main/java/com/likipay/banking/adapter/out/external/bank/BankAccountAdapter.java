package com.likipay.banking.adapter.out.external.bank;

import com.likipay.banking.application.port.out.RequestBankAccountInfoPort;
import com.likipay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;


@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {


  @Override
  public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

    //실제 외부 은행에 http 통해서
    //실제 은행 계좌 가져오는게 FM 이나 편의상 이리 구현

    //항상 true 라는 가정하에
    return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
  }


}
