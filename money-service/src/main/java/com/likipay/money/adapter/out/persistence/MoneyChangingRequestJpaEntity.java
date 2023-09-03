package com.likipay.money.adapter.out.persistence;

import com.likipay.money.domain.MoneyChangingRequest.Uuid;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {

  @Id
  @GeneratedValue
  private Long moneyChangingRequestId;

  private String targetMembershipId;

  private int moneyChangingType;

  private int moneyAmount;

  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp timestamp;

  private int changingMoneyStatus;// 0: 요청, 1 : 성공, 2: 실패

  private UUID uuid;

  public MoneyChangingRequestJpaEntity(String targetMembershipId, int moneyChangingType, int moneyAmount, Timestamp timestamp, int changingMoneyStatus, UUID uuid) {
    this.targetMembershipId = targetMembershipId;
    this.moneyChangingType = moneyChangingType;
    this.moneyAmount = moneyAmount;
    this.timestamp = timestamp;
    this.changingMoneyStatus = changingMoneyStatus;
    this.uuid = uuid;
  }
}
