package practice;

public class FighterTest {

  public static void main(String[] args) {
    Fighter f = new Fighter();
    if (f instanceof Unit)
      System.out.println("f는 Unit클래스의 자손입니다.");

    if (f instanceof Unit)
      System.out.println("f는 Fightable클래스의 자손입니다.");

    if (f instanceof Unit)
      System.out.println("f는 Movable클래스의 자손입니다.");

    if (f instanceof Unit)
      System.out.println("f는 Attackable클래스의 자손입니다.");

    if (f instanceof Unit)
      System.out.println("f는 Object클래스의 자손입니다.");


  }
}

class Fighter extends Unit implements Fightable {
  public void move(int x, int y) {}
  public void attack(Unit u) {}

}

class Unit {
  int currentHP;
  int x;
  int y;

}

interface Fightable extends Movable, Attackable {}
interface Movable { void move (int x, int y);}
interface Attackable {void attack(Unit u);}