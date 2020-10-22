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

    //while (iter);
  }

}
