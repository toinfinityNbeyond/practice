package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EX_insa   {
  Connection CN = null; // 연결객체 생성
  Statement ST = null; // 실행객체 생성
  ResultSet RS = null; // 결과객체 생성
  String msg = "isud=crud쿼리문기술";
  Scanner sc = new Scanner(System.in);

  Kim kim = new Kim();
  Min min = new Min();
  Luna luna = new Luna();

  public static void main(String[] args) {

  } //main end

  public void DB() {

    try {
      Class.forName("oracle.jdbc.diver.OracleDriver"); 
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234");
      System.out.println("인사관리 로그인");
      ST = CN.createStatement();
    } catch (Exception e) {}


    String sel = "7";
    while (true) {
      System.out.println("1.등록 2.조회 3.검색 4.수정 5.삭제 6.정렬 7.종료 >>");
      sel = sc.nextLine();
      if(sel.equals("7")) { 
        System.out.println("프로그램 종료");
        System.exit(1);
      }// if end
      switch(sel) {
        case "1": min.add(); break;
        case "2": min.view(); break;
        case"3": kim.search(); break;
        case "4": kim.update(); break;
        case "5": kim.order(); break;
        case "6": luna.delete(); break;
        case "7": luna.order(); break;
        default : System.out.println("잘못된 명령어 입니다.");
        break;

      }// switch end

    }// while end

  }// DB end
}// class end
