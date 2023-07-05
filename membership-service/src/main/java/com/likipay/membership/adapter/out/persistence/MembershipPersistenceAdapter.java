package com.likipay.membership.adapter.out.persistence;

import com.likipay.membership.application.port.out.RegisterMembershipPort;
import com.likipay.membership.domain.Membership.MembershipAddress;
import com.likipay.membership.domain.Membership.MembershipEmail;
import com.likipay.membership.domain.Membership.MembershipIsCorp;
import com.likipay.membership.domain.Membership.MembershipIsValid;
import com.likipay.membership.domain.Membership.MembershipName;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

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
}
