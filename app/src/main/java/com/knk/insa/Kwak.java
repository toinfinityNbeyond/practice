package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Kwak implements InsaM {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "isud=crud쿼리문기술";
  Scanner sc = new Scanner(System.in);


  public Kwak() {
    DB db = new DB();
    CN =    db.getConnection();
  }

  public void insert() {
    try {

      // 두번째 키보드에서 데이터를 입력
      int a = -1;
      while(a>10000 || a < 0) {
        System.out.print("\n사번입력(4자릿수)>>>"); 
        a = Integer.parseInt(sc.nextLine());
        if (a>10000 || a < 0)
          System.out.println("다시입력하세요");
      }
      System.out.print("이름입력>>>"); 
      String b = sc.nextLine();
      System.out.print("직급입력>>>"); 
      String c = sc.nextLine();
      System.out.print("연봉입력>>>"); 
      int d = Integer.parseInt(sc.nextLine());
      System.out.print("부서입력>>>"); 
      String e = sc.nextLine();
      System.out.print("전화번호입력>>>"); 
      String f = sc.nextLine();

      // 3번째 쿼리문 완성
      ST = CN.createStatement();
      msg = "insert into HR(num,name,jg,pay,dp,phone) values("+a+", '"+b+"', '"+c+"',"+d+",'"+e+"','"+f+"')";
      System.out.println(msg);
      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println(a+" 코드 데이터 저장성공했습니다.");
      } else {System.out.println(a+" 코드 데이터 저장 실패했습니다.");}
    } catch(Exception ex) { System.out.println("저장실패 " + ex); }

  }

  public void ser() {

    try {

      System.out.print("검색하고 싶은 사번을 입력하세요 >>");
      int num = sc.nextInt();

      msg = ("select * from HR where num = " +num); // 문자열을 명령어로 인식해서 실행 하도록 Statement
      RS = ST.executeQuery(msg);
      System.out.println();
      System.out.println("----------------- 데이터 출력 -----------------");
      System.out.println("코 드\t이 름\t제 목\t날 짜\t\t조회수");
      while(RS.next() == true) {
        // 필드에 접근해서 데이터를 가져올때 ge        txxx()
        int unum = RS.getInt("num");
        String uname = RS.getString("name");
        java.util.Date ujg = RS.getDate("jg");
        String upay = RS.getString("pay");
        String udp = RS.getString("dp");
        String uphone = RS.getString("phone");
        System.out.println(unum +"\t" + uname+"\t" + ujg+"\t" + upay +"\t"+ udp +"\t"+ uphone+"\t");
      }
    } catch(Exception ex) { }

  }

  @Override
  public void select() {
    // TODO Auto-generated method stub

  }

  @Override
  public void up() {
    // TODO Auto-generated method stub

  }

  @Override
  public void del() {
    // TODO Auto-generated method stub

  }

  @Override
  public void order() {
    // TODO Auto-generated method stub

  }

}