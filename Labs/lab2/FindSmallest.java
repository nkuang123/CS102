// Name : Norman Kuang
// Date: February 6, 2017

// This program prompts the user for and reads positive integers from
//  the keyboard until the user enters 0. Once the user enters 0, the program
//  stops taking in integers and finally finds the smallest value.

import java.util.*;

public class FindSmallest {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int smallestValue = Integer.MAX_VALUE;
    int inputValue = Integer.MAX_VALUE;
    
    System.out.println(" Please enter any number of positive integers and I will");
    System.out.println(" find the smallest. Enter 0 to stop reading numbers.");
    
    while (inputValue != 0) {
      inputValue = keyboard.nextInt();
      if ((inputValue < smallestValue) && (inputValue > 0))
        smallestValue = inputValue;
    }
    
    System.out.printf(" The smallest value is %d.\n", smallestValue);
    
  } // end of main method
} // end of FindSmallest class