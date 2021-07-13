package com.knk.insa;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {


  public Connection getConnection() {
    Connection  CN = null;
    try {  
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
      System.out.println("연결성공 3:03434534535");
    }catch (Exception ex) {  System.out.println("db error= " + ex);}
    return CN;
  }
}
