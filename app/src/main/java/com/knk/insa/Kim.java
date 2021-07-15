package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Kim implements InsaM {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);

  public Kim() {
    DB db = new DB();
    CN = db.getConnection();
  }


  @Override
  public void insert() {
    // TODO Auto-generated method stub

  }



  @Override
  public void select() {
    try {
      System.out.println("조회 하시겠습니까? (y/N)");

      if (sc.nextLine().equals("y")) {
        System.out.println("------------------------데이터 조회------------------------");
        System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처\t\t입사날짜");
        ST = CN.createStatement();
        msg = "select * from HR";
        ResultSet rs = ST.executeQuery(msg);
        while(rs.next()==true) {
          String uname = rs.getString("name");
          int unum = rs.getInt("num");
          String ujg = rs.getString("jg");
          int upay = rs.getInt("pay");
          String udp = rs.getString("dp");
          String uphone = rs.getString("phone");
          String udate = rs.getString("wdate");
          System.out.println(unum  +"\t" +  uname +"\t"+ ujg +"\t" + upay +"\t"+ udp +"\t"+ uphone+"\t"+udate);
        }
        System.out.println("조회 완료되었습니다.");
      }else {
        System.out.println("조회 취소되었습니다.");
      }
      System.out.println("");
    } catch (Exception e) {}

  }

  @Override
  public void ser() {
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
    try {
      System.out.println("정렬 기준을 선택하세요. 1.이름 2.사번");
      int od = 2;
      od = Integer.parseInt(sc.nextLine());
      switch(od) {
        case 1: 
          System.out.println("정렬 방법을 선택하세요. 1.오름차순 2.내림차순");
          od = Integer.parseInt(sc.nextLine());
          switch(od) {
            case 1: name_asc(); break;
            case 2: name_desc(); break;
            default: System.out.println("잘못된 명령어입니다.");
          } break;

        case 2: 
          System.out.println("정렬 방법을 선택하세요. 1.오름차순 2.내림차순");
          od = Integer.parseInt(sc.nextLine());
          switch(od) {
            case 1: num_asc(); break;
            case 2: num_desc(); break;
            default: System.out.println("잘못된 명령어입니다.");
          }break;

        default: System.out.println("잘못된 명령어입니다.");
        break;

      }//switch end

    }catch(Exception e) {}
  }


  public  void name_asc() {
    try {
      System.out.println("------------------------데이터 정렬------------------------");
      System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by name";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        int uphone = rs.getInt("phone");

        System.out.println(  unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
      }// while
      System.out.println();
      System.out.println("이름 기준 오름차순으로 정렬되었습니다.");

    }catch (Exception e) {}
  }


  public  void name_desc() {
    try {
      System.out.println("------------------------데이터 정렬------------------------");
      System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by name desc";
      ResultSet rs = ST.executeQuery(msg);

      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        int uphone = rs.getInt("phone");

        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
      }// while
      System.out.println();
      System.out.println("이름 기준 내림차순으로 정렬되었습니다.");

    }catch (Exception e) {}
  }


  public  void num_asc() {
    try {
      System.out.println("------------------------데이터 정렬------------------------");
      System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by num";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        int uphone = rs.getInt("phone");

        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
      }// while
      System.out.println();
      System.out.println("사번 기준 오름차순으로 정렬되었습니다.");

    }catch (Exception e) {}
  }


  public  void num_desc() {
    try {
      System.out.println("------------------------데이터 정렬------------------------");
      System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by num desc";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");

        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
      }// while
      System.out.println();
      System.out.println("사번 기준 내림차순으로 정렬되었습니다.");

    }catch (Exception e) {}
  }


}// END
