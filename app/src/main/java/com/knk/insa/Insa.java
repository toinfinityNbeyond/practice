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
  Scanner sc = new Scanner(System.in);
  String uname = null;
  String ujg = null;
  int upay = 0;
  String udp = null;
  String uphone = null;


  public static void main(String[] args) {
    Kwak kw = new Kwak();
    Nam nam = new Nam();
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
          nam.order();
          break;
        default:
          System.out.println("잘못된 번호를 입력하셨습니다.");
      }
    }
  }
}
