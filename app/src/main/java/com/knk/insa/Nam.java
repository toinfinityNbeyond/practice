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
  String msg = "isud=crud쿼리문기술";
  Scanner sc = new Scanner(System.in);
  PreparedStatement PST=null ;

  public Nam() {
    DB db = new DB();
    CN = db.getConnection();
  }


  @Override
  public void insert() {
    // TODO Auto-generated method stub

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

      select();

      System.out.println(" [정보 수정] ");

      System.out.print(" 수정하실 사번 입력 : " );
      int unum = Integer.parseInt(sc.nextLine());
      if(unum > 9999 || unum < 0 ) {
        System.out.println(" 잘못 입력하셨습니다.");
        return;
      }
      System.out.println("------------------------------");
      System.out.print(" 이름을 변경하시겠습니까? (y/N) ");
      String flag1 = sc.nextLine();
      if(!flag1.equals("y")) {
        System.out.println(" 이름변경 하지 않겠습니다.");
      } else { 
        System.out.println("------------------------------");
        System.out.print(" 변경할 이름을 입력하세요 : ");
        uname = sc.nextLine();
        System.out.printf( " %d번  %s 변경완료\n " , unum, uname );
      }


      System.out.println("");
      System.out.println("------------------------------");
      System.out.print(" 직급을 변경하시겠습니까? (y/N) ");
      String flag2 = sc.nextLine();
      if(!flag2.equals("y")) {
        System.out.println(" 직급변동 없음 ");

      } else {
        System.out.println("------------------------------");
        System.out.print("변경할 직급 입력 : ");
        ujg = sc.nextLine();
        System.out.println(ujg +"로 직급이 변경");
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print(" 연봉을 변경하시겠습니까? (y/N) ");
      String flag3 = sc.nextLine();
      if(!flag3.equals("y")) {
        System.out.println(" 급여변동 없음 ");
      } else {
        System.out.println("------------------------------");
        System.out.print(" 변경할 연봉 입력 : ");
        upay = Integer.parseInt(sc.nextLine());
        System.out.printf(" 연봉 %d 만원으로 변경 " , upay);
      }
      System.out.println("");
      System.out.println("------------------------------");
      System.out.print(" 부서를 변경하시겠습니까? (y/N) ");
      String flag4 = sc.nextLine();
      if(!flag4.equals("y")) {
        System.out.println(" 부서 변동 없음 ");
      } else {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.print(" 변경할 부서 입력 : ");
        udp = sc.nextLine();
        System.out.printf( " %s 로 이동 " , udp);
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print(" 연락처를 변경하시겠습니까? (y/N) ");
      String flag5 = sc.nextLine();
      if(!flag5.equals("y")) {
        System.out.println(" 기존 연락처 유지");
      } else {
        System.out.println("------------------------------");
        System.out.print(" 변경된 연락처 : ");
        uphone = sc.nextLine();
        System.out.printf("%s 변경완료 " , uphone);
        System.out.println("------------------------------");
      }

      if(flag1.equals("y")) {
        msg="update HR set name=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uname);
        PST.setInt(2, unum );
        int OK = PST.executeUpdate(); 
      } if(flag2.equals("y")) {
        msg = "update HR set jg=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, ujg);
        PST.setInt(2, unum);
        int OK = PST.executeUpdate(); 
      } if (flag3.equals("y")) {
        msg = "update HR set pay=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setInt(1, upay);
        PST.setInt(2, unum);
        int OK = PST.executeUpdate(); 
      } if (flag4.equals("y")) {
        msg = "update HR set dp=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, udp);
        PST.setInt(2, unum);
        int OK = PST.executeUpdate(); 
      } if (flag5.equals("y")) {
        msg = "update HR set phone=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uphone);
        PST.setInt(2, unum);
        int OK = PST.executeUpdate(); 


      }


      //if 조건절 상관없이 실해 
      //      PST = CN.prepareStatement(msg);
      //      PST.setString(1, uname);
      //      PST.setString(1, ujg);
      //      PST.setInt(1, upay );
      //      PST.setString(1, udp );
      //      PST.setString(1, uphone );
      //      PST.setInt(2, unum );
      //      int OK = PST.executeUpdate(); //PST.executeUpdate(X비어있음)
      //      if(OK>0) { System.out.println(unum + "데이터 PST명령어 수정성공");}
      //      else {System.out.println(unum + "데이터 PST명령어  수정실패");}


    }catch (Exception ex) {System.out.println("error" + ex);}


  }


  // TODO Auto-generated method stub



  @Override
  public void del() {
    Kim kim = new Kim();

    try {
      //삭제처리는 삭제대상 필드를 정하기
      //삭제처리는 99% where 조건절 
      System.out.print("삭제이름 입력>>> ");
      String del = sc.nextLine();  //sc.next() 공백주면 분리 
      msg = "delete from HR where name = '" +del +"'  ";
      System.out.println(msg);
      ST = CN.createStatement();
      int OK = ST.executeUpdate(msg); //진짜삭제 
      if (OK>0) {
        System.out.println(del + "데이터 삭제성공");
        kim.select();
      }else {
        System.out.println(del + "데이터 삭제실패");
      } 
    }catch(Exception ex) {}

  }


  @Override
  public void order() {
    // TODO Auto-generated method stub

  }



}
