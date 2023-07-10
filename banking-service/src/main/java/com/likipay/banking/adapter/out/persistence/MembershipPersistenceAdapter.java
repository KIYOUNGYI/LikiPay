package com.likipay.banking.adapter.out.persistence;

import com.likipay.common.PersistenceAdapter;
import com.likipay.membership.application.port.out.FindMembershipPort;
import com.likipay.membership.application.port.out.ModifyMembershipPort;
import com.likipay.membership.application.port.out.RegisterMembershipPort;
import com.likipay.membership.domain.Membership.MembershipAddress;
import com.likipay.membership.domain.Membership.MembershipEmail;
import com.likipay.membership.domain.Membership.MembershipId;
import com.likipay.membership.domain.Membership.MembershipIsCorp;
import com.likipay.membership.domain.Membership.MembershipIsValid;
import com.likipay.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

  private final SpringDataMembershipRepository membershipRepository;

  @Override
  public MembershipJpaEntity createMembership(MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
      MembershipIsCorp membershipIsCorp) {

    MembershipJpaEntity save = membershipRepository.save(
        new MembershipJpaEntity(
            membershipName.getName(),
            membershipEmail.getEmailValue(),
            membershipAddress.getAddressValue(),
            membershipIsValid.isValidValue(),
            membershipIsCorp.isCorpValue()
        )
    );

    return save;

  }

  @Override
  public MembershipJpaEntity findMembership(MembershipId membershipId) {

    MembershipJpaEntity byId = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));

    return byId;
  }

  @Override
  public MembershipJpaEntity modifyMembership(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress,
      MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {

    MembershipJpaEntity entity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    entity.setName(membershipName.getName());
    entity.setAddress(membershipAddress.getAddressValue());
    entity.setEmail(membershipEmail.getEmailValue());
    entity.setCorp(membershipIsCorp.isCorpValue());
    entity.setValid(membershipIsValid.isValidValue());

    return membershipRepository.save(entity);
  }
}
