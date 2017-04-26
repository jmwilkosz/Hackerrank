package com.hackerrank.stdin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mupp3t on 15/02/2017.
 */
public class Reader {

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try
        {
            do{
                line = reader.readLine();

                System.out.println(line);
            } while(line != null);
        }
        catch(IOException ex)
        {
            System.out.println(ex.fillInStackTrace());
        }
    }
}
