package com.knk.insa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insa {
  Connection CN = null; // db서버 연결정보 서버ip주소 계정ip,pwd
  Statement ST = null; // ST=CN.createStatement() 명령어생성 삭제,신규등록,조회하라
  ResultSet RS = null; // select 조회결과 값 전체 데이터를 기억합니다.
  String msg = "isud=crud쿼리문기술";
  Scanner sc = new Scanner(System.in);
  int Gtotal = 0; // 조회갯수72 /  전체갯수349 전체갯수 = gtotal


  public static void main(String[] args) {

    Insa dt = new Insa();

    dt.dbq();
    dt.sc.close();


  }


  public void dbq() {
    Kwak kw = new Kwak();
    Kim kim = new Kim();
    Nam nam = new Nam();


    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이브 로드 
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234");
      //System.out.println("오라클 계정 비번 드라이버 연결");
      System.out.println("인사관리 로그인");
      ST = CN.createStatement();  // 첫번째 명령어 생성
      loop: while(true) {
        System.out.print("ID : ");
        String getid =sc.nextLine();
        System.out.print("PW : ");
        String getpw =sc.nextLine();

        msg = "select count(*) as temp from log where id ='"+getid+"'  and pw ='" + getpw + "'";
        //msg = "select count(*) as temp from log where id ='"+getid+"'  and pw ='" + getpw + "'";


        RS = ST.executeQuery(msg);
        String id1 = "";
        if(RS.next() == true) {
          //id1 = RS.getString("id");
          int data = RS.getInt("temp");
          if (data >0)  { 
            System.out.println( getid +" 로그인 되었습니다.");
            break loop;
          }

          else { 
            System.out.println("ID 또는 PW가 틀렸습니다.\n");
          }



        }//3 if end
      }//2 wile end
      //1 while end

    } catch(Exception ex) {  System.out.println("error = " + ex);}


    String sel = "9";
    while(true) {
      System.out.println("\n1.등록 2.조회 3.검색 4.수정 5.삭제 6.정렬 7.로그아웃 9.종료 >>> ");
      sel = sc.nextLine();
      if(sel.equals("9")) {
        System.out.println("프로그램 종료");
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
}


