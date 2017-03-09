package le;

import java.util.Arrays;
import static java.util.Collections.swap;
import java.util.Random;

/**
 *
 * @author Phuc Hong Le
 */
public class SortingProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        long startTime = System.nanoTime();  
        bubbleSort(arr);
        System.out.println("Time for Bubble Sort:    " 
                + (System.nanoTime() - startTime));
        System.out.println("Bubble Sort:    " + Arrays.toString(arr));
        System.out.println("");
        insectionSort(arr);
        System.out.println("Time for Insection Sort: " 
                + (System.nanoTime() - startTime));
        System.out.println("Insection Sort: " + Arrays.toString(arr));
    }
    
    //insection sort
    public static void insectionSort(int[] arr){
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            while(pos > 0 && arr[pos - 1] > arr[pos]){
                swap(arr, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }
    
    //bubble sort
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j , j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    
    //swapping method for the sort method
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
