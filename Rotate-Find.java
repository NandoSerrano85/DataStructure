
/********************************************************************** 
    Purpose/Description: Rotate program generate a random number N no larger 
                         then the size of the array, which is then placed in 
                         the rotate method to rotate the array N amount of 
                         times. The findX method is then used to search the 
                         array for the position of X in the array.
                         
                         Running time complexity is O(N).
    
    Author: Fernando Serrano
          
    Certification:  I hereby certify that this work is my own and 
                    none of it is the work of any other person.  
*********************************************************************/ 
import java.util.*;
import java.lang.*;

public class Rotate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random generator = new Random();
   
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int n = arr.length/arr[0];
        int x = 5;
        int shift = generator.nextInt(arr.length-1);
        rotate(arr,shift);
        
        System.out.println("This is the array after rotation " + Arrays.toString(arr));
        int found = findX(arr, 0, n-1, x);
        
        if(found == -1)
            System.out.println("The number " + x + " is not in the array.");
        else
            System.out.println("Your x is in position " + found);
    }
    
    public static void rotate(int arr[], int k){
        
        int j = 0;
        int temp[] = new int[arr.length];
        
        for(int i = 0; i < k; i++)
            temp[i] = arr[arr.length-k+i];
        
        for(int i = k; i<arr.length; i++){
            temp[i] = arr[j];
            j++;
        }
        
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
    
    public static int findX(int arr[], int init, int n, int x){
        if(init > n)
            return -1;
        
        int mid = (init+n)/2;
        
        if(arr[mid] == x)
            return mid;
        
        if(arr[init] <= arr[mid]){
            if(x >= arr[init] && x <= arr[mid])
                return findX(arr,init, mid-1, x);
            return findX(arr, mid+1, n, x);
        }
        if(x >= arr[mid] && x <= arr[n])
            return findX(arr, mid+1, n, x);
        
        return findX(arr, init, mid-1, x);
    }
    
}
