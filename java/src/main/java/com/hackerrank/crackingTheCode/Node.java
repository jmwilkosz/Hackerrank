package com.hackerrank.crackingTheCode;

/**
 * Created by joshuawilkosz on 7/5/17.
 */
public class Node<T> {

    public Node next;
    public T value;

    public Node(T value){
        this.value = value;
    }

    public Node(){}
}