/********************************************************************* 
          Purpose/Description: Main is the test for the method Stack sort. Sort method 
                               uses a temp variable to test each value to see if its 
                               higher or lower then previous value. The running time 
                               complexity of this method is O(N^2) due to the nested loops.
							   
          Author: Fernando Serrano
		  
          Certification: I hereby certify that this work is my own 
                         and none of it is the work of  any other person.  
********************************************************************/ 
package assignment2_problem2;

import java.util.*;

/**
 *
 * @author Fernando Serrano
 */
public class Assignment2_Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack stk = new Stack();
        int[] expression = {3,5,10,3,200,500,43,67,84,77,1}; 
        for(int i = 0; i<expression.length; i++){
            stk.push(expression[i]);
        }
        System.out.print(sort(stk));
    }
    
    public static Stack<Integer> sort(Stack<Integer> s){
        Stack <Integer> temp = new Stack<Integer>();
        while(!s.isEmpty()){
            int tmp = s.pop();
            while(!temp.isEmpty() && temp.peek()>tmp){
                s.push(temp.pop());
            }
            temp.push(tmp);
        }
        return temp;
    }
    
}
