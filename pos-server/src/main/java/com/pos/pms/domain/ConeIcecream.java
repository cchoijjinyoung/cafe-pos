package com.pos.pms.domain;

//Task 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class ConeIcecream {
  private int no;
  private String name;
  private String size;
  private int price;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
}
}
