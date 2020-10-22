package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.pos.pms.domain.Employee;
import com.pos.util.Prompt;

public class EmployeeUpdateCommand implements Command {

  List<Employee> employeeList;

  public EmployeeUpdateCommand(List<Employee> list) {
    this.employeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[직원 수정]");
      int no = Prompt.inputInt("사번? ", out, in);
      Employee employee = findByNo(no);

      if (employee == null) {
        out.println("해당 사번의 직원이 없습니다.");
        return;
      }

      String name = Prompt.inputString(
          String.format("성명(%s)? ", employee.getName()), out, in);
      int age = Prompt.inputInt(
          String.format("나이(%s)? ", employee.getAge()), out, in);
      String jopPosition = Prompt.inputString(
          String.format("직책(%s)? ", employee.getJopPosition()), out, in);

      String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("직원 변경을 취소하였습니다.");
        return;
      }

      employee.setName(name);
      employee.setAge(age);
      employee.setJopPosition(jopPosition);
      out.println("직원을 변경하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private Employee findByNo(int no) {
    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.get(i);
      if (employee.getNo() == no) {
        return employee;
      }
    }
    return null;
  }
}
