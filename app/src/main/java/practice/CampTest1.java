package practice;

import java.util.Scanner;

public class CampTest1 {

  public static void main(String[] args) {
    boolean [] camp = new boolean[5];
    System.out.println("1차원배열 캠프예매 28일 월요일");
    System.out.println("1.예약 2.퇴실 3.보기 9.종료");
    System.out.println("번호를 입력하세요");
    Scanner keyScan = new Scanner(System.in);
    int num1 = keyScan.nextInt();


    switch (num1) { 
      case 1:
        System.out.println("예약하실 캠프장 번호를 입력하세요");
        Scanner keyScan1 = new Scanner(System.in);
        int num2 = keyScan1.nextInt();
        System.out.println("예약 되었습니다.");
        break;
      case 2:
        System.out.println("퇴실 캠프장 번호를 입력하세요.");
        Scanner keyScan2 = new Scanner(System.in);
        int num3 = keyScan2.nextInt();
        System.out.println("퇴실 처리 되었습니다.");
        break;
      case 3:
        System.out.println("캠프장 예약 현황");

        for(int i=0; i<camp.length; i++) {
          if(camp[i]==true) {
            System.out.println("  "+ (i+1)+"번째 ■캠프사용중입니다 "  );
          }else {
            System.out.println("  "+ (i+1)+"번째 □캠프장은 비어 있습니다 "  ); 
          }
        } 
        break;
      case 4: case 5: case 6: case 7: case 8:
        System.out.println("유효하지 않은 명령입니다.");
        break;
      default:
        System.out.println("종료되었습니다.");
        break;
    }
    System.out.println("안녕히가세요.");
    keyScan.close();
  }
}
