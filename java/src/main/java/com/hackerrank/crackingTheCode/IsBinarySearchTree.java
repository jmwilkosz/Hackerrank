package com.hackerrank.crackingTheCode;
/**
 * Created by mupp3t on 26/03/2017.
 */
public class IsBinarySearchTree {

    public static void main(String[] args){

        Node node = new Node(4);
        node.left = new Node(5);
        node.right = new Node(7);
        node.left.left = new Node(2);
        node.left.right = new Node (5);

        Data data = SubNodeInfo(node);

        System.out.println(data.isBalanced);

    }

    public static class Node {

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

        int data;
        Node left;
        Node right;
    }


    public static class Data {

        public Data(int smallest, int largest, boolean isBalanced){
            this.smallest = smallest;
            this.largest = largest;
            this.isBalanced = isBalanced;
        }

        int smallest,largest;
        boolean isBalanced;
    }

    private static Data SubNodeInfo(Node node){

        int smallest = node.data,
                largest = node.data;
        boolean isBalanced = true;


        if(node.left != null){
            Data data = SubNodeInfo(node.left);

            if(isBalanced
                    && data.isBalanced
                    && data.smallest < node.data
                    && data.largest < node.data ){

                if(data.smallest < smallest)
                    smallest = data.smallest;
            } else {
                isBalanced = false;
            }
        }


        if(node.right != null){
            Data data = SubNodeInfo(node.right);

            if(isBalanced
                    && data.isBalanced
                    && data.smallest > node.data
                    && data.largest > node.data){

                if(data.largest > largest)
                    largest = data.largest;
            } else {
                isBalanced = false;
            }
        }

        return new Data(smallest,largest,isBalanced);
    }
}
