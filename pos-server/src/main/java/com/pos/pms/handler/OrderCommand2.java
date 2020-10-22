package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.Bakery;
import com.pos.pms.domain.ColdCoffee;
import com.pos.pms.domain.ConeIcecream;
import com.pos.pms.domain.CupIcecream;
import com.pos.pms.domain.HotCoffee;
import com.pos.pms.domain.Order;
import com.pos.util.Prompt;

public class OrderCommand2 implements Command {
  List<Order> OrderList;
  List<HotCoffee> HotCoffeeList;
  List<ColdCoffee> ColdCoffeeList;
  List<Bakery> BakeryList;
  List<ConeIcecream> ConeIcecreamList;
  List<CupIcecream> CupIcecreamList;



  public OrderCommand2(List<Order> list) {
    this.OrderList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("주문하시겠습니까?");



      int num = 0;
      Order order = new Order();
      order.setNo(Prompt.inputInt(
          "1)HotCoffee, 2)ColdCoffee, 3)bakery, 4)CupIcecream, 5)ConeIcecream",
          out, in));
      switch (num) {
        case 1:
          HotCoffeeList();
          break;
        case 2:
          ColdCoffeeList();
          break;
        case 3:
          BakeryList();
          break;
        case 4:
          CupIcecreamList();
          break;
        case 5:
          ConeIcecreamList();
    }
      order.setName(Prompt.inputString("품목? ", out, in));
      order.setCount(Prompt.inputInt("갯수? ", out, in));
      
      out.println("결제 도와드리겠습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  public void HotCoffeeList() {
    Iterator<HotCoffee> iterator = HotCoffeeList.iterator();
    while (iterator.hasNext()) {
      HotCoffee hotCoffee = iterator.next();
      System.out.printf("%s(%d)", hotCoffee.getName(), hotCoffee.getPrice());
    }
  }

    public void ColdCoffeeList() {
      Iterator<ColdCoffee> iterator = ColdCoffeeList.iterator();
      while (iterator.hasNext()) {
        ColdCoffee coldCoffee = iterator.next();
        System.out.printf("%s(%d)", coldCoffee.getName(), coldCoffee.getPrice());
      }
    }


  public void BakeryList() {
    Iterator<Bakery> iterator = BakeryList.iterator();
    while (iterator.hasNext()) {
      Bakery bakery = iterator.next();
      System.out.printf("%s(%d)", bakery.getName(), bakery.getPrice());
    }

  }

  public void ConeIcecreamList() {
    Iterator<ConeIcecream> iterator = ConeIcecreamList.iterator();
    while (iterator.hasNext()) {
      ConeIcecream coneIcecream= iterator.next();
      System.out.printf("%s(%d)", coneIcecream.getName(), coneIcecream.getPrice());
    }

  }

  public void CupIcecreamList() {
    Iterator<CupIcecream> iterator = CupIcecreamList.iterator();
    while (iterator.hasNext()) {
      CupIcecream cupIcecream= iterator.next();
      System.out.printf("%s(%d)", cupIcecream.getName(), cupIcecream.getPrice());
    }

  }


}
