package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.Bakery;
import com.pos.pms.domain.ColdCoffee;
import com.pos.pms.domain.HotCoffee;
import com.pos.pms.domain.Order;
import com.pos.util.Prompt;

public class OrderCommand implements Command {
  List<Order> OrderList;
  List<HotCoffee> HotCoffeeList;
  List<ColdCoffee> ColdCoffeeList;
  List<Bakery> BakeryList;



  public OrderCommand(List<Order> list) {
    this.OrderList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("주문하시겠습니까?");



      int num = 0;
      Order order = new Order();
      order.setName(Prompt.inputString(
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
    }
      order.setCount(Prompt.inputInt("갯수? ", out, in));
    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  public void HotCoffeeList() {
    Iterator<HotCoffee> iterator = HotCoffeeList.iterator();
    while (iterator.hasNext()) {
      HotCoffee hotCoffee = iterator.next();
      System.out.printf("%s", hotCoffee.getName());
    }
  }

    public void ColdCoffeeList() {
      Iterator<ColdCoffee> iterator = ColdCoffeeList.iterator();
      while (iterator.hasNext()) {
        ColdCoffee coldCoffee = iterator.next();
        System.out.printf("%s", coldCoffee.getName());
      }
    }


  public void BakeryList() {
    Iterator<Bakery> iterator = BakeryList.iterator();
    while (iterator.hasNext()) {
      Bakery bakery = iterator.next();
      System.out.printf("%s", bakery.getName());
    }

  }


}
