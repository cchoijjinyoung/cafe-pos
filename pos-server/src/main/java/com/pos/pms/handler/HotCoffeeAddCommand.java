package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.HotCoffee;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class HotCoffeeAddCommand implements Command {

  List<HotCoffee> HotCoffeeList;

  public HotCoffeeAddCommand(List<HotCoffee> list) {
    this.HotCoffeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[Hot커피 등록]");

      HotCoffee hotCoffee = new HotCoffee();
      hotCoffee.setName(Prompt.inputString("이름? ", out, in));
      hotCoffee.setPrice(Prompt.inputInt("가격? ", out, in));
      hotCoffee.setSize(Prompt.inputString("사이즈? ", out, in));
      hotCoffee.setNo(Prompt.inputInt("품목번호? ", out, in));

      HotCoffeeList.add(hotCoffee);

      out.println("HotCoffee를 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
