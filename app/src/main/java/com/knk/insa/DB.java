package com.knk.insa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
  Connection CN = null;
  PreparedStatement PST = null;
  ResultSet RS = null;


  public  Connection getConnection() {

    try {  
      //127.0.0.1
      Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클드라이브로드
      CN= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
    }catch (Exception ex) {  System.out.println("0715 목요일 db error= " + ex);}
    return CN;
  }
}