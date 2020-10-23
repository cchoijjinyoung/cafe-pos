package com.pos.pms.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.pos.pms.domain.StaffLogin;
import com.pos.util.Prompt;

public class LoginCommand {
  List<StaffLogin> staff = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  public LoginCommand() {
    staff.add(new StaffLogin("admin", "1234", "Kim"));
  }

  public void System() {
    int num = 0;
    while ((num = menu()) != 0) {
        switch (num) {
        case 1:
            StaffLogin();
            break;
        case 2:
            StaffJoin();
            break;
        case 3:
            //StaffList();
        }
    }
  }

  private void StaffJoin() {
      String Id = Prompt.inputString("ID : ");
      String Password = Prompt.inputString("Password : ");
      String Password2 = Prompt.inputString("Password Confirm : ");
      String Name = Prompt.inputString("Name : ");

      if(TestId(Id)) {
          System.out.println("중복된 ID입니다.");
      } else if(Password.equals(Password2)) {
          staff.add(new StaffLogin(Id, Password, Name));
          System.out.println("회원가입이 완료되었습니다.");
      } else {
          System.out.println("비밀번호를 다시 입력하시오.");
      }
  }

  private void StaffLogin() {
      while (true) {
          String Id = Prompt.inputString("ID : ");

          String Password = Prompt.inputString("Password : ");

          StaffLogin member = FindId(Id);

          //PosHandler pos = new PosHandler();


          if (member == null) {
              System.out.println("입력하신 아이디가 일치하지 않습니다.");
              System.out.println("다시 입력하시오.");
          } else if(member.getPassword().equals(Password)) {
              System.out.println("포스시스템에 접속하였습니다.");
              //pos.StudentSystem();
              break;
          } else {
              System.out.println("입력하신 패스워드가 일치하지 않습니다.");
              System.out.println("다시 입력하시오.");
          }
      }
  }

  public boolean TestId(String Id) {
      boolean check = true;
      StaffLogin member = FindId(Id);
      if (member == null)
          check = false;
      return check;

  }

  private StaffLogin FindId(String Id) {
      for(StaffLogin staffLogin : staff) {
          if(staffLogin.getId().equals(Id)) {
              return staffLogin;
          }
      }
      return null;
  }

  public int menu() {
      return Prompt.inputInt("[1]로그인 [2]회원가입 [0]종료");
  }


/*
  public void StaffList() {
      System.out.println("[관리자 목록]");

      Iterator<StaffLogin> ite = staff.iterator();

      while(ite.hasNext()) {
          System.out.println(ite.next() + " ");
      }
  }*/

}
