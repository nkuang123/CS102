// TASK 1: Enter your name, etc. in spaces provided below.
//
// Name: Norman Kuang
// Date: January 30, 2017

// This class reads 4 Strings from the keyboard,
// converts them to integers, performs calculations
// on those integers and displays the result.

// TASK 2: Import the java package that contains the Scanner
// class for reading input (you will probably need to google
// <Scanner java API> to find it). Write the import statement
// directly below this line.
import java.util.*;


/*
 * When you compile and run this program initially, the output 
 * should look like this:
 * 
 * Enter value a : The sum is 0 
 * 
 *************************************************************
 * Your final output should look like that shown below for
 * the given user entry values: a=5, b=6, c=8, and d=2 
 *************************************************************/ 
 // Enter value a : 5
 // Enter value b : 6
 // Enter value c : 8
 // Enter value d : 2
 // a = 5
 // b = 6
 // c = 8
 // d = 2
 // The sum is 21 
 

// First line of class stored in AddABCDv1.java
public class AddABCDv1 { 

  public static void main(String[] args) {
      
    // variable declarations
    int a, b, c, d, sum=0; //note: sum is declared as an int
    // and initialized on the line above, whereas a, b, c, 
    // and d are only declared as type int and not initialized.
    // THIS IS OK AND SHOULD NOT BE CHANGED. READ ON.
    
    String tempA,tempB,tempC,tempD; // declaration of 4 String
    // variables.  Note that none of these variables are 
    // initialized. THIS IS OK AND SHOULD NOT BE CHANGED. READ ON.
    
    // TASK 3: declare and instantiate a new object of
    // Scanner type on the line below this paragraph. Since input
    // is from the keyboard, use the object System.in as an
    // argument to the Scanner constructor.
    Scanner in = new Scanner(System.in);
    
    
    
    // TASK 4: write a prompt to the user and alternate 
    // prompts with calls to the Scanner object's nextLine() 
    // method for Strings tempA, tempB, tempC, and tempD. 
    //
    // Remember to prompt for each value before you read it as 
    // shown in the System.out.print method call below. 
    System.out.print("Enter value a : ");
    tempA = in.nextLine(); // these should be replaced with 
    System.out.print("Enter value b : ");
    tempB = in.nextLine(); // .nextLine() method calls to the
    System.out.print("Enter value c : ");
    tempC = in.nextLine(); // Scanner object created for TASK 3. 
    System.out.print("Enter value d : ");
    tempD = in.nextLine();
    
    // TASK 5: convert Strings tempA...tempD just read into an 
    // ints with the parseInt method of the java.lang.Integer 
    // class (change the "0"s to a method call, using the temp 
    // variables given above as input to the parseInt method).
    //
    a = Integer.parseInt(tempA); // the 0's on these lines should be replaced with 
    b = Integer.parseInt(tempB); // calls to Integer.parseInt.
    c = Integer.parseInt(tempC);
    d = Integer.parseInt(tempD);
    
    // TASK 6: add lines to output ints a...d, calculate and save 
    // result in the sum variable on 5 lines below this one.
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
    sum = a + b + c + d;
    
    


    //The line below prints the sum of the 4 numbers.
    System.out.println("The sum is "+sum);
    
    
  } // end of main method
} // end of class
