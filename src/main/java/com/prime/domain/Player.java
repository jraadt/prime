package com.prime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

  private int eliasId;
  private String firstName;
  private String lastName;
  private String lahmanId;
  private String throwsHand;
  private Integer height;

  @Id
  @Column(name = "eliasid", nullable = false, unique = true)
  public int getEliasId() {
    return eliasId;
  }

  public void setEliasId(int eliasId) {
    this.eliasId = eliasId;
  }

  @Column(name = "first", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name = "lahmanid")
  public String getLahmanId() {
    return lahmanId;
  }

  public void setLahmanId(String lahmanId) {
    this.lahmanId = lahmanId;
  }

  @Column(name = "throws")
  public String getThrowsHand() {
    return throwsHand;
  }

  public void setThrowsHand(String throwsHand) {
    this.throwsHand = throwsHand;
  }

  @Column(name = "height")
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }
}
