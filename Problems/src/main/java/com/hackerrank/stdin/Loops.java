package com.hackerrank.stdin;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Created by mupp3t on 15/02/2017.
 */
public class Loops {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.close();

        if(n == null)
            return;

        for(int i = 1; i <= 10; i++)
        {
            System.out.format("%d x %d = %d%n",n,i,n*i);
        }
    }
}
