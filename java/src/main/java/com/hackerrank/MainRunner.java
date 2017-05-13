package com.hackerrank;

import java.util.PriorityQueue;

public class MainRunner {

    public static double addNumber(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers,Integer value){

        if(lowers.size() == 0 || value < lowers.peek()){
            lowers.add(value);
        } else {
            uppers.add(value);
        }

        rebalance(lowers,uppers);

        return getMedian(lowers,uppers);
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers){

        PriorityQueue<Integer> bigger = lowers.size() > uppers.size() ? lowers : uppers;
        PriorityQueue<Integer> smaller = lowers.size() > uppers.size() ? uppers : lowers;

        if(bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers){

        PriorityQueue<Integer> bigger = lowers.size() > uppers.size() ? lowers : uppers;
        PriorityQueue<Integer> smaller = lowers.size() > uppers.size() ? uppers : lowers;

        if(bigger.size() - smaller.size() == 0){ // even
            return ((double)bigger.peek() + (double)smaller.peek())/2.0;
        } else { // odd
            return bigger.peek();
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>((a, b) -> +1 * a.compareTo(b));
        PriorityQueue<Integer> uppers = new PriorityQueue<Integer>((a, b) -> -1 * a.compareTo(b));

        System.out.println(addNumber(lowers,uppers,12));
        System.out.println(addNumber(lowers,uppers,4));
        System.out.println(addNumber(lowers,uppers,5));
        System.out.println(addNumber(lowers,uppers,3));
        System.out.println(addNumber(lowers,uppers,8));
        System.out.println(addNumber(lowers,uppers,7));
    }
}
