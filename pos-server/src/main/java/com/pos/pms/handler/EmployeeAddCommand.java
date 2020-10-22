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
      out.println("[게시물 등록]");

      Employee employee = new Employee();
      employee.setTitle(Prompt.inputString("제목? ", out, in));
      employee.setNo(Prompt.inputInt("번호? ", out, in));
      employee.setContent(Prompt.inputString("내용? ", out, in));
      employee.setWriter(Prompt.inputString("작성자? ", out, in));
      employee.setRegisteredDate(new Date(System.currentTimeMillis()));
      employee.setViewCount(0);

      employeeList.add(board);

      out.println("게시글을 등록하였습니다.");

    } catch(Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
