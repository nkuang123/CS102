// NAME : Norman Kuang
// DATE: February 2017
// CLASS: CMPU-102-52
// ASSIGNMENT #2

// The TestDoubleDigits.java file is essentially a class that tests the methods of
//  the DoubleDigit class. Initially, we instantialize the DoubleDigit object and run
//  the methods that are in the class, showing that they function correctly.

public class TestDoubleDigits {  // Testing the DoubleDigit objects and its methods
  public static void main(String[] args) {
    DoubleDigit testdd = new DoubleDigit(60);
    
    System.out.println( "This object's current upper limit is: " + testdd.upperLimit);
    System.out.println( "This object's current display value is: " + testdd.displayValue);
    System.out.println( "We will now set the display value to 5.");
    testdd.setDisplayValue(5);
    System.out.println( "This object's current display value is: " + testdd.displayValue);
    System.out.println( "We will now increment the display value by 1.");
    testdd.incrementValue();
    System.out.println( "The final display value in decimal format is: " + testdd.getDisplayValue());
    
  
  }
}