package com.likipay.money.adapter.in.web;

import com.likipay.money.domain.MoneyChangingRequest;
import com.likipay.money.domain.MoneyChangingRequest.MoneyChangingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 여기서만 사용한다고 이 디렉토리에 만들었는데 뭐지???
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

  private String targetMembershipId;

  private int moneyChangeType;

  private int moneyChangeResultStatus;

  private int amount;




}


//enum MoneyChangeType {
//  INCREASING,
//  DECREASING
//}
//
//enum MoneyChangeResultStatus {
//
//  SUCCESS,
//  FAILED,
//  FAILED_NOT_ENOUGH_MONEY,//돈 부족
//  FAILED_NOT_EXIST_MEMBERSHIP,//멤버십 없음
//  FAILED_NOT_EXIST_CHANGING_REQUEST,//실패 = 머니 변액 요청 없음
//}