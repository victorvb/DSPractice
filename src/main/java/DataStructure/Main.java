package DataStructure;


import DataStructure.LinkedList.SingluarLinkedList;

public class Main {

    public static void main(String args[]){
        SingluarLinkedList tmpList = SingluarLinkedList.generateLinkedList(20);
        tmpList.delete(3);
        tmpList.printList();
    }
}
