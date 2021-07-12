package practice;

public class Ex {

  public static void main(String[] args) {
    method1();
  }

  static void method1 () {
    try {
      throw new Exception();

    }catch (Exception e) {
      System.out.println("method1 메서드가 예외처리 되었습니다.");
      e.printStackTrace();
    }
  }
}
