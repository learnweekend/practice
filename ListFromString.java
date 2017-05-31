/**
  Problem :
  a) Create a function that creates a linked list out of a string
            where each node contains a single letter.
            Input  : "cat"
            Output :  c->a->t
  b) Also create a string representation of such a list for debugging purposes.
            Input :  c->a->t
            output : cat
*/
public class ListFromString {
    private static Node head = null;
    private static Node tail = null;

    public static void main(String[] args) {
    String str = "cat";
    Node list = listFromString(str);
    System.out.print("List Representaion = ");
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println();
    String result = debugStringFromList(head);
    System.out.println("String Representation = " +result);
  }
/**
Conversion from String to list representation
*/
 private static Node listFromString(String str) {
    for(int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if(head == null) {
        head = new Node(ch);
        tail = head;
      } else {
        tail.add(ch);
      }
    }
    return head;
  }
/**
  Conversion from List to String representation
  */
  private static String debugStringFromList(Node head) {
    Node curr = head;
    StringBuilder sb = new StringBuilder();
    while(curr != null) {
      sb.append(curr.data);
      curr = curr.next;
    }
    return sb.toString();
  }
  /**
    Node class along with "add" method
  */
  private static class Node {
    private char data;
    private Node next;

    private Node(char c) {
      this.data = c;
    }
    private static void add(char ch) {
      Node newNode = new Node(ch);
      tail.next = newNode;
      tail = newNode;
    }
  }
}
