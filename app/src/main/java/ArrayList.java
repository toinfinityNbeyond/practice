

public class ArrayList {
  static final int MAX_LENGTH = 100;
  static Object[] List = new Object[MAX_LENGTH];
  static int size = 0;

  static void append(Object obj) {
    List[size++] = obj;
  } 

  static Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < size; i++) {
      arr[i] = List[i];
    }
    return arr;
  } 
  static Object retrieve(int index) {
    return List[index];
  }

  static void remove (int index) {
    for (int i = index; i < size - 1; i++) {
      List[i] = List[i + 1];
    }
    size--;
  }

}
