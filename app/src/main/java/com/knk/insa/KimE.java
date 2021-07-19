package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class KimE implements InsaM {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);

  public KimE() {
    DB db = new DB();
    CN = db.getConnection();
  }


  @Override
  public void insert() {
    // TODO Auto-generated method stub

  }



  @Override
  public void select() {
    try {
      System.out.println("Do you want to look up the data? (y/N)");

      if (sc.nextLine().equals("y")) {
        System.out.println("-----------------------------Data List-------------------------------");
        System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
        ST = CN.createStatement();
        msg = "select * from HR";
        ResultSet rs = ST.executeQuery(msg);
        while(rs.next()==true) {
          String uname = rs.getString("name");
          int unum = rs.getInt("num");
          String ujg = rs.getString("jg");
          int upay = rs.getInt("pay");
          String udp = rs.getString("dp");
          String uphone = rs.getString("phone");
          String udate = rs.getString("wdate");

          System.out.println(unum  +"\t"+ uname +"\t"+ ujg +"\t"+ upay +"\t"+ udp +"\t"+ uphone +"\t"+ udate);
          // System.out.println();
        }

        System.out.println();
        System.out.println("Query completed");
      }else {
        System.out.println("cancel the inquiry");
      }
      System.out.println("");
    } catch (Exception e) {System.out.println("You entered it incorrectly.");}

  }

  @Override
  public void ser() {
    // TODO Auto-generated method stub

  }

  @Override
  public void up() {
    // TODO Auto-generated method stub

  }

  @Override
  public void del() {
    // TODO Auto-generated method stub

  }

  @Override
  public void order() {
    try {
      System.out.println("Select sorting criteria. [1.Name] [2.Number]");
      int od = 2;
      od = Integer.parseInt(sc.nextLine());
      switch(od) {
        case 1: 
          System.out.println("Please select a sorting method. [1. ascending order] [2. descending order]");
          od = Integer.parseInt(sc.nextLine());
          switch(od) {
            case 1: name_asc(); break;
            case 2: name_desc(); break;
            default: System.out.println("Invalid command");
          } break;

        case 2: 
          System.out.println("Please select an alignment method. [1. ascending order] [2. descending order]");
          od = Integer.parseInt(sc.nextLine());
          switch(od) {
            case 1: num_asc(); break;
            case 2: num_desc(); break;
            default: System.out.println("Invalid command");
          }break;

        default: System.out.println("Invalid command");
        break;

      }//switch end

    }catch(Exception e) {System.out.println("You entered it incorrectly");}
  }


  public  void name_asc() {
    try {
      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by name";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");
        String udate = rs.getString("wdate");

        System.out.println(  unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone+ "\t" + udate);
      }// while
      System.out.println();
      System.out.println("Ordered in ascending order by Name.");

    }catch (Exception e) {System.out.println("You entered it incorrectly");}
  }


  public  void name_desc() {
    try {
      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by name desc";
      ResultSet rs = ST.executeQuery(msg);

      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");
        String udate = rs.getString("wdate");


        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone+ "\t" + udate);
      }// while
      System.out.println();
      System.out.println("Sorted in descending order by Name.");

    }catch (Exception e) {System.out.println("You entered it incorrectly");}
  }


  public  void num_asc() {
    try {
      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by num";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");
        String udate = rs.getString("wdate");

        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone +"\t"+udate);
      }// while
      System.out.println();
      System.out.println("Ordered in ascending order by Number.");

    }catch (Exception e) {System.out.println("You entered it incorrectly.");}
  }


  public  void num_desc() {
    try {
      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
      ST = CN.createStatement();
      msg ="select  * from  HR  order by num desc";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");
        String udate = rs.getString("wdate");

        System.out.println( unum + "\t"+ uname  +"\t" + ujg + "\t" + upay +"\t"+ udp + "\t" + uphone + "\t" + udate);
      }// while
      System.out.println();
      System.out.println("Sorted in descending order by Number.");

    }catch (Exception e) {System.out.println("You entered it incorrectly.");}
  }


  @Override
  public void delselect() {
    try {
      // TODO Auto-generated method stub
      System.out.println("Retrieving data....");
      Thread.sleep(3000);
      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Num\tName\tPosition\tPay\tDepartment\tPhone num\t\tDate of joining");
      ST = CN.createStatement();
      msg = "select * from HR";
      ResultSet rs = ST.executeQuery(msg);
      while(rs.next()==true) {
        String uname = rs.getString("name");
        int unum = rs.getInt("num");
        String ujg = rs.getString("jg");
        int upay = rs.getInt("pay");
        String udp = rs.getString("dp");
        String uphone = rs.getString("phone");
        String udate = rs.getString("wdate");

        System.out.println(unum  +"\t"+ uname +"\t"+ ujg +"\t"+ upay +"\t"+ udp +"\t"+ uphone +"\t"+ udate);

      }

    }catch (Exception ex) {}

  }
}// END