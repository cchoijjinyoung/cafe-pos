package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.Bakery;

public class BakeryListCommand implements Command {

  List<Bakery> BakeryList;

  public BakeryListCommand(List<Bakery> list) {
    this.BakeryList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[Bakery 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<Bakery> iterator = BakeryList.iterator();

    while (iterator.hasNext()) {
      Bakery bakery = iterator.next();
      out.println("------------------------------------------------------------");
      out.printf(" %s | %d | %s | %d \n",
          bakery.getName(),
          bakery.getPrice(),
          bakery.getType(),
          bakery.getNo());
      out.println("------------------------------------------------------------");

    }
  }

}
