package com.knk.insa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  String msg = "isud=crud쿼리문기술";
  String uname = null;
  String ujg = null;
  int upay = 0;
  String udp = null;
  String uphone = null; //


  public Connection getConnection() {
    Connection  CN = null;
    try {  
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
      System.out.println("연결성공 3:03434534535");
    }catch (Exception ex) {  System.out.println("db error= " + ex);}
    return CN;
  }
}
