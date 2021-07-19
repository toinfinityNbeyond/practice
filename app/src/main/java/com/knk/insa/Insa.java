package com.knk.insa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insa {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Insa dt = new Insa();
    System.out.println("언어를 선택하세요 [Please select a language.]");
    System.out.println("[1. 한국어] [2. English]");
    String lang = dt.sc.nextLine();
    switch(lang) {
      case "1" : dt.dbq(); break;
      case "2" : dt.dbqE(); break;
      default : System.out.println("잘못입력하셨습니다 [You've entered something wrong]");
    }
    dt.sc.close();
  }

  public void dbqE() {


    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234");
      System.out.println("Human Resources Login");
      ST = CN.createStatement();  

      loop: while(true) {
        System.out.print("ID : ");
        String getid =sc.nextLine();

        msg = "select count(*) as temp from log where id ='"+getid+"'";

        RS = ST.executeQuery(msg);

        if(RS.next() == true) {

          int data = RS.getInt("temp");
          if (data >0)  { 
            System.out.print("PW : ");
            String getpw =sc.nextLine();

            msg = "select count(*) as temp from log where id ='"+getid+"'  and pw ='" + getpw + "'";

            RS = ST.executeQuery(msg);
            if(RS.next() == true) {
              int data2 = RS.getInt("temp");

              switch (data2) {
                case 1: System.out.println("[Login Successful!]");break loop;
                default: System.out.println("You have entered an invalid password.");break;
              } 
            }
          } else { 
            System.out.println("Unregistered ID or invalid ID\n");
          }
        }//3 if end
      }//2 wile end
      //1 while end

    } catch(Exception ex) {  System.out.println("error = " + ex);}
    menuE();

  }

  public void dbq() {

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234");
      System.out.println("인사관리 로그인");
      ST = CN.createStatement();  
      loop: while(true) {
        System.out.print("ID : ");
        String getid =sc.nextLine();

        msg = "select count(*) as temp from log where id ='"+getid+"'";
        RS = ST.executeQuery(msg);

        if(RS.next() == true) {
          int data = RS.getInt("temp");

          if (data >0)  { 
            System.out.print("PW : ");
            String getpw =sc.nextLine();

            msg = "select count(*) as temp from log where id ='"+getid+"'  and pw ='" + getpw + "'";
            RS = ST.executeQuery(msg);

            if(RS.next() == true) {
              int data2 = RS.getInt("temp");

              switch (data2) {
                case 1: System.out.println("로그인성공!");break loop;
                default: System.out.println("잘못된 비밀번호를 입력하셨습니다.");break;
              } 
            }
          } else { 
            System.out.println("등록되지 않은 아이디 또는 잘못된 ID입니다.\n");
          }
        }//3 if end
      }//2 wile end
      //1 while end

    } catch(Exception ex) {  System.out.println("error = " + ex);}
    menu();

  }
  public void menu() {
    Kwak kw = new Kwak();
    Kim kim = new Kim();
    Nam nam = new Nam();

    String sel = "9";
    while(true) {
      System.out.print("\n[1.등록] [2.조회] [3.검색] [4.수정] [5.삭제] [6.정렬] [7.로그아웃] [9.종료] : ");
      sel = sc.nextLine();
      if(sel.equals("9")) {
        System.out.println("[프로그램 종료]");
        System.exit(1);
      }

      switch(sel) {
        case "1": 
          kw.insert();
          break;
        case "2":
          kim.select();
          break;
        case "3":
          kw.ser();
          break;
        case "4":
          nam.up();
          break;
        case "5":
          nam.del();
          break;
        case "6":
          kim.order();
          break;
        case "7": {
          System.out.println("[로그아웃]");
          dbq();
          break;
        }
        default:
          System.out.println("잘못된 번호를 입력하셨습니다.");
      }
    }
  }
  public void menuE() {
    KwakE kwE = new KwakE();
    KimE kimE = new KimE();
    NamE namE = new NamE();


    String sel = "9";
    while(true) {
      System.out.print("\n[1.Add] [2.Select] [3.Search] [4.Edit] [5.Delete] [6.Order] [7.Log-Out] [9.Exit] : ");
      sel = sc.nextLine();
      if(sel.equals("9")) {
        System.out.println("[Program Exit]");
        System.exit(1);
      }

      switch(sel) {
        case "1": 
          kwE.insert();
          break;
        case "2":
          kimE.select();
          break;
        case "3":
          kwE.ser();
          break;
        case "4":
          namE.up();
          break;
        case "5":
          namE.del();
          break;
        case "6":
          kimE.order();
          break;
        case "7": {
          System.out.println("[Log-Out]");
          dbqE();
          break;
        }
        default:
          System.out.println("You have entered an invalid number");
      }
    }
  }
}
