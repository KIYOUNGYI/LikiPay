package com.likipay.money.application.port.out;

import com.likipay.money.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.likipay.money.adapter.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {

  FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest externalFirmBankingRequest);


}
