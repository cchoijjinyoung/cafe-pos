package com.pos.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.pos.pms.domain.Employee;

public class EmployeeListCommand implements Command {

  List<Employee> employeeList;

  public EmployeeListCommand(List<Employee> list) {
    this.employeeList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[직원 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<Employee> iterator = employeeList.iterator();

    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      out.println("------------------------------------------------------------");
      out.printf(" %d | %s | %s | %s | %d\n",
          employee.getNo(),
          employee.getName(),
          employee.getAge(),
          employee.getJopPosition(),
          employee.getStartDate());
      out.println("------------------------------------------------------------");
    }
  }

  public Employee findByName(String name) {
    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.get(i);
      if (employee.getName().equals(name)) {
        return employee;
      }
    }
    return null;
  }


}
