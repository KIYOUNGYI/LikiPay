package membership.application.service;

import com.likipay.common.UseCase;
import com.likipay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.likipay.membership.adapter.out.persistence.MembershipMapper;
import com.likipay.membership.application.port.in.FindMembershipCommand;
import com.likipay.membership.application.port.in.FindMembershipUseCase;
import com.likipay.membership.application.port.out.FindMembershipPort;
import com.likipay.membership.domain.Membership;
import com.likipay.membership.domain.Membership.MembershipId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

  private final FindMembershipPort findMembershipPort;

  @Override
  public Membership findMembership(FindMembershipCommand command) {

    MembershipJpaEntity entity = findMembershipPort.findMembership(new MembershipId(command.getMembershipId()));
    return MembershipMapper.mapToDomainEntity(entity);
  }
}
