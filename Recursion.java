
/********************************************************************** 
    Purpose/Description:  Recursive method that generates all possible 
						  distinct subsets of the characters of the 
						  given string. Time complexity 2^n
    
    Author: Fernando Serrano
          
    Certification:  I hereby certify that this work is my own and 
                    none of it is the work of any other person.  
*********************************************************************/ 
import java.util.*;
      
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(powerSet("abba"));
    }

   static List<String> powerSet(String s) {
    // the number of subsets is 2^n
    long numSubsets = 1L << s.length();
    return powerSet(s, numSubsets - 1);
    }

    static List<String> powerSet(String s, long active) {
        if (active < 0) {
            // Recursion base case
            // All 2^n subsets were visited, stop here and return a new list
            return new ArrayList<>();
        }

        StringBuilder subset = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // For each bit
            if (isSet(active, i)) {
                // If the bit is set, add the correspondent char to this subset
                subset.append(s.charAt(i));
            }
        }
        // Make the recursive call, decrementing active to the next state,
        // and get the returning list
        List<String> subsets = powerSet(s, active - 1);
        // Add this subset to the list of subsets
        subsets.add(subset.toString());
    
        //Remove any duplicates
        Object[] st = subsets.toArray();
        for(Object str : st){
            if(subsets.indexOf(str) != subsets.lastIndexOf(str))
                subsets.remove(subsets.lastIndexOf(str));
        }
        return subsets;
    }

    static boolean isSet(long bits, int i) {
        // return true if the ith bit is set
        return (bits & (1L << i)) != 0;
    }     
    
}
