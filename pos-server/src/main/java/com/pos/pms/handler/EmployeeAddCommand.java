package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import com.pos.pms.domain.Employee;
import com.pos.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class EmployeeAddCommand implements Command {

  List<Employee> employeeList;

  public EmployeeAddCommand(List<Employee> list) {
    this.employeeList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[직원 등록]");

      Employee employee = new Employee();
      employee.setNo(Prompt.inputInt("사번? ", out, in));
      employee.setName(Prompt.inputString("성명? ", out, in));
      employee.setAge(Prompt.inputInt("나이? ", out, in));
      employee.setJopPosition(Prompt.inputString("직책? ", out, in));
      employee.setStartDate(new Date(System.currentTimeMillis()));
      employeeList.add(employee);

      out.println("직원을 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
