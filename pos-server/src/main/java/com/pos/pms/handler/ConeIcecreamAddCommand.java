package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.ConeIcecream;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class ConeIcecreamAddCommand implements Command {

  List<ConeIcecream> ConeIcecreamList;

  public ConeIcecreamAddCommand(List<ConeIcecream> list) {
    this.ConeIcecreamList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[콘아이스크림 등록]");

      ConeIcecream coneIcecream = new ConeIcecream();
      coneIcecream.setName(Prompt.inputString("이름? ", out, in));
      coneIcecream.setPrice(Prompt.inputInt("가격? ", out, in));
      coneIcecream.setSize(Prompt.inputString("사이즈? ", out, in));
      coneIcecream.setNo(Prompt.inputInt("품목번호? ", out, in));

      ConeIcecreamList.add(coneIcecream);

      out.println("콘아이스크림을 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
