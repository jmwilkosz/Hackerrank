package com.hackerrank.crackingTheCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mupp3t on 26/03/2017.
 */
public class Contacts {

    public static class Node {

        private static int NUMBER_CHILDREN = 26;
        private Node[] children = new Node[NUMBER_CHILDREN];
        private int size = 0;

        public Node(){

        }

        private static int GetCharAtIndex(char c){
            return c - 'a';
        }

        private Node GetNode(char c){
            return children[GetCharAtIndex(c)];
        }

        private void SetNode(char c, Node node){
            children[GetCharAtIndex(c)] = node;
        }

        private int FindCount(String s, int index){
            if(s.length() == index){
                return size;
            }

            Node child = GetNode(s.charAt(index));

            if(child == null) {
                return 0;
            }

            return child.FindCount(s, index + 1);
        }

        private void Add(String s){
            this.Add(s,0);
        }

        private void Add(String s, int index){
            size++;

            if(s.length() == index){
                return;
            }

            char current = s.charAt(index);

            Node child = GetNode(current);

            if(child == null){
                child = new Node();
                SetNode(current,child);
            }

            child.Add(s, index + 1);
        }
    }


    public static void main(String[] args){

        Node node = new Node();

        node.Add("heelo");
        node.Add("hello");

        System.out.println(node.FindCount("hel",0));


    }

}
