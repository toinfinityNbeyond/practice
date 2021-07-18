package com.knk.insa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NamE implements InsaM {

  Connection CN = null; 
  Statement ST = null; 
  ResultSet RS = null; 
  String msg = "";
  Scanner sc = new Scanner(System.in);
  PreparedStatement PST=null ;

  public NamE() {
    DB db = new DB();
    CN = db.getConnection();
  }


  @Override
  public void insert() {
    // TODO Auto-generated method stub

  }

  @Override
  public void select() {

  }


  @Override
  public void ser() {


  }

  @Override
  public void up() {
    try {
      String uname = null;
      String ujg = null;
      int upay = 0;
      String udp = null;
      String uphone = null;
      String udate;

      select();

      System.out.println("[Info Update]");

      System.out.print("Enter the number you want to modify : " );
      int unum = Integer.parseInt(sc.nextLine());
      if(unum > 9999 || unum < 0 ) {
        System.out.println("You've entered something wrong.");
        return;
      }
      System.out.println("------------------------------");
      System.out.print("Do you want to change the name? (y/N) ");
      String flag1 = sc.nextLine();
      if(!flag1.equals("y")) {
        System.out.println("I won't change the name.");
      } else { 
        System.out.println("------------------------------");
        System.out.print(" Please enter the name you want to change : ");
        uname = sc.nextLine();
        msg="update HR set name=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uname);
        PST.setInt(2, unum );
        System.out.printf( " %d  %s Change completed\n " , unum, uname );
        int OK = PST.executeUpdate();
      }


      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("Would you like to change your position? (y/N) ");
      String flag2 = sc.nextLine();
      if(!flag2.equals("y")) {
        System.out.println("I won't change my position.");

      } else {
        System.out.println("------------------------------");
        System.out.print("Position change : ");
        ujg = sc.nextLine();
        msg = "update HR set jg=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, ujg);
        PST.setInt(2, unum);
        System.out.println(ujg +"Position change");
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("Would you like to change your pay? (y/N) ");
      String flag3 = sc.nextLine();
      if(!flag3.equals("y")) {
        System.out.println("No pay changes");
      } else {
        System.out.println("------------------------------");
        System.out.print(" Enter pay to change : ");
        upay = Integer.parseInt(sc.nextLine());
        msg = "update HR set pay=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setInt(1, upay);
        PST.setInt(2, unum);
        System.out.printf(" %d pay change " , upay);
        int OK = PST.executeUpdate(); 
      }
      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("Do you want to change departments? (y/N) ");
      String flag4 = sc.nextLine();
      if(!flag4.equals("y")) {
        System.out.println("No Department Changes ");
      } else {
        System.out.println("------------------------------");
        System.out.print("Change Department : ");
        udp = sc.nextLine();
        msg = "update HR set dp=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, udp);
        PST.setInt(2, unum);
        System.out.printf("%s Go to Department " , udp);
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print("Do you want to change your Phone Number? (y/N) ");
      String flag5 = sc.nextLine();
      if(!flag5.equals("y")) {
        System.out.println("Do not change Phone Number");
      } else {
        System.out.println("------------------------------");
        System.out.print(" Changed Phone Number : ");
        uphone = sc.nextLine();
        msg = "update HR set phone=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, uphone);
        PST.setInt(2, unum);
        System.out.println("Changed Phone Number : ");
        System.out.printf("%s Change completed " , uphone);
        int OK = PST.executeUpdate(); 
      }

      System.out.println("");
      System.out.println("------------------------------");
      System.out.print(" Would you like to change the date of joining the company? (y/N) ");
      String flag6 = sc.nextLine();
      if(!flag6.equals("y")) {
        System.out.println("Do not change the date of entry");
      } else {
        System.out.println("------------------------------");
        System.out.print("Job Date to Change : ");
        udate = sc.nextLine();
        msg = "update HR set wdate=? where num = ?";
        PST = CN.prepareStatement(msg);
        PST.setString(1, udate);
        PST.setInt(2, unum);
        System.out.printf("%s Change completed " , udate);
        int OK = PST.executeUpdate(); 
      }

    }catch (Exception ex) {System.out.println("I entered it incorrectly entered.");}
  }


  // TODO Auto-generated method stub



  @Override
  public void del() {
    Kim kim = new Kim();

    try {
      kim.delselect();

      System.out.print("Enter Delete Name :  ");
      String del = sc.nextLine();
      msg = "delete from HR where name = '" +del +"'  ";
      ST = CN.createStatement();
      int OK = ST.executeUpdate(msg); 
      if (OK>0) {
        System.out.println(del + " Successfully deleted data");
        kim.select();
      }else {
        System.out.println(del + " Failed to delete data");
      } 
    }catch(Exception ex) {System.out.println("I entered it incorrectly entered.");}


  }


  @Override
  public void order() {
    // TODO Auto-generated method stub

  }





  @Override
  public void delselect() {
    // TODO Auto-generated method stub

  }

}

