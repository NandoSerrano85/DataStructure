/********************************************************************** 
    Purpose/Description: NxN matrix M of nonnegative integers. For M, 
						 each individual row is increasing from left 
						 to  right. Each individual column is increasing 
						 from top to bottom. Running time complexity O(n)
						  T(n)=(3n+3)
    
    Author: Fernando Serrano
          
    Certification:  I hereby certify that this work is my own and 
                    none of it is the work of any other person.  
*********************************************************************/ 

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        // Sample date for problem
        int[][] sample = {{1,3,5},{4,6,25},{9,16,81}};
        
        //allows user to input what number they wish to look for
        System.out.print("What number are you searching for: ");
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        System.out.println(search(sample, query));
    }
    
    public static String search(int matrix[][], int x){
        int row = 0;
        int col = matrix.length - 1;
        while(row <= (matrix.length-1) && col>=0){
            if(matrix[row][col] < x)
                row++;
            else if(matrix[row][col] > x)
                col--;
            else
                return "-Vaule found at-\nRow: " + (row+1) + ", Column: " + (col+1);
        }
        return "Number not found";
    }
}
