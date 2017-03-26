package com.hackerrank.crackingTheCode;

import java.util.Scanner;

/**
 * Created by mupp3t on 26/03/2017.
 */
public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        for(int i=0; i < k; i++){
            LeftShiftArray(a);
        }

        for(int i=0; i< a.length; i++){
            System.out.printf("%d ",a[i]);
        }
    }

    private static void LeftShiftArray(int[] a){
        int tmp = a[0];

        for(int i = 0; i < a.length-1; i++){
            a[i] = a[i+1];
        }

        a[a.length-1] = tmp;
    }
}
