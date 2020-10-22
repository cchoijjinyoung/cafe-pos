package com.pos.pms.listener;

import java.util.List;
import java.util.Map;
import com.eomcs.pms.handler.CalculatorCommand;
import com.eomcs.pms.handler.HelloCommand;
import com.eomcs.pms.handler.MemberAddCommand;
import com.eomcs.pms.handler.MemberDeleteCommand;
import com.eomcs.pms.handler.MemberListCommand;
import com.eomcs.pms.handler.MemberUpdateCommand;
import com.eomcs.pms.handler.ProjectAddCommand;
import com.eomcs.pms.handler.ProjectDeleteCommand;
import com.eomcs.pms.handler.ProjectListCommand;
import com.eomcs.pms.handler.ProjectUpdateCommand;
import com.eomcs.pms.handler.TaskAddCommand;
import com.eomcs.pms.handler.TaskDeleteCommand;
import com.eomcs.pms.handler.TaskListCommand;
import com.eomcs.pms.handler.TaskUpdateCommand;
import com.pos.context.ApplicationContextListener;
import com.pos.pms.domain.Bakery;
import com.pos.pms.domain.ColdCoffee;
import com.pos.pms.domain.ConeIcecream;
import com.pos.pms.domain.CupIcecream;
import com.pos.pms.domain.Employee;
import com.pos.pms.domain.HotCoffee;
import com.pos.pms.handler.EmployeeAddCommand;
import com.pos.pms.handler.EmployeeDeleteCommand;
import com.pos.pms.handler.EmployeeListCommand;
import com.pos.pms.handler.EmployeeUpdateCommand;

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.
    List<Bakery> bakeryList = (List<Bakery>) context.get("bakeryList");
    List<ColdCoffee> coldCoffeeList = (List<ColdCoffee>) context.get("coldCoffeeList");
    List<HotCoffee> hotCoffeeList = (List<HotCoffee>) context.get("hotCoffeeList");
    List<ConeIcecream> coneIcecreamList = (List<ConeIcecream>) context.get("coneIcecreamList");
    List<CupIcecream> cupIcecreamList = (List<CupIcecream>) context.get("cupIcecreamList");
    List<Employee> employeeList = (List<Employee>) context.get("employeeList");

    EmployeeListCommand employeeListCommand = new EmployeeListCommand(employeeList);
    context.put("/employee/add", new EmployeeAddCommand(employeeList));
    context.put("/employee/list", employeeListCommand);
    context.put("/employee/update", new EmployeeUpdateCommand(employeeList));
    context.put("/employee/delete", new EmployeeDeleteCommand(employeeList));

    context.put("/member/list", new MemberListCommand(memberList));
    context.put("/member/add", new MemberAddCommand(memberList));
    context.put("/member/update", new MemberUpdateCommand(memberList));
    context.put("/member/delete", new MemberDeleteCommand(memberList));

    context.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
    context.put("/project/list", new ProjectListCommand(projectList));
    context.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
    context.put("/project/delete", new ProjectDeleteCommand(projectList));

    context.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
    context.put("/task/list", new TaskListCommand(taskList));
    context.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
    context.put("/task/delete", new TaskDeleteCommand(taskList));

    context.put("/hello", new HelloCommand());

    context.put("/calc", new CalculatorCommand());
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
