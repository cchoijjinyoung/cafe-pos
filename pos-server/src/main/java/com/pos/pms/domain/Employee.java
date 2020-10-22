package com.pos.pms.domain;

import java.sql.Date;

//Task 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class Employee {
  private String name;
  private int age;
  private String jopPosition;
  private Date startDate;
  private Date deadline;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getJopPosition() {
    return jopPosition;
  }
  public void setJopPosition(String jopPosition) {
    this.jopPosition = jopPosition;
  }
  public Date getDeadline() {
    return deadline;
  }
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
}
