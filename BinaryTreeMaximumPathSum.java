package com.java.ninja;

/*
 Problem :
 Given a binary tree find the maximum sum that exist in a path of a tree.
 A path can start from any node and end at any node.
e.g:
input:
 tree:
   5
 3		1
-10
output: 9
 */
public class BinaryTreeMaximumPathSum {

    /*  Solution 1 :
        1. Node only
        2. Max path through Left Child + Node
        3. Max path through Right Child + Node
        4. Max path through Left Child + Node + Max path through Right Child
     */
    public static int getMaxPathSum(Node root){
        int[] max = new  int[1];
        max[0] = Integer.MIN_VALUE;
        getMaxPathSum(root, max);
        return max[0];
    }

    private static int getMaxPathSum(Node root, int[] max){
        if(root == null) return 0;

        int left = getMaxPathSum(root.left, max); // left child max

        int right = getMaxPathSum(root.right, max); //right child max

        int maxWithCurrNode = max(root.data, root.data + left, root.data + right); // including currNode

        max[0] = max(max[0], maxWithCurrNode, root.data + left + right); // include currNode + left + right

        return maxWithCurrNode;
    }

    private static int max(int... vals){
        int max = Integer.MIN_VALUE;
        for(int i : vals){
            if(i > max)
                max = i;
        }
        return max;
    }

    // solution 2
    public static int maxPathSum(Node root) {
        // pass in an Object that will be filled in the two values
        Data data = maxSubPath(root);
        return data.sum;
    }

    private static class Data {
        int path = 0;
        int sum = Integer.MIN_VALUE;
    }

    private static Data maxSubPath(Node root) {
        Data data = new Data();
        if (root == null) return data;

        Data left = maxSubPath(root.left);
        Data right = maxSubPath(root.right);

        data.path = Math.max(0, Math.max(left.path, right.path) + root.data);
        data.sum = Math.max(Math.max(left.sum, right.sum), left.path + root.data + right.path);
        return data;
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(1);
        root.left.left = new Node(-10);

        System.out.println("max path sum  = " + getMaxPathSum(root));
        System.out.println("max path sum  = " + maxPathSum(root));
    }
}
