//package com.likipay.banking.domain;
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.ToString;
//import lombok.Value;
//
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Getter
//@ToString
//public class RegisteredBankAccount {
//
//  private final Long firmBankingRequestId;
//
//  private final String fromBankName;
//  private final String fromBankAccountNumber;
//  private final String toBankName;
//  private final String toBankAccountNumber;
//  private final int moneyAmount;
//
//  private final int firmBankingStatus;// 0 : 요청 / 1: 완료 / 2 : 실패
//
//  public static FirmBankingRequest generateFirmBankingRequest(
//      FirmBankingRequest.FirmBankingRequestId firmBankingRequestId,
//      FirmBankingRequest.FromBankName fromBankName,
//      FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
//      FirmBankingRequest.ToBankName toBankName,
//      FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
//      FirmBankingRequest.MoneyAmount moneyAmount,
//      FirmBankingRequest.FirmBankingStatus firmBankingStatus
//  ) {
//
//    return new FirmBankingRequest(
//        firmBankingRequestId.firmBankingRequestId,
//        fromBankName.fromBankName,
//        fromBankAccountNumber.fromBankAccountNumber,
//        toBankName.toBankName,
//        toBankAccountNumber.toBankAccountNumber,
//        moneyAmount.moneyAmount,
//        firmBankingStatus.firmBankStatus
//    );
//  }
//
//
//  @Value
//  public static class FirmBankingRequestId {
//
//    public FirmBankingRequestId(Long value) {
//      this.firmBankingRequestId = value;
//    }
//
//    Long firmBankingRequestId;
//  }
//
//  @Value
//  public static class FromBankName {
//
//    public FromBankName(String value) {
//      this.fromBankName = value;
//
//    }
//
//    String fromBankName;
//  }
//
//  @Value
//  public static class FromBankAccountNumber {
//
//    public FromBankAccountNumber(String fromBankAccountNumber) {
//      this.fromBankAccountNumber = fromBankAccountNumber;
//    }
//
//    String fromBankAccountNumber;
//  }
//
//  @Value
//  public static class ToBankName {
//
//    public ToBankName(String toBankName) {
//      this.toBankName = toBankName;
//    }
//
//    String toBankName;
//  }
//
//  @Value
//  public static class ToBankAccountNumber {
//
//    public ToBankAccountNumber(String toBankAccountNumber) {
//      this.toBankAccountNumber = toBankAccountNumber;
//    }
//
//    String toBankAccountNumber;
//
//  }
//
//  @Value
//  public static class MoneyAmount {
//
//    public MoneyAmount(int value) {
//      this.moneyAmount = value;
//    }
//
//    int moneyAmount;
//  }
//
//  @Value
//  public static class FirmBankingStatus {
//
//    public FirmBankingStatus(int value) {
//      this.firmBankStatus = value;
//    }
//
//    int firmBankStatus;
//  }
//
//}
