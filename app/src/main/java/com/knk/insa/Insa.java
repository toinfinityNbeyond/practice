package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insa {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "isud=crud쿼리문기술";
  static Scanner sc = new Scanner(System.in);
  String uname = null;
  String ujg = null;
  int upay = 0;
  String udp = null;
  String uphone = null;


  public Insa() {
    DB db = new DB();
    CN =    db.getConnection();
  }


  public static void main(String[] args) {
    Insa ins = new Insa();

    try {

      System.out.print("아이디를 입력하세요 >>");
      //      String id = (ins.msg ="select * from log where id");

      while(sc.nextLine().equals((ins.msg="select * from log where id"))) {

        System.out.println("test");
        sc.nextLine();
        System.out.println("test1");



        //      ins.ST = ins.CN.createStatement();
        //      ins.msg = ("select * from log where id ='"+id +"'"); // 문자열을 명령어로 인식해서 실행 하도록 Statement
        //      ins.RS = ins.ST.executeQuery(ins.msg);// 2
        //      System.out.println("test2");
        //


      }

    } catch(Exception e) {System.out.println("짜증나");}



    //    try {
    //      System.out.print("아이디를 입력하세요 >>");
    //      String id = ins.sc.nextLine();
    //      System.out.println("test1");
    //      ins.ST = ins.CN.createStatement();
    //      ins.msg = ("select * from log where id ='"+id +"'"); // 문자열을 명령어로 인식해서 실행 하도록 Statement
    //      ins.RS = ins.ST.executeQuery(ins.msg);// 2
    //      System.out.println("test2");
    //
    //
    //      System.out.println("test3");
    //      System.out.print("비밀번호를 입력하세요 >>");
    //      int pw = Integer.parseInt(ins.sc.nextLine());
    //      ins.ST = ins.CN.createStatement();
    //      ins.msg = ("select * from log where psw ="+pw+"");
    //      ins.RS = ins.ST.executeQuery(ins.msg);
    //
    //      System.out.println("test4");
    //    } catch (Exception e) {System.out.println("에러");}



    try {
      while(ins.RS.next() == true) {
        // 필드에 접근해서 데이터를 가져올때 ge        txxx()
        int unum = ins.RS.getInt("num");
        String uname = ins.RS.getString("nme");
        String ujg = ins.RS.getString("jg");
        int upay = ins.RS.getInt("pay");
        String udp = ins.RS.getString("dp");
        String uphone = ins.RS.getString("phone");
        System.out.println(unum +"\t" + uname+"\t" + ujg+"\t" + upay +"\t"+ udp +"\t"+ uphone+"\t");
      }
    } catch(Exception ex) { System.out.println(ex);}





    ins.menu();



  }

  public void menu() {

    Kwak kw = new Kwak();
    Nam nam = new Nam();
    Kim kim = new Kim();
    Insa is = new Insa();

    int sel = 7;
    while(true) {
      System.out.print("\n1.등록 2.조회 3.검색  4.수정 5. 삭제 6. 정렬 7.종료 >>> ");
      sel = Integer.parseInt(is.sc.nextLine());
      if(sel == 7) {
        System.out.println("프로그램을 종료합니다.");
        System.exit(1);
      }
      switch(sel) {
        case 1: 
          kw.insert();
          break;
        case 2:
          nam.select();
          break;
        case 3:
          kw.ser();
          break;
        case 4:
          nam.up();
          break;
        case 5:
          nam.del();
          break;
        case 6:
          kim.order();
          break;
        default:
          System.out.println("잘못된 번호를 입력하셨습니다.");
      }
    }
  }

}