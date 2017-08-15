/*
 problem : Given two lists, find the intersection point of two lists. return null if doesn't exists
 */
 import java.util.*;

 public class ListIntersection {

   private static Node findIntersectionNode(Node a, Node b){
     if(a == null || b == null) return null;

     int sizeA = size(a);
     int sizeB = size(b);
     int diff = Math.abs(sizeA - sizeB);

     Node longerList = null;
     Node shorterList = null;

     if(sizeA > sizeB) {
       longerList = a;
       shorterList = b;
     } else {
       longerList = b;
       shorterList = a;
     }

     while(diff-- > 0){
       longerList = longerList.next;
     }

     while(longerList != null) {
       if(longerList == shorterList){
         return longerList;
       }
       longerList = longerList.next;
       shorterList = shorterList.next;
     }
     return null;
   }

   private static int size(Node node){
     int size = 0;
     while(node != null){
       size++;
       node = node.next;
     }
     return size;
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
     private Node(int data){
       this.data = data;
     }
   }

   public static void main(String[] args) {
     Node a = new Node(1);
     a.next = new Node(2);
     a.next.next = new Node(3);
     a.next.next.next = new Node(4);
     a.next.next.next.next = new Node(5);
     print(a);

     Node b = a;
     //b.next = new Node(20);
     //b.next.next= a.next.next.next;
     print(b);
     Node intersection = findIntersectionNode(a, b);
     print(intersection);

   }
 }
