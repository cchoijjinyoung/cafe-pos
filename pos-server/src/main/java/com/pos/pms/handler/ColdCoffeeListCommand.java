package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.ColdCoffee;

public class ColdCoffeeListCommand implements Command {

  List<ColdCoffee> ColdCoffeeList;

  public ColdCoffeeListCommand(List<ColdCoffee> list) {
    this.ColdCoffeeList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[Cold커피 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<ColdCoffee> iterator = ColdCoffeeList.iterator();

    while (iterator.hasNext()) {
      ColdCoffee coldCoffee = iterator.next();
      out.println("------------------------------------------------------------");
      out.printf(" %s | %d | %s | %d\n",
          coldCoffee.getName(),
          coldCoffee.getPrice(),
          coldCoffee.getSize(),
          coldCoffee.getNo());
      out.println("------------------------------------------------------------");

    }
  }

}
