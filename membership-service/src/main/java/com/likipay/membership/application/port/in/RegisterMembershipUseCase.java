package com.likipay.membership.application.port.in;

import com.likipay.membership.adapter.in.web.RegisterMembershipRequest;
import com.likipay.membership.domain.Membership;
import common.UseCase;

//@UseCase
public interface RegisterMembershipUseCase {

  Membership registerMembership(RegisterMemberShipCommand command);
}
