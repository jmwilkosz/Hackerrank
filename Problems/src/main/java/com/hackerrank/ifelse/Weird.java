package com.hackerrank.ifelse;

import java.util.Scanner;

/**
 * Created by mupp3t on 15/02/2017.
 */
public class Weird {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{
            if(n < 2)
            {

            }
            else if ( n >= 2  && n <= 5)
            {
                System.out.println("Not Weird");
            }
            else if (n <= 20)
            {
                System.out.println("Weird");
            }
            else
            {
                System.out.println("Not Weird");
            }
        }
        System.out.println(ans);
    }
}
