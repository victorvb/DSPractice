
import DataStructure.LinkedList.CircularLinkedList;
import DataStructure.LinkedList.SingluarLinkedList;
import IO.NumbersConsumer;
import IO.NumbersProducer;
import IO.ThreadPractice;

import java.util.concurrent.*;


public class Main {
    public static void main(String args[]){

        int [] tmp1 = {1,2,3,4,5,6,7,8,9,10};
        int [] tmp2 = new int[10];



    }

    public static void singlarLinkedListTest(){
        SingluarLinkedList tmpList = SingluarLinkedList.generateLinkedList(20);
        tmpList.delete(3);
        tmpList.printList();
    }

    public static void circularLinkedListTest(){
        CircularLinkedList tmpList = new CircularLinkedList(10);
        tmpList.add(9);
        tmpList.add(8);
        tmpList.add(7);
        tmpList.add(6);
        tmpList.add(5);
        tmpList.printList();
        tmpList.deleteFirst();
        tmpList.deleteFirst();
        tmpList.deleteFirst();
        tmpList.deleteFirst();
        tmpList.printList();
    }

    public static void iOTest(){
        int BOUND = 10;
        int N_PRODUCERS = 4;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();


    }

    public static void threadPracticeTest(){
        for(int i = 0; i < 4; i++){
            String tmpName = Thread.currentThread().getName();
            System.out.println(tmpName);
            new Thread(new ThreadPractice()).start();
        }
    }

    public static void runnableTest(){
        Runnable hellos = () ->{
            for(int i = 1; i <= 1000; i++)
                System.out.println(Thread.currentThread().getName() + " Hello " + i);
        };

        Runnable goodbyes = () ->{
            for(int i = 1; i <= 1000; i++)
                System.out.println(Thread.currentThread().getName() + " Goodbye " + i);
        };

        Executor executor = Executors.newCachedThreadPool();
        System.out.println(Thread.currentThread().getName());
        executor.execute(hellos);
        executor.execute(goodbyes);
    }

}
