package com.likipay.money.application.port.out;

import com.likipay.money.adapter.out.external.bank.BankAccount;
import com.likipay.money.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

  BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
