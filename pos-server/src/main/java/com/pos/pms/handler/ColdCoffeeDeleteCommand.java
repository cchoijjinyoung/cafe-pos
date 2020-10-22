package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.ColdCoffee;
import com.pos.util.Prompt;

public class ColdCoffeeDeleteCommand implements Command {

  List<ColdCoffee> ColdCoffeeList;

  public ColdCoffeeDeleteCommand(List<ColdCoffee> list) {
    this.ColdCoffeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[Cold커피 삭제]");
      int no = Prompt.inputInt("품목번호? ", out, in);
      int index = indexOf(no);

      if (index == -1) {
        out.println("해당 번호의 품목이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("해당 품목 삭제를 취소하였습니다.");
        return;
      }

      ColdCoffeeList.remove(index);
      out.println("해당 품목을 삭제하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < ColdCoffeeList.size(); i++) {
      ColdCoffee coldCoffee = ColdCoffeeList.get(i);
      if (coldCoffee.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
