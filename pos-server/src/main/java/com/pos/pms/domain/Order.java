package com.pos.pms.domain;

public class Order {
  private String name;
  private int count;
  private int no;
  private int price;

  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
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
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }


}
