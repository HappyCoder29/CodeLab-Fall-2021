package edu.northeastern.ashish;

public class PrintThread implements  Runnable{
    public String name = "";
    @Override
    public void run() {
        for(int i = 0 ; i < 10; i ++){
            System.out.println(Thread.currentThread().getName() + " Name = " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
