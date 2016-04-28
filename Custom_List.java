/********************************************************************* 
          Purpose/Description: Main is the test for the class MyList. MyList is a custom 
                               class that allows you to push and pop to the front of the 
                               list and the end of the list all with O(1) complexity.
							   
          Author: Fernando Serrano 
		  
          Certification: I hereby certify that this work is my own 
                         and none of it is the work of  any other person.  
********************************************************************/ 
package assignment2_problem3;

import java.util.*;
/**
 *
 * @author Fernando Serrano
 */

public class Assignment2_Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyList list = new MyList();
        list.myPush("the");
        list.myPush("brown");
        list.myPush("young");
        list.myInject("fox");
        
        System.out.println("this is pop: " + list.myPop());
        System.out.println("this is pop: " + list.myEject());
        
    }
    
    public static class MyList <AnyType>{
        //Variables for class use only, with two node variables inorder to create a doubly linkedlist
        private Node first;
        private Node last;
        private int size;
        
        //Constructor for class and initialization of size
        public MyList(){
            size = 0;
        }
        
        //Node class creation inorder to create a next and previous ability.
        private class Node {
            AnyType x;
            Node next;
            Node prev;
            
            //constructor for node class initializing node clase variables
            public Node(AnyType x, Node next, Node prev) {
                this.x = x;
                this.next = next;
                this.prev = prev;
            }
        }
        
        public void myPush(AnyType x){
            //create nd intialize temp node
            Node tmp = new Node(x, first, null);
            //test temp for x if first is not empty then add x to the position before first
            if(first != null ) {first.prev = tmp;}
            first = tmp;
            //if last is empty then add x to last
            if(last == null) { last = tmp;}
            size++;
        }  
    
        public AnyType myPop(){
        
            Node tmp = first;
            first = first.next;
            first.prev = null;
            size--;
        
            return tmp.x;
        } 
        public void myInject(AnyType x){
            Node tmp = new Node(x, null, last);
            if(last != null) {last.next = tmp;}
            last = tmp;
            if(first == null) { first = tmp;}
            size++;
        } 
        public AnyType myEject(){
        
            Node tmp = last;
            last = last.prev;
            last.next = null;
            size--;
        
            return tmp.x;
        }
    }
    
}
