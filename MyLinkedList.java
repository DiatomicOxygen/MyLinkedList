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

  private Node getNode(int index) {
    Node currentNode;
    if (size - index - 1 > index) {
      currentNode = start;
      for (int i = 0; i < index; i++) {
        currentNode = currentNode.getNext();
      }
    } else {
      currentNode = end;
      for (int i = 0; i < size - index - 1; i++) {
        currentNode = currentNode.getPrev();
      }
    }
    return currentNode;
  }

  public void add(int index, String value) {
    if (index == size){
      add(value);
    } else {
      Node currentNode = getNode(index);
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

  public String get(int index) {
    Node currentNode = getNode(index);
    return currentNode.getValue();
  }

  public String set(int index, String value) {
    Node currentNode = getNode(index);
    String ans = currentNode.getValue();
    currentNode.setValue(value);
    return ans;
  }

  public String toString() {
    String ans = "[";
    Node currentNode = start;
    for (int i = 0; i < size; i++) {
      ans += currentNode.getValue();
      if (i != size - 1) {
        ans += ", ";
      }
      currentNode = currentNode.getNext();
    }
    ans += "]";
    return ans;
  }
/*
  public String reverseToString() {
    String ans = "[";
    Node currentNode = end;
    for (int i = 0; i < size; i++) {
      ans += currentNode.getValue();
      if (i != size - 1) {
        ans += ", ";
      }
      currentNode = currentNode.getPrev();
    }
    ans += "]";
    return ans;
  }
*/
}
