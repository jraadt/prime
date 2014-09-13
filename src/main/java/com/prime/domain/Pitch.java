package com.prime.domain;

import javax.persistence.*;

@Entity
@Table(name = "pitches")
public class Pitch {
  private int pitchId;
  private AtBat atBat;
  private String description;
  private String type;
  private int gamePitchId;
  private double x;
  private double y;
  private Double startSpeed;
  private Double endSpeed;
  private Double szTop;
  private Double szBottom;
  private Double pfxX;
  private Double pfxZ;
  private Double px;
  private Double pz;
  private Double x0;
  private Double y0;
  private Double z0;
  private Double vx0;
  private Double vy0;
  private Double vz0;
  private Double ax;
  private Double ay;
  private Double az;
  private Double breakY;
  private Double breakAngle;
  private Double breakLength;
  private String countBalls;
  private String countStrikes;
  private Integer onFirstBase;
  private Integer onSecondBase;
  private Integer onThirdBase;
  private String timeThrown;
  private String pitchType;
  private Double typeConfidence;
  private String monthThrown;

  @Id
  @Column(name = "pitch_id", nullable = false, unique = true)
  public int getPitchId() {
    return pitchId;
  }

  public void setPitchId(int pitchId) {
    this.pitchId = pitchId;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ab_id", nullable = false)
  public AtBat getAtBat() {
    return atBat;
  }

  public void setAtBat(AtBat atBat) {
    this.atBat = atBat;
  }

  @Column(name = "des", nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "type", nullable = false)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Column(name = "id", nullable = false)
  public int getGamePitchId() {
    return gamePitchId;
  }

  public void setGamePitchId(int gamePitchId) {
    this.gamePitchId = gamePitchId;
  }

  @Column(name = "x", nullable = false)
  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  @Column(name = "y", nullable = false)
  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Column(name = "start_speed")
  public Double getStartSpeed() {
    return startSpeed;
  }

  public void setStartSpeed(Double startSpeed) {
    this.startSpeed = startSpeed;
  }

  @Column(name = "end_speed")
  public Double getEndSpeed() {
    return endSpeed;
  }

  public void setEndSpeed(Double endSpeed) {
    this.endSpeed = endSpeed;
  }

  @Column(name = "sz_top")
  public Double getSzTop() {
    return szTop;
  }

  public void setSzTop(Double szTop) {
    this.szTop = szTop;
  }

  @Column(name = "sz_bot")
  public Double getSzBottom() {
    return szBottom;
  }

  public void setSzBottom(Double szBottom) {
    this.szBottom = szBottom;
  }

  @Column(name = "pfx_x")
  public Double getPfxX() {
    return pfxX;
  }

  public void setPfxX(Double pfxX) {
    this.pfxX = pfxX;
  }

  @Column(name = "pfx_z")
  public Double getPfxZ() {
    return pfxZ;
  }

  public void setPfxZ(Double pfxZ) {
    this.pfxZ = pfxZ;
  }

  @Column(name = "px")
  public Double getPx() {
    return px;
  }

  public void setPx(Double px) {
    this.px = px;
  }

  @Column(name = "pz")
  public Double getPz() {
    return pz;
  }

  public void setPz(Double pz) {
    this.pz = pz;
  }

  @Column(name = "x0")
  public Double getX0() {
    return x0;
  }

  public void setX0(Double x0) {
    this.x0 = x0;
  }

  @Column(name = "y0")
  public Double getY0() {
    return y0;
  }

  public void setY0(Double y0) {
    this.y0 = y0;
  }

  @Column(name = "z0")
  public Double getZ0() {
    return z0;
  }

  public void setZ0(Double z0) {
    this.z0 = z0;
  }

  @Column(name = "vx0")
  public Double getVx0() {
    return vx0;
  }

  public void setVx0(Double vx0) {
    this.vx0 = vx0;
  }

  @Column(name = "vy0")
  public Double getVy0() {
    return vy0;
  }

  public void setVy0(Double vy0) {
    this.vy0 = vy0;
  }

  @Column(name = "vz0")
  public Double getVz0() {
    return vz0;
  }

  public void setVz0(Double vz0) {
    this.vz0 = vz0;
  }

  @Column(name = "ax")
  public Double getAx() {
    return ax;
  }

  public void setAx(Double ax) {
    this.ax = ax;
  }

  @Column(name = "ay")
  public Double getAy() {
    return ay;
  }

  public void setAy(Double ay) {
    this.ay = ay;
  }

  @Column(name = "az")
  public Double getAz() {
    return az;
  }

  public void setAz(Double az) {
    this.az = az;
  }

  @Column(name = "break_y")
  public Double getBreakY() {
    return breakY;
  }

  public void setBreakY(Double breakY) {
    this.breakY = breakY;
  }

  @Column(name = "break_angle")
  public Double getBreakAngle() {
    return breakAngle;
  }

  public void setBreakAngle(Double breakAngle) {
    this.breakAngle = breakAngle;
  }

  @Column(name = "break_length")
  public Double getBreakLength() {
    return breakLength;
  }

  public void setBreakLength(Double breakLength) {
    this.breakLength = breakLength;
  }

  @Column(name = "ball")
  public String getCountBalls() {
    return countBalls;
  }

  public void setCountBalls(String countBalls) {
    this.countBalls = countBalls;
  }

  @Column(name = "strike")
  public String getCountStrikes() {
    return countStrikes;
  }

  public void setCountStrikes(String countStrikes) {
    this.countStrikes = countStrikes;
  }

  @Column(name = "on_1b")
  public Integer getOnFirstBase() {
    return onFirstBase;
  }

  public void setOnFirstBase(Integer onFirstBase) {
    this.onFirstBase = onFirstBase;
  }

  @Column(name = "on_2b")
  public Integer getOnSecondBase() {
    return onSecondBase;
  }

  public void setOnSecondBase(Integer onSecondBase) {
    this.onSecondBase = onSecondBase;
  }

  @Column(name = "on_3b")
  public Integer getOnThirdBase() {
    return onThirdBase;
  }

  public void setOnThirdBase(Integer onThirdBase) {
    this.onThirdBase = onThirdBase;
  }

  @Column(name = "sv_id")
  public String getTimeThrown() {
    return timeThrown;
  }

  public void setTimeThrown(String timeThrown) {
    this.timeThrown = timeThrown;
  }

  @Column(name = "pitch_type")
  public String getPitchType() {
    return pitchType;
  }

  public void setPitchType(String pitchType) {
    this.pitchType = pitchType;
  }

  @Column(name = "type_confidence")
  public Double getTypeConfidence() {
    return typeConfidence;
  }

  public void setTypeConfidence(Double typeConfidence) {
    this.typeConfidence = typeConfidence;
  }

  @Column(name = "month")
  public String getMonthThrown() {
    return monthThrown;
  }

  public void setMonthThrown(String monthThrown) {
    this.monthThrown = monthThrown;
  }
}
