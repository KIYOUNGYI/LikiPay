package membership.application.port.in;

import com.likipay.membership.domain.Membership;

//@UseCase
public interface RegisterMembershipUseCase {

  Membership registerMembership(RegisterMemberShipCommand command);
}
