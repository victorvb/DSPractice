package DataStructure.ArrayList;

public class CircularArrayList {
    public int [] array;
    public int bound = 5;
    public int size;
    public int head;
    public int tail;

    public CircularArrayList(){
        this.size = 0;
        this.array = new int[this.bound];
    }

    public void add(int val){
        if(this.size == this.bound){
            this.bound = this.bound*2;
            int [] tmp = new int[this.bound];
            System.arraycopy(this.array, 0, tmp, 0, size);
            this.array = tmp;
        }
        this.array[this.size] = val;
        size++;
    }

    public void printList(){
        for(int i = 0; i < size; i++){
            if(i == size-1){
                System.out.print(this.array[i] + "\n");
            }else{
                System.out.print(this.array[i] + "=>");
            }
        }
    }
}
