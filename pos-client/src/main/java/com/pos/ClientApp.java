package com.pos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//
// stateful 통신
// => 서버와 연결하여 간단한 메시지 주고 받기
// => 사용자가 입력한 명령을 서버에 전송하기
// => 사용자가 Quit 명령을 입력할 때까지 반복
// => 서버에서 응답의 끝을 알리는 빈 줄을 보낼때까지 클라이언트는 계속 읽는다.
// => 애플리케이션 아규먼트를 이용하여 서버의 주소와 포트번호를 입력받는다.
//

public class ClientApp {

  static String host;
  static int port;

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("프로그램 사용법 : ");
      System.out.println("  java -cp ... ClientApp 서버주소 포트번호");
      System.exit(0);
    }


    host = args[0];
    port = Integer.parseInt(args[1]);

    while (true) {
      String input = Prompt.inputString("명령> ");
      if (input.equalsIgnoreCase("quit")) {
        break;
      }

      request(input);

      if (input.equalsIgnoreCase("stop"))
        break;
    }
    System.out.println("안녕!");



      // 서버주소 : localhost
      // 서버포트 : 8888

      // 서버와 연결된 소켓을 생성한다.
      // 소켓을 통해 문자열을 입출력할 수 있도록 스트림 객체를 준비한다.
      // 먼저 서버에 간단한 인사말을 보낸다.
      // 서버가 응답한 메시지를 출력한다.

      // 클라이언트가 서버에 stop 명령을 보내면 다음 변수를 true로 변경한다.


    }



  private static void request(String message) {
    boolean stop = false;


    try (Socket socket = new Socket(host , port);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      out.println(message);
      out.flush();

      receiveResponse(out, in);

      if (message.equalsIgnoreCase("stop")) {
        stop = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (stop) {
      // 서버를 멈추기 위해 그냥 접속했다가 끊는다.
      try (Socket socket = new Socket(host, port)) {
        // 아무것도 안한다.
        // 서버가 stop 할 기회를 주기 위함이다.
      } catch (Exception e) {
        // 아무것도 안한다.
      }
    }

  }

  private static void receiveResponse(PrintWriter out, BufferedReader in) throws Exception {
    while (true) {
      String response = in.readLine();
      if (response.length() == 0) {
        break;
      } else if (response.equals("!{}!")) {
        // 사용자로부터 값을 입력받아 서버에 보낸다.
        out.println(Prompt.inputString(""));
        out.flush(); // 주의! 출력하면 버퍼에 쌓인다. 서버로 보내고 싶다면 flush()를 호출하라!
      } else {
        System.out.println(response);
      }

    }
  }
}
