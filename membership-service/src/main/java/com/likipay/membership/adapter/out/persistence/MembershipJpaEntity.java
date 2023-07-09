package com.likipay.membership.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipJpaEntity {

  @Id
  @GeneratedValue
  private Long membershipId;

  private String name;

  private String address;

  private String email;

  private boolean isValid;

  private boolean isCorp;

  public MembershipJpaEntity(String name, String email, String address, boolean isValid, boolean isCorp) {
    this.name = name;

    this.email = email;
    this.address = address;
    this.isValid = isValid;
    this.isCorp = isCorp;
  }
}
