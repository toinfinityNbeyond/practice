package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Min implements EX_insaM {

  Connection CN = null; // 연결객체 생성
  Statement ST = null; // 실행객체 생성
  ResultSet RS = null; // 결과객체 생성
  String msg = "";
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {


  }

  @Override
  public void add() { //
    try {

      String a = "1";
      while(a.equals(sc.nextLine())) {
        System.out.println("등록하실 사번 입력>>");

      }
      System.out.println("이름 >>");
      System.out.println("부서 >>");
      System.out.println("직급 >>");
      System.out.println("연봉 >>");
      System.out.println("연락처 >>");
      System.out.println("입사일 >>");



      sc.nextLine();
    } catch (Exception e) { }
  }
  @Override
  public void view() { //

    try {
      System.out.println("조회하시겠습니까?(y/N)");

      if (sc.nextLine().equals("y")) {
        System.out.println("--------------조회------------");
        System.out.println("사번\t이름\t부서\t직급\t연봉\t연락처\t입사일");
        ST = CN.createStatement();
        msg = "select * from HR";
        ResultSet rs = ST.executeQuery(msg);
      }
    }catch(Exception e) {}
  }

  @Override
  public void search() {


  }

  @Override
  public void update() {


  }

  @Override
  public void delete() {


  }

  @Override
  public void order() {


  }

}
