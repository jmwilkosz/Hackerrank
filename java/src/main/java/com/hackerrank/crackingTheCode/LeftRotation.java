package com.hackerrank.crackingTheCode;


/**
 * Created by mupp3t on 26/03/2017.
 */
public class LeftRotation {

    public static void main(String[] args) {
        int k = 7;
        int a[] = {98,67,35,1,74,79,7,26,54,63,24,17,32,81};

        a = LeftShiftArray(a,k);

        for(int i=0; i< a.length; i++){
            System.out.printf("%d ",a[i]);
        }

        // 26 54 63 24 17 32 81 98 67 35 1 74 79 7

        System.out.println();
    }

    private static int[] LeftShiftArray(int[] a, int k){
        int[] b = new int[a.length];
        int shiftBy = k % a.length;// 1 <= shiftBy <= a.length;

        for(int i = 0; i < b.length; i++){
            b[i] = a[( i + shiftBy ) % b.length];
        }

        return b;
    }
}
