/********************************************************************** 
    Purpose/Description:  Recursive method that returns all the possible 
						  sums that can be formed by using numbers in the 
						  array. Duplicates allowed. Complexity N
						  
    Author: Fernando Serrano
          
    Certification:  I hereby certify that this work is my own and 
                    none of it is the work of any other person.  
*********************************************************************/ 

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        // TODO code application logic here
        sumAll(new int[] {1,2,4,5}, 0, 0);
    }
    
    public static void sumAll(int[] n, int index, int total){
        
        if(n.length == index)
            System.out.print(total + " ");
        else if(index< n.length){
            int temp = total + n[index];
        
            sumAll(n, index+1, temp);
            sumAll(n, index+1, total);
        }
        
    }
}
