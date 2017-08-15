 /*
  problem : Reverse list K groups
  */
  public class ReverseListKGroups {
    public static void main(String[] args){
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.next = new Node(7);
    print(head);
    int k = 4;
    //Node reversed = reverseKGroupsV1(head, k);
    Node reversed2 = reverseKGroup(head, k);
    print(reversed2);
  }

  private static Node reverseKGroupsV1(Node head, int k){
    if(head == null || k == 0) return head;
    int size = size(head);  //size
    if(k > size) return head;
    int lastNodes =  size % k; // to cut the list at the remaining list
    Node back = head;
    Node front = head;

    for(int i = 0; i <= lastNodes; i++) { // note : move to end of group k
      front = front.next;
    }
    while(front != null) {
      front = front.next; //move forward the front pointer
      back = back.next; // move the back pointer forward
    }
    Node next = back.next;
    back.next = null;
    return reverseK(head, k, next);
  }

  private static Node reverseK(Node node, int k,  Node back){
    if(node == null) return null;
    Node curr = node;
    Node prev = null;
    Node next = null;
    int count = 0;

    while(curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
     if(next != null){
       node.next = reverseK(next, k, back);
     }

    if(next == null) { // last nodes
      node.next = back;
    }
     return prev;
  }

  /**
   * Reverse a link list between begin and end exclusively
   * an example:
   * a linked list:
   * 0->1->2->3->4->5->6
   * |           |
   * begin       end
   * after call begin = reverse(begin, end)
   *
   * 0->3->2->1->4->5->6
   *          |  |
   *      begin end
   * @return the reversed list's 'begin' node, which is the precedence of node end
   */
  public static Node reverseKGroup(Node head, int k) {
	    if (head==null || head.next ==null || k==1)
	    	return head;
      Node begin;
	    Node dummyhead = new Node(-1);
	    dummyhead.next = head;
	    begin = dummyhead;
	    int i=0;
	    while (head != null){
	    	i++;
	    	if (i % k == 0){
	    		begin = reverse(begin, head.next);
	    		head = begin.next;
	    	} else {
	    		head = head.next;
	    	}
	    }
	    return dummyhead.next;
	}

	public static Node reverse(Node begin, Node end){
		Node curr = begin.next;
		Node next, first;
		Node prev = begin;
		first = curr;
		while (curr!=end){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}


   private static int size(Node node){
      int count = 0;
      while(node != null){
        count++;
        node = node.next;
      }
      return count;
    }

    private static void print(Node node){
      while(node != null){
        System.out.print(node.data + " ");
        node = node.next;
      }
      System.out.println();
    }

    private static class Node {
      private int data;
      private Node next;
      private Node(int data){
        this.data = data;
      }
    }
  }
