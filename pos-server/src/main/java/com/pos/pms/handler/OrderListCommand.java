package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.Order;

public class OrderListCommand implements Command {
  List<Order> OrderList;

  public OrderListCommand(List<Order> list) {
    this.OrderList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[주문 목록]");

    Iterator<Order> iterator = OrderList.iterator();

    while (iterator.hasNext()) {
      Order order  = iterator.next();
      int sum = (order.getPrice()*order.getNo());
      out.println("------------------------------------------------------------");
      out.printf(" %s | %d원 | %d | %d\n",
          order.getName(),
          order.getPrice(),
          order.getNo());
      out.println(sum);
      out.println("------------------------------------------------------------");

    }
  }

}
