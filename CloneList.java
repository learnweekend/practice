/**
 https://leetcode.com/problems/copy-list-with-random-pointer/description/
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
	Return a deep copy of the list.
 */
 import java.util.*;

 public class CloneList {
	 /**
	  * Recursive Solution
	  */
	 public static Node cloneListRecursive(Node head){
		 if(head == null) 
			 return null;
		 Map<Node, Node> map = new HashMap<>();
		 return cloneListRecursive(head, map);
	 }
	 
	 private static Node cloneListRecursive(Node node, Map<Node, Node> map){
		 if(node == null)
			 return null;
		 if(map.get(node) != null)  // base case, return the value if node is present in the map
			 return map.get(node);
		 map.put(node, new Node(node.data));  // if not, create a new node and put in map
		 map.get(node).next = cloneListRecursive(node.next, map);  // recursive call for next
		 map.get(node).random = cloneListRecursive(node.random, map); // recursive call for random
		 return map.get(node); // return the head to cloned list
	 }
	 
	 /**Solution 1 : 
	  * 1. Traverse the original list and store the mapping of old node and newly created nodes in Map.
	  * 2. Traverse the orignal list or Map and get the next and random nodes from map and update the references for newly created nodes
	  * 3. Runtime : O(N), Space : O(N);
	  */
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
   /**
    * solution 2: without using the additional space
    * 1. Traverse the original list and create a new nodes and append to the original node (list)
    * 2. Traverse the original list and assign the random pointers.
    * 3. separate the cloned list from original list.
    * 
    * space : O(1), runtime : O(N)
    */
   public static Node cloneList(Node head){
   	  if (head == null)
           return null;
       
       // pass 1  --> created new node and append to the original list(node)
       Node node = head;
       while (node != null) {
           Node clonedNode = new Node(node.data); 
           clonedNode.next =  node.next;
           node.next = clonedNode;
           node = node.next.next;
       }
       
    
       // pass 2  --> copy the random nodes
       node = head;
       print(node);
       while (node != null) {
           Node randomNode = node.random;
           if (randomNode != null)
               node.next.random = randomNode.next;
           node = node.next.next;
       }
       
       // pass 3   --> seperate the cloned list from original list
       node = head;
       print(node);
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
   }

   private static void print(Node x){
     Node list = x;
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

     /*Node result = cloneListUsingMap(head);
     print(head);
     print(result);*/
    // Node result2 = cloneListRecursive(head);
     //print(result2);
     Node result3 = cloneList(head);
     print(result3);
   }
 }
