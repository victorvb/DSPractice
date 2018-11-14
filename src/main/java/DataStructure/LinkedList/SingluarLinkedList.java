package DataStructure.LinkedList;

import java.util.Random;

public class SingluarLinkedList {
    public Node head;
    public Node tail;

    SingluarLinkedList(){
        // dummy node
        this.head = new Node();
        this.tail = this.head;
    }

    SingluarLinkedList(int val){
        this.head = new Node();
        this.head.next = new Node(val);
        this.tail = this.head.next;
    }

    public void append(int val){
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
    }

    public void insertAtStart(int val){
        Node tmp = new Node(val);
        tmp.next = this.head.next;
        this.head.next = tmp;
    }

    public void delete(int val){
        Node tmp = this.head;
        while(tmp.next != null){
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
    }

    public static SingluarLinkedList generateLinkedList(int num){
        SingluarLinkedList tmp = new SingluarLinkedList();
        Random randn = new Random(10);
        for(int i = 0; i < num; i++){
            int randomNumber = randn.nextInt();
            tmp.append(randomNumber%5);
        }
        return tmp;
    }

    public void printList(){
        Node tmp = this.head.next;
        while(tmp != null){
            System.out.print(tmp.val);
            if(tmp.next == null){
                System.out.print("\n");
            }else{
                System.out.print("=>");
            }
            tmp = tmp.next;
        }
    }
}
