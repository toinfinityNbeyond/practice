package practice;

import java.util.Scanner;

public class Work05Hotel {   

  private int floor ; //층=행 3층
  private int room ;  //호=열 5호  3층*5열=15방구성
  private String[][] name = new String[3][5];
  private String title;

  public Work05Hotel(){ }
  public Work05Hotel(String name){ }
  public Work05Hotel(String name, int year){ }


  public void process() {
    //map()호출
    map();

    Scanner sc = new Scanner(System.in);
    int sel = 9;
    while(true) {
      System.out.print("\n1.투숙  2.퇴실  3.map  4.list 9.종료 >>>");
      sel = Integer.parseInt(sc.nextLine());
      if(sel==9) { 
        System.out.println("호텔예약프로그램 종료합니다");
        System.exit(1);
      }
      switch(sel) {
        case 4: list();break;
      }//switch end
    }//while end
  }//end

  public void checkIn() {

  }//end

  public void checkOut() {

  }//end

  public void map(){ //non-static메소드 
    System.out.println("\n\t[  map 투숙 상태 ]");
    for(int i = 0; i < 3; i++){
      for(int b = 0; b < 5; b++){
        System.out.print((i+1)+"0"+(b+1)+"\t");
      }

      System.out.println(); //이름표시 공백란입니다

      for(int j = 0; j < 5; j++){
        if(this.name[i][j] == null){
          System.out.print("\t");
          continue;
        }//if end
        System.out.print(this.name[i][j]+"\t"); 
      }//j end
      System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"); // \n꼭넣으세요 
    }//for i end
  } //map end

  public void list() { //영림쌤 구현해서 보여드리겠습니다 
    System.out.println("\n\t[ list ]");
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 5; j++){
        if(name[i][j] == null) {
          System.out.print( " " + (i+1)+"0"+(j+1) +"호"+"□\t" +"\t"); 
        }else {
          System.out.print( " " + (i+1)+"0"+(j+1) +"호"+"■\t" + name[i][j] + "\t"); 
        }
      } //j end
      System.out.println();
    }//for i end
  }//end

  public static void main(String[] args) {
    System.out.println("7월1일 목요일  4시19분");
    Work05Hotel wh = new Work05Hotel();
    wh.process();
  }//end
}//class END



