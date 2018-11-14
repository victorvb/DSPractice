package DataStructure.Sorting;

import java.util.Arrays;

public class Sort {

    public void bubbleSort(int [] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public void selectionSort(int[] array){
        int minPos;
        int tmp;
        for(int i=0; i<array.length; i++){
            minPos = this.findMinPos(Arrays.copyOfRange(array, i, array.length)) + i;
            // swap
            tmp = array[i];
            array[i] = array[minPos];
            array[minPos] = tmp;
        }
    }

    public void insertionSort(int[] arr){
        int tmp = arr[0];
        for(int i=1; i<arr.length; i++){
            int min = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j]>min){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = min;
        }
    }

    public void mergeSort(int[] array){
        int n = array.length;
        if(n < 2) return;
        // divide
        int mid = n/2;
        int[] array1 = Arrays.copyOfRange(array, 0, mid);
        int[] array2 = Arrays.copyOfRange(array, mid, n);

        // conquer
        mergeSort(array1);
        mergeSort(array2);

        // merge
        merge(array, array1, array2);
    }

    public void merge(int[] array, int[] array1, int[] array2){

        int i = 0, j = 0, n = array.length;
        while(i + j < n){
            if(j == array2.length || (i < array1.length && array1[i] < array2[j])){
                array[i+j] = array1[i++];
            }else{
                array[i+j] = array2[j++];
            }
        }
    }

    public void quickSort(int[] array, int a, int b){
        if(b-a < 2)
            return;
        int left = a;
        int right = b-2;
        int pivot = b-1;
        int temp;
        // conquer
        while(left <= right){

            while(left <= right && array[left] <= array[pivot]){
                System.out.println(left);
                left++;
            }
            while(left <= right && array[right] > array[pivot]){
                System.out.println(right);
                right--;
            }

            // swap
            if(left <= right){
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        temp = array[left];
        array[left] = array[pivot];
        array[pivot] = temp;
        // divide
        quickSort(array, 0,left-1);
        quickSort(array, left+1,b);
    }

    private int findMinPos(int[] array){
        if(array == null){
            return -9999;
        }

        if(array.length == 0){
            return -9999;
        }

        int minPos = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] < array[minPos]){
                minPos = i;
            }
        }
        return minPos;
    }

    public void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
            if(i < array.length-1) {
                System.out.print("=>");
            }else{
                System.out.println();
            }
        }
    }

    public void rotateArrayLeft(int[] arr){
        int tmp = arr[0];
        int i;
        for(i=0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[i] = tmp;
    }

    public void rotateArrayRight(int[] arr){
        int i;
        int tmp = arr[arr.length-1];
        for(i=arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[i] = tmp;
    }

    public static void main(String[] args){
        int[] testSet = {5,1,8,2,7,3,7,3};
        Sort test = new Sort();

        test.quickSort(testSet, 0, testSet.length);
        test.printArray(testSet);
    }
}
