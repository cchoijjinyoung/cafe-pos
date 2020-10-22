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

public class OrderCommand implements Command {
  List<Order> OrderList;
  List<HotCoffee> HotCoffeeList;
  List<ColdCoffee> ColdCoffeeList;
  List<Bakery> BakeryList;
  List<CupIcecream> cupIcecreamList;
  List<ConeIcecream> coneIcecreamList;



  public OrderCommand(List<Order> orderlist, List<HotCoffee> hotCoffeeList,
      List<ColdCoffee> coldCoffeeList, List<Bakery> bakeryList, List<CupIcecream> list, List<ConeIcecream> conList) {
    this.OrderList = orderlist;
    this.HotCoffeeList = hotCoffeeList;
    this.ColdCoffeeList = coldCoffeeList;
    this.BakeryList = bakeryList;
    this.cupIcecreamList = list;
    this.coneIcecreamList = conList;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    Order order = new Order();
    try {
      out.println("주문하시겠습니까?");
      int request = Prompt.inputInt("1)HotCoffee, 2)ColdCoffee, 3)bakery, 4)CupIcecream, 5)ConeIcecream", out, in);
      out.flush();
      int request2 = 0;
      switch (request) {
        case 1:
          for (int i = 0; i < HotCoffeeList.size(); i++) {
            String name = HotCoffeeList.get(i).getName();
            request2 = Prompt.inputInt(i+1 +")" + name,out, in);
          }
          break;
        case 2:
          ColdCoffeeList();
          break;
        case 3:
          BakeryList();
          break;
    }

      switch (request2) {
        case 1:
          order.setCount(Prompt.inputInt("갯수? ", out, in));
      }

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
