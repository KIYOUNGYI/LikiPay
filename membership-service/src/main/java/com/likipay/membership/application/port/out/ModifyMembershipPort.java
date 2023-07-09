package com.likipay.membership.application.port.out;

import com.likipay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.likipay.membership.domain.Membership;
import java.lang.reflect.Member;

public interface ModifyMembershipPort {

  MembershipJpaEntity modifyMembership(
      Membership.MembershipId membershipId,
      Membership.MembershipName membershipName,
      Membership.MembershipEmail membershipEmail,
      Membership.MembershipAddress membershipAddress,
      Membership.MembershipIsValid membershipIsValid,
      Membership.MembershipIsCorp membershipIsCorp
  );
}
