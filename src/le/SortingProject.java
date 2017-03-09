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
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        long startTime = System.nanoTime();
        //bubble sort
        bubbleSort(arr);
        System.out.println("Time for Bubble Sort:    "
                + (System.nanoTime() - startTime));
        System.out.println("Bubble Sort:    " + Arrays.toString(arr));
        //insection sort
        System.out.println("");
        insectionSort(arr);
        System.out.println("Time for Insection Sort: "
                + (System.nanoTime() - startTime));
        System.out.println("Insection Sort: " + Arrays.toString(arr));
        //selection sort
        System.out.println("");
        selectionSort(arr);
        System.out.println("Time for Selection Sort: "
                + (System.nanoTime() - startTime));
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        //merge sort
        System.out.println("");
        mergeSort(arr);
        System.out.println("Time for Merge Sort: "
                + (System.nanoTime() - startTime));
        System.out.println("Merge Sort:     " + Arrays.toString(arr));
        //counting sort
        System.out.println("");
        countingSort(arr, 0, 99);
        System.out.println("Time for Counting Sort: "
                + (System.nanoTime() - startTime));
        System.out.println("Counting Sort:  " + Arrays.toString(arr));
    }

    /**
     * This is a insection sort, that has time complexity of O(n^2) and space
     * complexity of O(1) with the average finish time: 6477401 nano-second
     *
     * @param arr the array to be sorted
     */
    public static void insectionSort(int[] arr) {
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            while (pos > 0 && arr[pos - 1] > arr[pos]) {
                swap(arr, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }

    /**
     * This is a insection sort, that has time complexity of O(n^2) and space
     * complexity of O(1) with the average finish time: 5395589 nano-second
     *
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * This is a insection sort, that has time complexity of O(n^2) and space
     * complexity of O(1) with the average finish time: 9993852 nano-second
     *
     * @param arr the array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        while (max > min) {
            for (int i = min; i < max; i++) {
                if (arr[i] < arr[min]) {
                    swap(arr, i, min);
                }
                if (arr[i] > arr[max]) {
                    swap(arr, i, max);
                }
            }
            min = min + 1;
            max = max - 1;
        }
    }

    /**
     * This is a merge sort, that has time complexity of O(n log n) and space
     * complexity of O(n) with the average finish time: 11006066 nano-second
     *
     * @param arr the array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr.length - 1 > 0) {
            int[] arrLeft = new int[arr.length / 2];
            System.arraycopy(arr, 0, arrLeft, 0, arr.length / 2);
            int[] arrRight = new int[arr.length - arrLeft.length];
            System.arraycopy(arr, arr.length / 2, arrRight, 0, arrRight.length);
            mergeSort(arrLeft);
            mergeSort(arrRight);
            merge(arr, arrLeft, arrRight);
        }
    }

    /**
     * merging method for the merge sort
     *
     * @param arr the main array to be sorted
     * @param arrLeft the array from the left
     * @param arrRight the array from the right
     */
    public static void merge(int[] arr, int[] arrLeft, int[] arrRight) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if (j > arrRight.length - 1 || (i <= arrLeft.length - 1
                    && arrLeft[i] <= arrRight[j])) {
                arr[k] = arrLeft[i];
                i++;
            } else {
                arr[k] = arrRight[j];
                j++;
            }
        }
    }

    /**
     * This is a counting sort, that has time complexity of O(n + k) and space
     * complexity of O(k) with the average finish time: 12981103 nano-second
     *
     * @param arr the array to be sorted
     * @param max the max of the array
     * @param min the min of the array
     */
    public static void countingSort(int[] arr, int min, int max) {
        int[] temp = new int[max - min + 2];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i <= max - min + 1; i++) {
            for (int j = 0; j < temp[i]; j++) {
                arr[index] = i + min;
                index++;
            }
        }
    }

    /**
     * the swapping method for all sorting method
     *
     * @param arr the array to be sorted
     * @param i the first index
     * @param j the second index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
