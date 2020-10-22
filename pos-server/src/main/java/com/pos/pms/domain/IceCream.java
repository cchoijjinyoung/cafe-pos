package com.pos.pms.domain;

//Task 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class IceCream {
  private String name;
  private String vessel;
  private String size;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getVessel() {
    return vessel;
  }
  public void setVessel(String vessel) {
    this.vessel = vessel;
  }
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }
}
