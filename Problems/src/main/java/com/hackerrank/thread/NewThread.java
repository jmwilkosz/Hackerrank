package com.hackerrank.thread;

/**
 * Created by mupp3t on 18/03/2017.
 */
public class NewThread implements Runnable {

    public Thread t;

    public NewThread(){
        t = new Thread(this,"Demo Thread");
        System.out.println("Child thread: " + t);
        t.start();
    }

    @interface MyAnno{
        String str();
        int val();
    }
    
    public void run(){
        try
        {
            for(int i=5; i > 0 ; i--)
            {
                System.out.println("child thread: " + i);
                //Thread.sleep(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Child interrupted");
        }
        System.out.println("Exiting child thread");
    }
}
