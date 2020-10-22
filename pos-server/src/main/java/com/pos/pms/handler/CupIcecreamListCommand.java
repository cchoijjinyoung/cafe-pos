package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.CupIcecream;

public class CupIcecreamListCommand implements Command {

  List<CupIcecream> CupIcecreamList;

  public CupIcecreamListCommand(List<CupIcecream> list) {
    this.CupIcecreamList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[컵아이스크림 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<CupIcecream> iterator = CupIcecreamList.iterator();

    while (iterator.hasNext()) {
      CupIcecream cupIcecream = iterator.next();
      out.printf("%s, %d, %s, %d\n",
          cupIcecream.getName(),
          cupIcecream.getPrice(),
          cupIcecream.getSize());
          cupIcecream.getNo();

    }
  }

}
