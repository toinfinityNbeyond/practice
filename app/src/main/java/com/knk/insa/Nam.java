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

  public Nam() {
    DB db = new DB();
    CN =    db.getConnection();
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
        System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t연락처");
        ST = CN.createStatement();
        msg = "select * from HR";
        ResultSet rs = ST.executeQuery(msg);
        /*RS = ST.executeQuery(msg);
        ST = CN.createStatement();*/
        while(rs.next()==true) {
          String uname = rs.getString("name");
          int unum = rs.getInt("num");
          String ujg = rs.getString("jg");
          int upay = rs.getInt("pay");
          String udp = rs.getString("dp");
          String uphone = rs.getString("phone");
          System.out.println(unum  +"\t" +  uname +"\t"+ ujg +"\t" + upay +"\t"+ udp +"\t"+ uphone);
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

    String uname = null;
    String ujg = null;
    int upay = 0;
    String udp = null;
    String uphone = null;

    try {
      System.out.println(" [정보 수정] ");

      System.out.print(" 수정하실 사번 입력 : " );
      int unum = Integer.parseInt(sc.nextLine());
      if(unum > 9999 || unum < 0 ) {
        System.out.println(" 잘못 입력하셨습니다.");
        return;
      }
      System.out.println("------------------------------");
      System.out.print(" 이름을 변경하시겠습니까? (y/N) ");
      if(!sc.nextLine().equals("y")) {
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
      if(!sc.nextLine().equals("y")) {
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
      if(!sc.nextLine().equals("y")) {
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
      if(!sc.nextLine().equals("y")) {
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
      if(!sc.nextLine().equals("y")) {
        System.out.println(" 기존 연락처 유지");
      } else {
        System.out.println("------------------------------");
        System.out.print(" 변경된 연락처 : ");
        uphone = sc.nextLine();
        System.out.printf("%s 변경완료 " , uphone);
        System.out.println("------------------------------");
      }

      msg="update HR set num=?, name=?, jg=? , pay=?, dp=?, phone=? where code = ?";
      PreparedStatement PST = CN.prepareStatement(msg);
      PST.setInt(1, unum);
      PST.setString(2, uname);
      PST.setString(3, ujg );
      PST.setInt(4, upay );
      PST.setString(5, udp );
      PST.setString(6, uphone );
      int OK = PST.executeUpdate(); //PST.executeUpdate(X비어있음)
      if(OK>0) { System.out.println(unum + "데이터 PST명령어 수정성공");}
      else {System.out.println(unum + "데이터 PST명령어  수정실패");}


    }catch (Exception ex) {}


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
      msg = "delete from test  where name = '" +del +"'  ";
      System.out.println(msg);
      ST = CN.createStatement();
      int OK = ST.executeUpdate(msg); //진짜삭제 
      if (OK>0) {
        System.out.println(del + "데이터 삭제성공");
        select();
      }else {
        System.out.println(del + "데이터 삭제실패");
      } 
    }catch(Exception ex) {}

  }

  @Override
  public void order() {
    //    try {  
    //    System.out.println("정렬 기준을 선택하세요. 1.이름 2.사번");
    //    int od = 3; 
    //    od = Integer.parseInt(sc.nextLine());
    //    if (od == 1 ) {
    //    if(od == 1) {
    //      }else {
    //    }
    //    

    try {  
      System.out.println("정렬 기준을 선택하세요. 1.이름 2.사번");
      int od = 3; 
      od = Integer.parseInt(sc.nextLine());
      if (od == 1 ) {
        if(od == 1) {
          System.out.println("정렬 방법을 선택하세요. 1.오름차순 2.내림차순");
          od = Integer.parseInt(sc.nextLine());
          System.out.println("------------------------데이터 정렬------------------------");
          System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t\t전화번호");
          /*RS = ST.executeQuery(msg);
          ST = CN.createStatement();*/

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

            System.out.println( uname + "\t"+ unum  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
          }// while
          System.out.println();
          System.out.println("이름 기준 오름차순으로 정렬되었습니다.");}

        else {
          System.out.println("정렬 방법을 선택하세요. 1.오름차순 2.내림차순");
          od = Integer.parseInt(sc.nextLine());
          System.out.println("------------------------데이터 정렬------------------------");
          System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t전화번호");
          /* RS = ST.executeQuery(msg);
          ST = CN.createStatement(); */
          System.out.println("test1");
          ST = CN.createStatement();
          msg ="select  * from  HR  order by decs Name";
          ResultSet rs = ST.executeQuery(msg);
          System.out.println("test2");
          while(rs.next()==true) {
            String uname = rs.getString("name");
            int unum = rs.getInt("num");
            String ujg = rs.getString("jg");
            int upay = rs.getInt("pay");
            String udp = rs.getString("dp");
            int uphone = rs.getInt("phone");
            System.out.println("test3");
            System.out.println( uname + "\t"+ unum  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone);
          }    
          System.out.println();
          System.out.println("이름 기준 내림차순으로 정렬되었습니다.");
        }
      }else if (od ==2) {
        if(od == 1) {
          System.out.println("정렬 방법을 선택하세요. 1.오름차순 2.내림차순");
          od = Integer.parseInt(sc.nextLine());
          System.out.println();
          System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t전화번호");
          ST = CN.createStatement();
          msg ="select  * from  HR  order by name";
          ResultSet rs = ST.executeQuery(msg);
          /*RS = ST.executeQuery(msg);
          ST = CN.createStatement(); */
          String uname = rs.getString("name");
          int unum = rs.getInt("num");
          String ujg = rs.getString("jg");
          int upay = rs.getInt("pay");
          String udp = rs.getString("dp");
          int uphone = rs.getInt("phone");

          System.out.println(uname+ unum  + ujg + upay + udp + uphone);
          System.out.println();

          System.out.println("사번 기준 오름차순으로 정렬되었습니다.");
        } else {
          od = Integer.parseInt(sc.nextLine());
          System.out.println();
          System.out.println("사 번\t이 름\t직 급\t연 봉\t부 서\t전화번호");
          ST = CN.createStatement();
          msg ="select  * from  HR  order by desc name";
          ResultSet rs = ST.executeQuery(msg);
          /*RS = ST.executeQuery(msg);
          ST = CN.createStatement();*/
          String uname = rs.getString("name");
          int unum = rs.getInt("num");
          String ujg = rs.getString("jg");
          int upay = rs.getInt("pay");
          String udp = rs.getString("dp");
          int uphone = rs.getInt("phone");

          System.out.println(uname+ unum   + ujg + upay + udp + uphone);
          System.out.println();

          System.out.println("사번 기준 내림차순으로 정렬되었습니다.");
        }
      } else {System.out.println("잘못된 명령어입니다.");}
    } catch (Exception e) { }

  }




}

