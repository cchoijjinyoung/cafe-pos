package com.pos.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.pos.context.ApplicationContextListener;
import com.pos.pms.domain.Bakery;
import com.pos.pms.domain.ColdCoffee;
import com.pos.pms.domain.ConeIcecream;
import com.pos.pms.domain.CupIcecream;
import com.pos.pms.domain.Employee;
import com.pos.pms.domain.HotCoffee;


// 게시물, 회원, 프로젝트, 작업 데이터를 파일에서 로딩하고 파일로 저장하는 일을 한다.
public class DataHandlerListener implements ApplicationContextListener {

  List<HotCoffee> hotCoffeeList = new ArrayList<>();
  File hotCoffeeFile = new File("./hotCoffee.json"); // 게시글을 저장할 파일 정보

  List<ColdCoffee> coldCoffeeList = new LinkedList<>();
  File coldCoffeeFile = new File("./coldCoffee.json"); // 회원을 저장할 파일 정보

  List<Bakery> bakeryList = new LinkedList<>();
  File bakeryFile = new File("./bakery.json"); // 프로젝트를 저장할 파일 정보

  List<Employee> employeeList = new ArrayList<>();
  File employeeFile = new File("./employee.json"); // 작업을 저장할 파일 정보

  List<ConeIcecream> coneIcecreamList = new LinkedList<>();
  File coneIcecreamFile = new File("./coneIcecreamList.json"); // 프로젝트를 저장할 파일 정보

  List<CupIcecream> cupIcecreamList = new ArrayList<>();
  File cupIcecreamFile = new File("./cupIcecreamList.json"); // 작업을 저장할 파일 정보

  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 애플리케이션의 서비스가 시작되면 먼저 파일에서 데이터를 로딩한다.
    // 파일에서 데이터 로딩
    loadData(hotCoffeeList, hotCoffeeFile, HotCoffee[].class);
    loadData(coldCoffeeList, coldCoffeeFile, ColdCoffee[].class);
    loadData(bakeryList, bakeryFile, Bakery[].class);
    loadData(employeeList, employeeFile, Employee[].class);
    loadData(coneIcecreamList, coneIcecreamFile, ConeIcecream[].class);
    loadData(cupIcecreamList, cupIcecreamFile, CupIcecream[].class);

    // 옵저버가 파일에서 데이터(게시글,회원,프로젝트,작업)를 읽어
    // List 컬렉션에 저장한 다음,
    // 발행자(App 객체)가 사용할 수 있도록 맵 객체에 담아서 공유한다.
    context.put("hotCoffeeList", hotCoffeeList);
    context.put("coldCoffeeList", coldCoffeeList);
    context.put("bakeryList", bakeryList);
    context.put("employeeList", employeeList);
    context.put("coneIcecreamList", coneIcecreamList);
    context.put("cupIcecreamList", cupIcecreamList);
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    // 애플리케이션 서비스가 종료되면 컬렉션에 보관된 객체를 파일에 저장한다.
    // 데이터를 파일에 저장
    saveData(hotCoffeeList, hotCoffeeFile);
    saveData(coldCoffeeList, coldCoffeeFile);
    saveData(bakeryList, bakeryFile);
    saveData(employeeList, employeeFile);
    saveData(coneIcecreamList, coneIcecreamFile);
    saveData(cupIcecreamList, cupIcecreamFile);
  }

  private <T> void loadData(
      Collection<T> list, // 객체를 담을 컬렉션
      File file, // JSON 문자열이 저장된 파일
      Class<T[]> clazz // JSON 문자열을 어떤 타입의 배열로 만들 것인지 알려주는 클래스 정보
      ) {
    BufferedReader in = null;

    try {
      in = new BufferedReader(new FileReader(file));
      list.addAll(Arrays.asList(new Gson().fromJson(in, clazz)));
      System.out.printf("'%s' 파일에서 총 %d 개의 객체를 로딩했습니다.\n",
          file.getName(), list.size());

    } catch (Exception e) {
      System.out.printf("'%s' 파일 읽기 중 오류 발생! - %s\n",
          file.getName(), e.getMessage());

    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private void saveData(Collection<?> list, File file) {
    BufferedWriter out = null;

    try {
      out = new BufferedWriter(new FileWriter(file));

      Gson gson = new Gson();
      String jsonStr = gson.toJson(list);
      out.write(jsonStr);

      out.flush();

      System.out.printf("총 %d 개의 객체를 '%s' 파일에 저장했습니다.\n",
          list.size(), file.getName());

    } catch (IOException e) {
      System.out.printf("객체를 '%s' 파일에  쓰는 중 오류 발생! - %s\n",
          file.getName(), e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }
}
