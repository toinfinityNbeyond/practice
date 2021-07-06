

public class ArrayList {
  static final int MAX_LENGTH = 100;
  Object[] List = new Object[MAX_LENGTH];
  int size = 0;

  void append(Object obj) {
    this.List[this.size++] = obj;
  } 

  Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.List[i];
    }
    return arr;
  } 
  Object retrieve(int index) {
    return this.List[index];
  }

  void remove (int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.List[i] = this.List[i + 1];
    }
    this.size--;
  }

}
