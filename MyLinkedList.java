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

  public String toStringReversed() {
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

  public String remove(int index) {
    if (index == 0) {
      if (size == 1) {
        size = 0;
        String oldStart = start.getValue();
        start = null;
        end = null;
        return oldStart;
      }

      String oldStart = start.getValue();
      start = start.getNext();
      start.setPrev(null);
      size--;
      return oldStart;
    }

    if (index == size - 1) {
      String oldEnd = end.getValue();
      end = end.getPrev();
      end.setNext(null);
      size--;
      return oldEnd;
    }

    Node n = getNode(index);
    Node next = n.getNext();
    Node prev = n.getPrev();
    next.setPrev(prev);
    prev.setNext(next);
    size--;
    return n.getValue();
  }

  public void extend(MyLinkedList other) {
    if (this.size() == 0) {
      this.start = other.start;
      this.end = other.end;
      this.size = other.size();
    } else if (other.size() != 0) {
      this.end.setNext(other.start);
      other.start.setPrev(this.end);
      this.end = other.end;
      this.size += other.size();
    }

    other.start = null;
    other.end = null;
    other.size = 0;
  }
}
