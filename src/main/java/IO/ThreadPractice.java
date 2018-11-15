package IO;


public class ThreadPractice implements Runnable{

    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
