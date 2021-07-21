package practice;

import java.util.Scanner;

public class Min implements EX_insaM {

  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {


  }

  @Override
  public void add() { //
    try {

      String a = "1";
      while(a.equals(sc.nextLine())) {
        System.out.println("등록하실 사번 입력>>");

      }



      sc.nextLine();
    } catch (Exception e) { }
  }
  @Override
  public void view() { //

  }

  @Override
  public void search() {


  }

  @Override
  public void update() {


  }

  @Override
  public void delete() {


  }

  @Override
  public void order() {


  }

}
