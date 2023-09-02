package com.likipay.money.application.port.in;

import com.likipay.money.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {


  FirmBankingRequest requestFirmBanking(FirmBankingRequestCommand command);
}
