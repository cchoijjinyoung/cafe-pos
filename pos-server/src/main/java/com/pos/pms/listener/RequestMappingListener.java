package com.pos.pms.listener;

import java.util.List;
import java.util.Map;
import com.pos.context.ApplicationContextListener;
import com.pos.pms.domain.Bakery;
import com.pos.pms.domain.ColdCoffee;
import com.pos.pms.domain.ConeIcecream;
import com.pos.pms.domain.CupIcecream;
import com.pos.pms.domain.Employee;
import com.pos.pms.domain.HotCoffee;
import com.pos.pms.domain.Order;
import com.pos.pms.handler.BakeryAddCommand;
import com.pos.pms.handler.BakeryDeleteCommand;
import com.pos.pms.handler.BakeryListCommand;
import com.pos.pms.handler.ColdCoffeeAddCommand;
import com.pos.pms.handler.ColdCoffeeDeleteCommand;
import com.pos.pms.handler.ColdCoffeeListCommand;
import com.pos.pms.handler.ConeIcecreamAddCommand;
import com.pos.pms.handler.ConeIcecreamDeleteCommand;
import com.pos.pms.handler.ConeIcecreamListCommand;
import com.pos.pms.handler.CupIcecreamAddCommand;
import com.pos.pms.handler.CupIcecreamDeleteCommand;
import com.pos.pms.handler.CupIcecreamListCommand;
import com.pos.pms.handler.EmployeeAddCommand;
import com.pos.pms.handler.EmployeeDeleteCommand;
import com.pos.pms.handler.EmployeeListCommand;
import com.pos.pms.handler.HotCoffeeAddCommand;
import com.pos.pms.handler.HotCoffeeDeleteCommand;
import com.pos.pms.handler.HotCoffeeListCommand;
import com.pos.pms.handler.OrderCommand;

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
    List<Order> orderList = (List<Order>) context.get("orderList");


    context.put("/order", new OrderCommand(orderList));

    EmployeeListCommand employeeListCommand = new EmployeeListCommand(employeeList);
    context.put("/employee/add", new EmployeeAddCommand(employeeList));
    context.put("/employee/list", employeeListCommand);
    context.put("/employee/delete", new EmployeeDeleteCommand(employeeList));

    context.put("/bakery/list", new BakeryListCommand(bakeryList));
    context.put("/bakery/add", new BakeryAddCommand(bakeryList));
    context.put("/bakery/delete", new BakeryDeleteCommand(bakeryList));

    context.put("/coldCoffee/add", new ColdCoffeeAddCommand(coldCoffeeList));
    context.put("/coldCoffee/list", new ColdCoffeeListCommand(coldCoffeeList));
    context.put("/coldCoffee/delete", new ColdCoffeeDeleteCommand(coldCoffeeList));

    context.put("/hotCoffee/add", new HotCoffeeAddCommand(hotCoffeeList));
    context.put("/hotCoffee/list", new HotCoffeeListCommand(hotCoffeeList));
    context.put("/hotCoffee/delete", new HotCoffeeDeleteCommand(hotCoffeeList));

    context.put("/coneIcecream/add", new ConeIcecreamAddCommand(coneIcecreamList));
    context.put("/coneIcecream/list", new ConeIcecreamListCommand(coneIcecreamList));
    context.put("/coneIcecream/delete", new ConeIcecreamDeleteCommand(coneIcecreamList));

    context.put("/cupIcecream/add", new CupIcecreamAddCommand(cupIcecreamList));
    context.put("/cupIcecream/list", new CupIcecreamListCommand(cupIcecreamList));
    context.put("/cupIcecream/delete", new CupIcecreamDeleteCommand(cupIcecreamList));
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
