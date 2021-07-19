package com.knk.insa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Nam implements InsaM {

  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);
  PreparedStatement PST=null ;

  public Nam() {
    DB db = new DB();
    CN = db.getConnection();
  }


  @Override
  public void insert() {


  }

  @Override
  public void select() {

  }


  @Override
  public void ser() {


  }

  @Override
  public void up() {
    try {
      String uname = null;
      String ujg = null;
      int upay = 0;
      String udp = null;
      String uphone = null;
      String udate;

      select();

      System.out.println("[정보 수정]");

      System.out.print("수정하실 사번 입력 : " );
      int unum = Integer.parseInt(sc.nextLine());
      if(unum > 9999 || unum < 0 ) {
        System.out.println("잘못 입력하셨습니다.");
        return;
      }
      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("이름을 변경하시겠습니까? (y/N) ");
      String flag1 = sc.nextLine();
      if(!flag1.equals("y")) {
        System.out.println("이름변경 하지 않겠습니다.");
      } else { 
        System.out.println("------------------------------");
        System.out.print("변경할 이름을 입력하세요 : ");
        uname = sc.nextLine();
        msg="update HR set name=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uname);
        PST.setInt(2, unum );
        System.out.printf( "%d번  %s 변경완료\n " , unum, uname );
        int OK = PST.executeUpdate();
      }
      System.out.println("");
      System.out.println("-----------------------------");
      System.out.print("직급을 변경하시겠습니까? (y/N) ");
      String flag2 = sc.nextLine();
      if(!flag2.equals("y")) {
        System.out.println("직급변동 없음 ");
      } else {
        System.out.println("-----------------------------");
        System.out.print("직급변경 : ");
        ujg = sc.nextLine();
        msg = "update HR set jg=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, ujg);
        PST.setInt(2, unum);
        System.out.println(ujg +" 직급변경");
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("연봉을 변경하시겠습니까? (y/N) ");
      String flag3 = sc.nextLine();
      if(!flag3.equals("y")) {
        System.out.println("급여변동 없음");
      } else {
        System.out.println("------------------------------");
        System.out.print("변경할 연봉 입력 : ");
        upay = Integer.parseInt(sc.nextLine());
        msg = "update HR set pay=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setInt(1, upay);
        PST.setInt(2, unum);
        System.out.printf("연봉 %d만원으로 변경 " , upay);
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("부서를 변경하시겠습니까? (y/N) ");
      String flag4 = sc.nextLine();
      if(!flag4.equals("y")) {
        System.out.println("부서 변동없음");
      } else {
        System.out.println("------------------------------");
        System.out.print("부서 변경 : ");
        udp = sc.nextLine();
        msg = "update HR set dp=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, udp);
        PST.setInt(2, unum);
        System.out.printf("%s로 이동 " , udp);
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("연락처를 변경하시겠습니까? (y/N) ");
      String flag5 = sc.nextLine();
      if(!flag5.equals("y")) {
        System.out.println("연락처 유지");
      } else {
        System.out.println("------------------------------");
        System.out.print("변경된 연락처 : ");
        uphone = sc.nextLine();
        msg = "update HR set phone=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uphone);
        PST.setInt(2, unum);
        System.out.println("연락처변경 : ");
        System.out.printf("%s 변경완료 " , uphone);
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("입사일 변경하시겠습니까? (y/N) ");
      String flag6 = sc.nextLine();
      if(!flag6.equals("y")) {
        System.out.println("입사일 유지");
      } else {
        System.out.println("------------------------------");
        System.out.print("변경할 입사일 : ");
        udate = sc.nextLine();
        msg = "update HR set wdate=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, udate);
        PST.setInt(2, unum);
        System.out.printf("%s 입사일 변경완료 " , udate);
        int OK = PST.executeUpdate(); 
      }

    }catch (Exception ex) {System.out.println("잘못 입력하였습니다.");}
  }






  @Override
  public void del() {
    Insa is = new Insa();
    Kim kim = new Kim();

    try {
      kim.delselect();

      System.out.print("삭제이름 입력>>> ");
      String del = sc.nextLine();

      System.out.println("정말 삭제하시겠습니까? (y/N)");
      String h = sc.nextLine();
      if(h.equals("y")) {
        System.out.println("삭제시작");
      } else {
        System.out.println("삭제취소");
        is.menu();
      }

      msg = "delete from HR where name = '" +del +"'  ";
      ST = CN.createStatement();
      int OK = ST.executeUpdate(msg); 
      if (OK>0) {
        System.out.println(del + " 데이터 삭제성공");
        kim.select();
      }else {
        System.out.println(del + " 데이터 삭제실패");
      } 
    }catch(Exception ex) {}


  }


  @Override
  public void order() {
    // TODO Auto-generated method stub

  }





  @Override
  public void delselect() {
    // TODO Auto-generated method stub

  }

}

