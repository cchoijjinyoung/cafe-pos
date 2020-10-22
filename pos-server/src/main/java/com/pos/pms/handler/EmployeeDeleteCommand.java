package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.Employee;
import com.pos.util.Prompt;

public class EmployeeDeleteCommand implements Command {

  List<Employee> employeeList;

  public EmployeeDeleteCommand(List<Employee> list) {
    this.employeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[직원 삭제]");
      int no = Prompt.inputInt("사번? ", out, in);
      int index = indexOf(no);

      if (index == -1) {
        out.println("해당 사번의 직원이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("직원 삭제를 취소하였습니다.");
        return;
      }

      employeeList.remove(index);
      out.println("직원을 삭제하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.get(i);
      if (employee.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
