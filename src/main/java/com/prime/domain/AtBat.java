package com.prime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atbats")
public class AtBat {

  private int atBatId;
  private int gameId;
  private int inning;
  private int num;
  private int ball;
  private int strike;
  private int outs;
  private int batter;
  private int pitcher;
  private String stand;
  private String description;
  private String event;
  private Double hitX;
  private Double hitY;
  private String hitType;

  @Id
  @Column(name = "ab_id", nullable = false, unique = true)
  public int getAtBatId() {
    return atBatId;
  }

  public void setAtBatId(int atBatId) {
    this.atBatId = atBatId;
  }

  @Column(name = "game_id", nullable = false)
  public int getGameId() {
    return gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }

  @Column(name = "inning", nullable = false)
  public int getInning() {
    return inning;
  }

  public void setInning(int inning) {
    this.inning = inning;
  }

  @Column(name = "num", nullable = false)
  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Column(name = "ball", nullable = false)
  public int getBall() {
    return ball;
  }

  public void setBall(int ball) {
    this.ball = ball;
  }

  @Column(name = "strike", nullable = false)
  public int getStrike() {
    return strike;
  }

  public void setStrike(int strike) {
    this.strike = strike;
  }

  @Column(name = "outs", nullable = false)
  public int getOuts() {
    return outs;
  }

  public void setOuts(int outs) {
    this.outs = outs;
  }

  @Column(name = "batter", nullable = false)
  public int getBatter() {
    return batter;
  }

  public void setBatter(int batter) {
    this.batter = batter;
  }

  @Column(name = "pitcher", nullable = false)
  public int getPitcher() {
    return pitcher;
  }

  public void setPitcher(int pitcher) {
    this.pitcher = pitcher;
  }

  @Column(name = "stand", nullable = false)
  public String getStand() {
    return stand;
  }

  public void setStand(String stand) {
    this.stand = stand;
  }

  @Column(name = "des", nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "event", nullable = false)
  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  @Column(name = "hit_x", nullable = false)
  public Double getHitX() {
    return hitX;
  }

  public void setHitX(Double hitX) {
    this.hitX = hitX;
  }

  public Double getHitY() {
    return hitY;
  }

  @Column(name = "hit_y", nullable = false)
  public void setHitY(Double hitY) {
    this.hitY = hitY;
  }

  @Column(name = "hit_type", nullable = false)
  public String getHitType() {
    return hitType;
  }

  public void setHitType(String hitType) {
    this.hitType = hitType;
  }
}
