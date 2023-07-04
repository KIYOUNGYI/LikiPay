package com.likipay.membership.application.port.in;

import com.likipay.membership.adapter.in.web.RegisterMembershipRequest;

public interface RegisterMembershipUseCase {

  void registerMembership(RegisterMemberShipCommand command);
}
