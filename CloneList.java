/*
 problem : Clone linked list with random pointers
 */
 import java.util.*;

 public class CloneList {

   public static Node cloneListUsingMap(Node head){
     if(head == null) return null;
     Map<Node, Node> nodeMap = new HashMap<>();

     Node curr = head;
     while(curr != null){
       nodeMap.put(curr, new Node(curr.data));
       curr = curr.next;
     }

     curr = head;
     while(curr != null){
       nodeMap.get(curr).next = nodeMap.get(curr.next);
       nodeMap.get(curr).random = nodeMap.get(curr.random);
       curr = curr.next;
     }
     return nodeMap.get(head);
   }

   public static Node cloneList(Node head){

     /*     if (head == null)
             return null;

         // pass 1
         Node node = head;
         Node clonedNode = new Node(node.data);
         clonedNode.next = node.next;

         node.next = clonedNode;
         node = node.next.next;
         while (node != null) {
             clonedNode = new Node(node.data);
             clonedNode.next =  node.next;
             node.next = clonedNode;
             node = node.next.next;
         }
         print(head);
         // pass 2
         node = head;
         while (node != null) {
             Node randomNode = node.random;
             if (randomNode != null)
                 node.next.random = randomNode.next;
             node = node.next.next;
         }
         print(head);
         // pass 3
         node = head;
         Node clonedHead = node.next;
         Node clonedTemp = node.next;
         while (node != null) {
             node.next = clonedTemp.next;
             node = node.next;
             if (node != null) {
                 clonedTemp.next = node.next;
                 clonedTemp = clonedTemp.next;
             }
         }
         return clonedHead;
         */

     if(head == null) return null;
     // first pass : create new nodes and insert inbetween nodes.
     Node curr = head;  //  created
     while(curr != null){
       Node currNext = curr.next;
       Node newNode = new Node(curr.data * 10);
       newNode.random = curr.random;
       curr.next = newNode;
       newNode.next = currNext;
       curr = newNode.next;
     }
     print(head);

     //second pass: copy the random pointers.
     curr = head;
     while(curr != null){
       Node randomNode = curr.next;
       if(randomNode != null) {
         curr.next.random = randomNode.next;
       }
       curr = curr.next.next;
     }
     print(head);

     // third pass, remove or cut the original list.
     curr = head;
     Node clonedList = head.next;
     Node clonedTemp = head.next;

     while(curr != null && clonedTemp != null){
       curr.next = clonedTemp.next;
       head = head.next;
       if(head != null){
         clonedTemp.next = head.next;
         clonedTemp = clonedTemp.next;
       }
     }
     print(head);
     return clonedList;
   }

   private static void print(Node list){
     while(list != null){
       System.out.print(list.data + " ");
       list = list.next;
     }
     System.out.println();
   }

   private static class Node {
     private int data;
     private Node next;
     private Node random;
     private Node(int data){
       this.data = data;
     }
   }

   public static void main(String[] args) {
     Node head = new Node(1);
     head.next = new Node(2);
     head.next.next = new Node(3);
     head.next.next.next = new Node(4);
     head.next.next.next.next = new Node(5);

     head.random = head.next.next;  //1, 3
     head.next.random = head.next.next.next; //2, 4
     head.next.next.random = head.next.next.next.next; //3, 5
     head.next.next.next.random = head.next.next; //4, 3
     head.next.next.next.next.random = head; //5, 1

     //Node result = cloneListUsingHash(head);
     Node result = cloneListUsingMap(head);
     print(head);
     print(result);
   }
 }
