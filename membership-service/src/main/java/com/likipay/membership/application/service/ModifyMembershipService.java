package com.likipay.membership.application.service;

import com.likipay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.likipay.membership.adapter.out.persistence.MembershipMapper;
import com.likipay.membership.application.port.in.ModifyMemberShipCommand;
import com.likipay.membership.application.port.in.ModifyMembershipUseCase;
import com.likipay.membership.application.port.in.RegisterMemberShipCommand;
import com.likipay.membership.application.port.in.RegisterMembershipUseCase;
import com.likipay.membership.application.port.out.ModifyMembershipPort;
import com.likipay.membership.application.port.out.RegisterMembershipPort;
import com.likipay.membership.domain.Membership;
import com.likipay.membership.domain.Membership.MembershipAddress;
import com.likipay.membership.domain.Membership.MembershipEmail;
import com.likipay.membership.domain.Membership.MembershipId;
import com.likipay.membership.domain.Membership.MembershipIsCorp;
import com.likipay.membership.domain.Membership.MembershipIsValid;
import com.likipay.membership.domain.Membership.MembershipName;
import com.likipay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


//@Component
@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

  private final ModifyMembershipPort modifyMembershipPort;


  @Override
  public Membership modifyMembership(ModifyMemberShipCommand command) {

    System.out.println("command =>> " + command);
    //command -> DB

    //biz logic -> db
    //external system
    //port, adapter
    MembershipJpaEntity membershipJpaEntity = modifyMembershipPort.modifyMembership(
        new MembershipId(command.getMembershipId()),
        new MembershipName(command.getName()),
        new MembershipEmail(command.getEmail()),
        new MembershipAddress(command.getAddress()),
        new MembershipIsValid(command.isValid()),
        new MembershipIsCorp(command.isCorp())
    );
    System.out.println("membershipJpaEntity =>> " + membershipJpaEntity);
    //entity -> membership (변환 필요)
    Membership membership = MembershipMapper.mapToDomainEntity(membershipJpaEntity);
    System.out.println("membership =>> " + membership);
    return membership;
  }
}
