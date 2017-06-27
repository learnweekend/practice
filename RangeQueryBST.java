/*
Problem : RangeQuery in Binary Search Tree (BST)
“In a Binary Search Tree (BST) find the number of elements in a given range.
e.g:
input: range: (2,6) - including
	tree:
		5
	3		7
1
output: 2”
*/
public class RangeQueryBST {
  public static void main(String[] args) {
    /*Node tree = new Node(5);
    tree.left = new Node(3);
    tree.left.left = new Node(1);
    tree.right = new Node(7);
    int startRange = 2;
    int endRange = 19; */

    Node tree = new Node(20);
    tree.left = new Node(8);
    tree.left.left = new Node(4);
    tree.left.right = new Node(12);
    tree.right = new Node(22);
    int startRange = 12;
    int endRange = 22;

    int elementsInGivenRange = getNumberOfElementsInGivenRange(tree, startRange, endRange);
    System.out.println("Number of elements in given range = " + elementsInGivenRange);
    printElementsInGivenRange(tree, startRange, endRange);
    System.out.println();
  }
  /* Solution : This is recurisve solution and counts the number of elements in a given range.
      Runtime : O(elements in range); Space O(1)
  */
  private static int getNumberOfElementsInGivenRange(Node bstree, int startRange, int endRange) {
    if(bstree == null)
      return 0;
    if(bstree.data >= startRange && bstree.data <= endRange) {
      System.out.println(bstree.data);
      return 1 + getNumberOfElementsInGivenRange(bstree.left, startRange, endRange) +
                 getNumberOfElementsInGivenRange(bstree.right, startRange, endRange);
    } else if(bstree.data > endRange) {  // left subtree
      return getNumberOfElementsInGivenRange(bstree.left, startRange, endRange);
    } else {  // right subtree
      return getNumberOfElementsInGivenRange(bstree.right, startRange, endRange);
    }
  }
  /* Solution :  This is recurisve solution, prints the elements in the given range in sorted order.
      1. traverse the left subtree
      2. print (count) the element if node.data is in given range.
      3. The traverse the right subtree
      Note : The range elements will be printed in sorted order
      Runtime : O(elements in range); Space O(1)
  */
  private static void printElementsInGivenRange(Node tree, int start, int end){
    if(tree == null)
      return;

    if(start < tree.data) // traverse the left subtree
      printElementsInGivenRange(tree.left, start, end);

    if(tree.data >= start && tree.data <= end)
      System.out.print(tree.data + " ");

    if(end > tree.data) // traverse the right sub tree
      printElementsInGivenRange(tree.right, start, end);
  }

  private static class Node {
    private int data;
    private Node left;
    private Node right;

    private Node(int val){
      this.data = val;
    }
  }
}
