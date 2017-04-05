/** 
 * CMPU 102, Spring 2017, Homework 1 (part 2)
 * 
 * Name: Norman Kuang
 * Date: February 2017
 *
 * Program CollatzExtra: 
 * 
 * Given a positive integer, n, define the Collatz sequence starting 
 * from n as follows: 
 *        If n is an even number, then divide n by two; 
 *        but if n is odd, then multiply n by 3 and add 1. 
 *        Continue to generate numbers in this way until n 
 *        becomes equal to 1. For example, starting from n = 3, 
 *        which is odd, we multiply by 3 and add 1, giving 
 *        n = 3*3+1 = 10. Then, since n is even, we divide by 2, 
 *        giving n = 10/2 = 5. We continue in this way, stopping 
 *        when we reach 1. The complete sequence is: 
 *                   3, 10, 5, 16, 8, 4, 2, 1.
 * 
 * Write a program that will read a positive integer from the user and 
 * will print out the Collatz sequence starting from that integer. It  
 * should also count and print out the number of terms in the sequence, 
 * the number of steps, and the biggest term."
 */

/* 
 * Choose one of the import statements below for type of reader you want
 * to use and delete the other import statement
 */
import java.util.*;    // for Scanner


public class CollatzExtra {

    private static Scanner rd;  
    /**
     * Execution starts below at the main method.
     * 
     * Prompt for and read a natural number (n > 0) from the user. 
     * 
     * Call method getCollatzSequence to compute the Collatz sequence,
     * passing in argument n just read from user and print the string 
     * generated in and returned from method getCollatzSequence.
     * 
     */
    public static void main(String[] args) {   
      Scanner numberReader = new Scanner( System.in);
      
      System.out.println( "Please enter a positive whole number greater than or equal to 1 and I will generate and");
      System.out.print( "display all the numbers in the Collatz sequence: ");
      int n = numberReader.nextInt(); // stores the user's input
      
      getCollatzSequence(n);       // calling getCollatzSequence() 
    } // end of main method
    
    /**
     * method getCollatzSequence
     * @parameter int n
     * @return String
     * Calculates the Collatz Sequence for a given natural number and
     * returns all the intermediate numbers in a string.
     */
    public static String getCollatzSequence(int n) {
      int startingNumber = n;            // n will change, so we store the number in a variable startingNumber
      int stepCounter = 1;               // stepCounter keeps track of the # of steps
      String str = "";                   // initializing empty string
      str += Integer.toString(n);        // first number of the string = given number
      int biggestNumber = n;
      
      while ( n > 1 ) {                   // Collatz algorithm; n > 0 because 0 causes an infinite loop
        if (n % 2 == 0) 
          n = n / 2;
        else
          n = 3 * n + 1;
        
        str += " " + Integer.toString(n);  // string concatenation
        stepCounter++;                          // step increment
        
        if (n > biggestNumber)                  // storing the largest term in biggestNumber
          biggestNumber = n;
      } // end of while loop
        
        System.out.printf( "The Collatz sequence for starting number %d is:\n", startingNumber);
        System.out.println(str);
        System.out.printf( "Terminated after %d steps.\n", stepCounter);
        System.out.printf( "The biggest term in the sequence is: %d \n", biggestNumber);
        return str;       // return type is a String

    }  // end of getCollatzSequence method

}  // end of class Collatz