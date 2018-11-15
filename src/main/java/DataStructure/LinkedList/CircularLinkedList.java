package DataStructure.LinkedList;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public CircularLinkedList(int val){
        this.size = 0;
        this.head = new Node(val);
        this.head.next = this.head;
        this.tail = this.head;
        this.size++;
    }

    public void add(int val){
        // adding on tail pointer
        this.tail.next = new Node(val);
        this.tail.next.next = this.head;
        this.tail = this.tail.next;
        size++;
    }

    public void printList(){
        if(this.size == 0){
            return;
        }

        Node tmp = this.head;
        while(tmp != this.tail){
            System.out.print(tmp.val + "=>");
            tmp = tmp.next;
        }
        System.out.print(tmp.val + "\n");
    }

    public void delete(int val){
    }

    public void deleteFirst(){
        if(this.size == 0){
            return;
        }else if(this.size == 1){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }else{
            this.head = this.head.next;
            this.size--;
        }
    }
}
