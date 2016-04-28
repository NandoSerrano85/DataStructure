/********************************************************************* 
          Purpose/Description: Main is the test for the Methods intersection and union. 
                               Intersection does a set difference between L1 and L2 and 
                               then L2 and L1 and adds them to result to display. Union
                               does a set difference between L1 and L2 then adds the 
                               result to L2 and adds them to result to display.
                               Running time complexity is O(1) for each.
							   
          Author: Fernando Serrano 
		  
          Certification: I hereby certify that this work is my own 
                         and none of it is the work of  any other person.  
********************************************************************/ 
package assignment2_problem1;

import java.util.*;
/**
 *
 * @author Fernando Serrano
 */
public class Assignment2_Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> L1 = Arrays.asList("The", "young", "brown", "fox");
        List<String> L2 = Arrays.asList("The", "old", "brown", "fox");
        List<String> result = new ArrayList<String>();
        intersection(L1, L2, result);
        union(L1, L2, result);
        
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> result){
        ArrayList<AnyType> add = new ArrayList<AnyType>(L1);
        add.removeAll(L2);
        
        ArrayList<AnyType> remove = new ArrayList<AnyType>(L2);
        remove.removeAll(L1);
        
        result.addAll(add);
        result.addAll(remove);
        
        System.out.println(result);
        result.clear();
        
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void union(List<AnyType> L1, List<AnyType> L2, List<AnyType> result){
        ArrayList<AnyType> remove = new ArrayList<AnyType>(L1);
        remove.removeAll(L2);
        
        ArrayList<AnyType> add = new ArrayList<AnyType>(remove);
        add.addAll(L2);
        
        result.addAll(add);
        
        System.out.println(result);
    }
    
} 
