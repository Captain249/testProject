package com.test.javaBasis.threadDemos;

public class BumThread extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000*3);
            System.out.println("包子准备完毕");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
