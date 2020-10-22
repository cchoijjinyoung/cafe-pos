package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.HotCoffee;

public class HotCoffeeListCommand implements Command {

  List<HotCoffee> HotCoffeeList;

  public HotCoffeeListCommand(List<HotCoffee> list) {
    this.HotCoffeeList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[Hot커피 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<HotCoffee> iterator = HotCoffeeList.iterator();

    while (iterator.hasNext()) {
      HotCoffee hotCoffee = iterator.next();
      out.printf("%s, %d, %s, %d\n",
          hotCoffee.getName(),
          hotCoffee.getPrice(),
          hotCoffee.getSize());
          hotCoffee.getNo();

    }
  }

}
