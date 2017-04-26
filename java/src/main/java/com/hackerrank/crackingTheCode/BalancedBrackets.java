package com.hackerrank.crackingTheCode;

/**
 * Created by mupp3t on 26/03/2017.
 */
public class BalancedBrackets {

    public static class Stack {

        private static final int SIZE = 100;
        private static final int REALLOCATION_FACTOR = 10;
        private int nextIndex = 0;
        private int[] stack;

        public Stack(){
            stack = new int[SIZE];
        }

        public Stack(int i){
            stack = new int[i];
        }

        public void Push(int i){

            if(nextIndex == stack.length){
                ReallocateStack();
            }

            stack[nextIndex++] = i; // increment stackIndex after added the character
        }

        public int Pull(){

            int i;

            if(nextIndex == 0) {
                return -1;
            } else {
                i = stack[--nextIndex]; // decrement nextIndex and assign value
            }

            stack[nextIndex] = -1; // set nextIndex value to null

            return i;
        }

        public int Size(){
            return  nextIndex;
        }

        private void ReallocateStack(){

            int[] newStack = new int[stack.length * REALLOCATION_FACTOR];

            for(int i = 0; i < stack.length; i++){
                newStack[i] = stack[i];
            }

            stack = newStack;
        }
    }

    public static void main(String[] args){

        Stack stack = new Stack(3);

        String word = "{{[[(())]]}}";

//        {[()]}
//        {[(])}
//        {{[[(())]]}}

        for(int i = 0; i < word.length(); i++) {

            int c = word.charAt(i);

            if(c == 123 || c == 91 || c == 40){ // if part of the left, push to stack
                stack.Push(c);
            } else if (c == 125) {
                if(123 != stack.Pull()){ // {}
                    System.out.print("False");
                    return;
                }
            } else if (c == 93) {
                if(91 != stack.Pull()){ // []
                    System.out.print("False");
                    return;
                }
            } else if (c ==41) {
                if(40 != stack.Pull()){ // {}
                    System.out.print("False");
                    return;
                }
            }
        }

        System.out.print(stack.Size() == 0 ? "true" : "false");
    }
}
