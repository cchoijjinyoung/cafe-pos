package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.ColdCoffee;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class ColdCoffeeAddCommand implements Command {

  List<ColdCoffee> ColdCoffeeList;

  public ColdCoffeeAddCommand(List<ColdCoffee> list) {
    this.ColdCoffeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[Cold커피 등록]");

      ColdCoffee coldCoffee = new ColdCoffee();
      coldCoffee.setName(Prompt.inputString("이름? ", out, in));
      coldCoffee.setPrice(Prompt.inputInt("가격? ", out, in));
      coldCoffee.setSize(Prompt.inputString("사이즈? ", out, in));
      coldCoffee.setNo(Prompt.inputInt("품목번호? ", out, in));

      ColdCoffeeList.add(coldCoffee);

      out.println("ColdCoffee를 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
