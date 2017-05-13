package com.hackerrank.crackingTheCode;

/**
 * Created by joshuawilkosz on 7/5/17.
 */
public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public MyQueue() {
    }

    public void enqueue(T value) {

        Node node = new Node<>(value);

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (isEmpty()) {
            head = tail;
        }
    }

    public T dequeue() {
        T value = head.value;

        head = head.next;
        if (isEmpty()) {
            tail = null;
        }

        return value;
    }

    public T peek() {
        return head.value;
    }

    public Boolean isEmpty() {
        return head == null;
    }
}