package com.likipay.banking.application.port.out;

import com.likipay.banking.adapter.out.external.bank.BankAccount;
import com.likipay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

  BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
