package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.ConeIcecream;

public class ConeIcecreamListCommand implements Command {

  List<ConeIcecream> ConeIcecreamList;

  public ConeIcecreamListCommand(List<ConeIcecream> list) {
    this.ConeIcecreamList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[콘아이스크림 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<ConeIcecream> iterator = ConeIcecreamList.iterator();

    while (iterator.hasNext()) {
      ConeIcecream coneIcecream = iterator.next();
      out.println("------------------------------------------------------------");
      out.printf(" %s | %d원 | %s | %d\n",
          coneIcecream.getName(),
          coneIcecream.getPrice(),
          coneIcecream.getSize(),
          coneIcecream.getNo());
      out.println("------------------------------------------------------------");

    }
  }

}
