package com.knk.insa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class KwakE implements InsaM {
  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);


  public KwakE() {
    DB db = new DB();
    CN =    db.getConnection();
  }

  public void insert() {
    KimE kimE = new KimE();
    Insa is = new Insa();
    try {

      kimE.delselect();

      int a = -1;
      while(a>10000 || a < 0) {
        System.out.print("\nNumber : "); 
        a = Integer.parseInt(sc.nextLine());
        if (a>10000 || a < 0)
          System.out.println("You entered it incorrectly.");
      }
      System.out.print("Name : "); 
      String b = sc.nextLine();
      System.out.print("Position: "); 
      String c = sc.nextLine();
      System.out.print("Pay : "); 
      int d = Integer.parseInt(sc.nextLine());
      System.out.print("Department : "); 
      String e = sc.nextLine();
      System.out.print("Phone number( - Exception) : "); 
      String f = sc.nextLine();
      System.out.print("Date of joining ex)YY/MM/DD : "); 
      String g = sc.nextLine();
      System.out.println("Do you want to register? (y/N)");
      String h = sc.nextLine();
      if(h.equals("y")) {
        System.out.println("Registration completed");
      }
      else {
        System.out.println("Unregister");
        is.menu();
      }

      ST = CN.createStatement();
      msg = "insert into HR(num,name,jg,pay,dp,phone,wdate) values("+a+", '"+b+"', '"+c+"',"+d+",'"+e+"','"+f+"',to_date('"+g+"'))";

      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println(a+" Registration completed");
      } else {System.out.println(a+"Registration Failed");}
    } catch(Exception ex) { System.out.println("Please re-enter."); }

  }

  public void ser() {

    try {

      System.out.print("Number : ");
      int num = sc.nextInt();

      ST = CN.createStatement();
      msg = ("select * from HR where num ="+num); 
      RS = ST.executeQuery(msg);
      System.out.println();

      System.out.println("-----------------------------Data List-------------------------------");
      System.out.println("Number\tName\tPosition\tPay\tDepartment\tPhone number\t\tDate of joining");
      while(RS.next() == true) {

        int unum = RS.getInt("num");
        String uname = RS.getString("name");
        String ujg = RS.getString("jg");
        int upay = RS.getInt("pay");
        String udp = RS.getString("dp");
        String uphone = RS.getString("phone");
        String udate = RS.getString("wdate");
        System.out.println(unum + "\t" + uname + "\t" + ujg + "\t"  + upay + "\t" + udp + "\t" + uphone + "\t" +udate);
      }
    } catch(Exception ex) {System.out.println("Please re-enter.");}

  }

  @Override
  public void select() {

  }


  @Override
  public void up() {


  }

  @Override
  public void del() {


  }

  @Override
  public void order() {


  }


  @Override
  public void delselect() {
    // TODO Auto-generated method stub

  }

}