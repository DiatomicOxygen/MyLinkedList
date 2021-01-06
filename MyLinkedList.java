public class MyLinkedList {

  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    if (size == 0) {
      Node n = new Node(value);
      start = n;
      end = n;
      size++;
      return true;
    } else {
      Node n = new Node(value);
      n.setPrev(end);
      end.setNext(n);
      end = n;
      size++;
      return true;
    }
  }

  public void add(int index, String value) {
    if (index == size){
      add(value);
    } else {
      int currentIndex = 0;
      Node currentNode = start;
      while (currentIndex < index) {
        currentIndex ++;
        currentNode = currentNode.getNext();
      }
      Node n = new Node(value);
      n.setPrev(currentNode.getPrev());
      n.setNext(currentNode);
      currentNode.setPrev(n);
      if (index > 0) {
        n.getPrev().setNext(n);
      }
      if (index == 0) {
        start = n;
      }
      size++;
    }
  }

  public String toString() {
    String ans = "[";
    Node currentNode = start;
    for (int i = 0; i < size; i++) {
      ans += currentNode.getData();
      if (i != size - 1) {
        ans += ", ";
      }
      currentNode = currentNode.getNext();
    }
    ans += "]";
    return ans;
  }
}
