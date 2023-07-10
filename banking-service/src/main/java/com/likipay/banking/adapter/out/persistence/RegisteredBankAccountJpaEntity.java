package com.likipay.banking.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

  @Id
  @GeneratedValue
  private Long registeredBankAccountId;

  private String membershipId;

  private String bankName;

  private String bankAccountNumber;

  private boolean linkedStatusIsValid;


  public RegisteredBankAccountJpaEntity(String membershipId, String bankName,
      String bankAccountNumber, boolean linkedStatusIsValid) {
    this.membershipId = membershipId;
    this.bankName = bankName;
    this.bankAccountNumber = bankAccountNumber;
    this.linkedStatusIsValid = linkedStatusIsValid;
  }
}
