package com.likipay.banking.application.port.in;

import com.likipay.membership.domain.Membership;

public interface FindMembershipUseCase {

  Membership findMembership(FindMembershipCommand command);




}
