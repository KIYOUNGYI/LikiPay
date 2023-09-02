package com.likipay.banking.application.port.in;

import com.likipay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {


  FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand command);
}
