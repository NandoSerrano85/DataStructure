/********************************************************************** 
    Purpose/Description: Sort an array of integers using Radix Sort 
						 Algorithm. Storage and process the bucket lists,
						 use an ArrayList structure.
    
    Author: Fernando Serrano
          
    Certification:  I hereby certify that this work is my own and 
                    none of it is the work of any other person.  
*********************************************************************/ 
import java.util.*;
/**
 *
 * @author Fernando Serrano
 */
public class RadixSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("radixsort");
        int[] arr = {18, 5, 100, 3, 1, 19, 6, 12, 7, 4, 2};
        radixSort(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i - 1] > arr[i]) {
                System.out.println("radixsort method fails.");
            }
        }
        
        
    }
    
    public static void radixSort(int arr[]){
        final int RADIX = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
 
        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        
        while (!maxLength) {
            maxLength = true;
        
            // split input between lists
            for (Integer i : arr) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    arr[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }
}
