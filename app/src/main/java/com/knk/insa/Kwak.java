package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Kwak implements InsaM {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);


  public Kwak() {
    DB db = new DB();
    CN =    db.getConnection();
  }

  public void insert() {
    Insa is = new Insa();
    Kim kim = new Kim();


    try {
      kim.delselect();

      int a = -1;
      while(a>10000 || a < 0) {
        System.out.print("\n사번 : "); 
        a = Integer.parseInt(sc.nextLine());
        if (a>10000 || a < 0)
          System.out.println("잘못된 명령어입니다.");
      }
      System.out.print("이름 : "); 
      String b = sc.nextLine();
      System.out.print("직급 : "); 
      String c = sc.nextLine();
      System.out.print("연봉 : "); 
      int d = Integer.parseInt(sc.nextLine());
      System.out.print("부서 : "); 
      String e = sc.nextLine();
      System.out.print("연락처( - 제외) : "); 
      String f = sc.nextLine();
      System.out.print("입사일 ex)YY/MM/DD : "); 
      String g = sc.nextLine();
      System.out.println("등록하시겠습니까? (y/N)");
      String h = sc.nextLine();
      if(h.equals("y")) {
        System.out.println("등록완료");
      }
      else {
        System.out.println("등록취소");
        is.menu();
      }
      ST = CN.createStatement();
      msg = "insert into HR(num,name,jg,pay,dp,phone,wdate) values("+a+", '"+b+"', '"+c+"',"+d+",'"+e+"','"+f+"',to_date('"+g+"'))";

      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println(a+"번 등록완료");
      } else {System.out.println(a+"번 등록실패");}
    } catch(Exception ex) { System.out.println("다시 입력하세요."); }

  }

  public void ser() {

    try {

      System.out.print("사번 : ");
      int num = sc.nextInt();

      ST = CN.createStatement();
      msg = ("select * from HR where num ="+num); 
      RS = ST.executeQuery(msg);
      System.out.println();

      System.out.println("--------------------------데이터 조회----------------------------");
      System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처\t\t입사일");
      while(RS.next() == true) {

        int unum = RS.getInt("num");
        String uname = RS.getString("name");
        String ujg = RS.getString("jg");
        int upay = RS.getInt("pay");
        String udp = RS.getString("dp");
        String uphone = RS.getString("phone");
        String udate = RS.getString("wdate");
        System.out.println(unum + "\t" + uname + "\t" + ujg + "\t"  + upay + "\t" + udp + "\t" + uphone + "\t" +udate);
      }
    } catch(Exception ex) {System.out.println("다시 입력하세요.");}

  }

  @Override
  public void select() {

  }


  @Override
  public void up() {


  }

  @Override
  public void del() {


  }

  @Override
  public void order() {


  }


  @Override
  public void delselect() {
    // TODO Auto-generated method stub

  }

}