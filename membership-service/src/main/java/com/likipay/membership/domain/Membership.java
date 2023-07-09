package com.likipay.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Membership {

  @Getter
  private final String memberShipId;
  @Getter
  private final String name;
  @Getter
  private final String email;
  @Getter
  private final String address;

  @Getter
  private final boolean isValid;
  @Getter
  private final boolean isCorp;

  public static Membership generateMembership(
      MembershipId membershipId,
      MembershipName membershipName,
      MembershipEmail membershipEmail,
      MembershipAddress membershipAddress,
      MembershipIsValid membershipIsValid,
      MembershipIsCorp membershipIsCorp
  ) {

    return new Membership(
        membershipId.membershipId,
        membershipName.name,
        membershipEmail.emailValue,
        membershipAddress.addressValue,
        membershipIsValid.isValidValue,
        membershipIsCorp.isCorpValue
    );

  }


  // Membership 오염되면 안됨 (굳이 이렇게까지??)
  @Value
  public static class MembershipId {

    public MembershipId(String membershipId) {
      this.membershipId = membershipId;
    }

    String membershipId;
  }

  @Value
  public static class MembershipName {

    public MembershipName(String value) {
      this.name = value;
    }

    String name;
  }

  @Value
  public static class MembershipAddress {

    public MembershipAddress(String addressValue) {
      this.addressValue = addressValue;
    }

    String addressValue;
  }

  @Value
  public static class MembershipIsValid {

    public MembershipIsValid(boolean isValidValue) {
      this.isValidValue = isValidValue;
    }

    boolean isValidValue;
  }

  @Value
  public static class MembershipIsCorp {

    public MembershipIsCorp(boolean isValidValue) {
      this.isCorpValue = isValidValue;
    }

    boolean isCorpValue;
  }

  @Value
  public static class MembershipEmail {

    public MembershipEmail(String value) {
      this.emailValue = value;
    }

    String emailValue;
  }


}
