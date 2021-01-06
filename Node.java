public class Node {

  private String data;
  private Node next, prev;

  public Node (String value) {
    data = value;
  }

  public void setValue(String value) {
    data = value;
  }

  public void setNext(Node n) {
    next = n;
  }

  public void setPrev(Node n) {
    prev = n;
  }

  public String getValue() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }

}
