package membership.application.port.out;

import com.likipay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.likipay.membership.domain.Membership;

public interface FindMembershipPort {

  MembershipJpaEntity findMembership(Membership.MembershipId membershipId);
}
