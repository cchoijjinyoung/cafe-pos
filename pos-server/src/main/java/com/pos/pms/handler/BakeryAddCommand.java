package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.Bakery;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class BakeryAddCommand implements Command {

  List<Bakery> BakeryList;

  public BakeryAddCommand(List<Bakery> list) {
    this.BakeryList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[Bakery 등록]");

      Bakery bakery = new Bakery();
      bakery.setName(Prompt.inputString("이름? ", out, in));
      bakery.setPrice(Prompt.inputInt("가격? ", out, in));
      bakery.setType(Prompt.inputString("종류? ", out, in));
      bakery.setNo(Prompt.inputInt("품목번호? ", out, in));

      BakeryList.add(bakery);

      out.println("Bakery를 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
