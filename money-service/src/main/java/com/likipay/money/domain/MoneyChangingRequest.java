package com.likipay.money.domain;

import java.util.Date;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MoneyChangingRequest {

  @Getter
  private final String moneyChangingRequestId;

  // 어떤 고객의 증액/감액 요청을 요청했는지의 멤버 정보
  @Getter
  private final String targetMembershipId;

  // 그 요청이 증액 요청인지 / 감액 요청인지
  @Getter
  private final ChangingType changingType;//enum 0 : 증액, 1 : 감액

  enum ChangingType {
    INCREASING,//증액
    DECREASING//감액

  }

  //증액 또는 감액 요청의 금액
  @Getter
  private final int changingMoneyAmount;

  // 머니 변액 요청에 대한 상태
  @Getter
  private final ChangingMoneyStatus changingMoneyStatus;//enum

  enum ChangingMoneyStatus {

    REQUESTED,//요청됨
    SUCCEEDED,//성공
    FAILED,//실패
    CANCELLED//취소됨

  }

  @Getter
  private final String uuid;

  @Getter
  private final Date createdAt;


  public static MoneyChangingRequest generateMoneyChangingRequest(
      MoneyChangingRequestId moneyChangingRequestId,
      TargetMembershipId targetMembershipId,
      MoneyChangingType moneyChangingType,
      ChangingMoneyAmount changingMoneyAmount,
      MoneyChangingStatus moneyChangingStatus,
      Uuid uuid
  ) {


    return new MoneyChangingRequest(

        moneyChangingRequestId.getMoneyChangingRequestId(),
        targetMembershipId.getTargetMembershipId(),
        moneyChangingType.getChangingType(),
        Integer.parseInt(String.valueOf(changingMoneyAmount.getChangingMoneyAmount())),
        moneyChangingStatus.getChangingMoneyStatus(),
        uuid.getUuid(),
        new Date()
    );
  }



  @Value
  public static class MoneyChangingRequestId {

    public MoneyChangingRequestId(String value) {
      this.moneyChangingRequestId = value;
    }

    String moneyChangingRequestId;
  }

  @Value
  public static class TargetMembershipId {

    public TargetMembershipId(String value) {
      this.targetMembershipId = value;
    }

    String targetMembershipId;
  }

  @Value
  public static class MoneyChangingType {

    public MoneyChangingType(ChangingType value) {
      this.changingType = value;
    }

    ChangingType changingType;

  }

  @Value
  public static class MoneyChangingStatus {

    public MoneyChangingStatus(ChangingMoneyStatus value) {
      this.changingMoneyStatus = value;
    }

    ChangingMoneyStatus changingMoneyStatus;
  }

  @Value
  public static class Uuid {

    public Uuid(UUID value) {
      this.uuid = value.toString();
    }

    String uuid;
  }


  @Value
  public static class ChangingMoneyAmount {

    public ChangingMoneyAmount(int value) {
      this.changingMoneyAmount = value;
    }

    int changingMoneyAmount;
  }


}
