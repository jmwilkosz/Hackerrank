package com.hackerrank.crackingTheCode;
import java.util.Arrays;

/**
 * Created by joshuawilkosz on 8/5/17.
 */
public class HeapMin {

    public int[] heap;
    public int size;

    public HeapMin(int size) {
        this.heap = new int[size];
    }

    public boolean isFull() {
        return size - 1 == heap.length;
    }

    public void add(int obj) {
        addExtraCapacity();
        heap[size++] = obj;
        heapifyUp();
    }

    public int peek() {
        return heap[0];
    }

    public int pull() {
        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    public void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap[index] > heap[smallerChildIndex]) {
                swap(index, smallerChildIndex);
            } else {
                break;
            }
            index = smallerChildIndex;
        }
    }


    //    0       1             2*parent +1
    //    1     2   4    2
    //    3   3  4 4  4  6

    private int getLeftChildIndex(int parentIndex){return 2 * parentIndex +1;}
    private int getRightChildIndex(int parentIndex){return 2 * parentIndex +2;}
    private int getParentIndex(int childIndex){return (int)Math.floor((childIndex-1)/2);}

    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) > size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index) > size;}
    private boolean hasParent(int index){ return getParentIndex(index) >= 0;}

    private int leftChild(int index){return heap[getLeftChildIndex(index)];}
    private int rightChild(int index){return heap[getRightChildIndex(index)];}
    private int parent(int index){return heap[getParentIndex(index)];}

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    private void addExtraCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    public void printHeap(){

        StringBuilder stringHeap = new StringBuilder();
        stringHeap.append("{");
        for(int i=0 ; i<size; i++){
            stringHeap.append(heap[i]);
            if(i+1<size){
                stringHeap.append(",");
            }
        }
        stringHeap.append("}");
        System.out.println(stringHeap.toString());
    }
}
