package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.CupIcecream;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class CupIcecreamAddCommand implements Command {

  List<CupIcecream> CupIcecreamList;

  public CupIcecreamAddCommand(List<CupIcecream> list) {
    this.CupIcecreamList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[컵아이스크림 등록]");

      CupIcecream cupIcecream = new CupIcecream();
      cupIcecream.setName(Prompt.inputString("이름? ", out, in));
      cupIcecream.setPrice(Prompt.inputInt("가격? ", out, in));
      cupIcecream.setSize(Prompt.inputString("사이즈? ", out, in));
      cupIcecream.setNo(Prompt.inputInt("품목번호? ", out, in));

      CupIcecreamList.add(cupIcecream);

      out.println("컵아이스크림을 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
