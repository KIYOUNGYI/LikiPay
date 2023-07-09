package com.likipay.membership.application.port.in;

import com.likipay.membership.domain.Membership;

public interface ModifyMembershipUseCase {

  Membership modifyMembership(ModifyMemberShipCommand command);
}
