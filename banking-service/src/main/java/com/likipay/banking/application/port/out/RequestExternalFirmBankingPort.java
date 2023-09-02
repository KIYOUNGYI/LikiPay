package com.likipay.banking.application.port.out;

import com.likipay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.likipay.banking.adapter.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {

  FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest externalFirmBankingRequest);


}
