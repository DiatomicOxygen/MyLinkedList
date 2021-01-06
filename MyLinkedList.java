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
    int currentIndex = 0;
    Node currentNode = start;
    while (currentIndex < index) {
      currentIndex ++;
      currentNode = currentNode.getNext();
    }
    Node n = new Node(value);
    n.setNext(currentNode.getNext());
    n.setPrev(currentNode);
    currentNode.setNext(n);
    if (size - 1 > index) {
      n.getNext().setPrev(n);
    }
    size++;
  }
}
