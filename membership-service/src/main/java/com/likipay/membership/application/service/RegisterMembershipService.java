package com.likipay.membership.application.service;

import com.likipay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.likipay.membership.adapter.out.persistence.MembershipMapper;
import com.likipay.membership.application.port.in.RegisterMemberShipCommand;
import com.likipay.membership.application.port.in.RegisterMembershipUseCase;
import com.likipay.membership.application.port.out.RegisterMembershipPort;
import com.likipay.membership.domain.Membership;
import com.likipay.membership.domain.Membership.MembershipAddress;
import com.likipay.membership.domain.Membership.MembershipEmail;
import com.likipay.membership.domain.Membership.MembershipIsCorp;
import com.likipay.membership.domain.Membership.MembershipIsValid;
import com.likipay.membership.domain.Membership.MembershipName;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//@Component
@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

  private final RegisterMembershipPort registerMembershipPort;



  @Override
  public Membership registerMembership(RegisterMemberShipCommand command) {

    //command -> DB

    //biz logic -> db
    //external system
    //port, adapter
    MembershipJpaEntity membershipJpaEntity = registerMembershipPort.createMembership(
        new MembershipName(command.getName()),
        new MembershipEmail(command.getEmail()),
        new MembershipAddress(command.getAddress()),
        new MembershipIsValid(command.isValid()),
        new MembershipIsCorp(command.isCorp())
    );

    //entity -> membership (변환 필요)
    Membership membership = MembershipMapper.mapToDomainEntity(membershipJpaEntity);
    return membership;
  }
}
