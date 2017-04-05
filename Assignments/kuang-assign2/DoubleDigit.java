// NAME : Norman Kuang
// DATE: February 2017
// CLASS: CMPU-102-52
// ASSIGNMENT #2

// The DoubleDigit.java file is a class that is used to create DoubleDigit objects. 
//  When instantialized, the objects represent 2-digit integers, which are modeled after 
//  the hours and minutes on a digital clock. There are also methods that increment, set,
//  and get the value of the object.

import java.text.*; // package that allows DecimalFormat access


public class DoubleDigit {     
  int upperLimit;       // Declaration of non-static fields for objects
  int displayValue;
  
  DoubleDigit( int x) {  // Constructor 
    this.upperLimit = x;
    this.displayValue = 0;
  }
  
  public void setDisplayValue( int n) {     // Setter that sets the displayValue to a given integer.
    if ( (n < this.upperLimit) && ( n >= 0))
      this.displayValue = n;
  }
  
  public String incrementValue() {  // Method that increments the displayValue
    if ( this.displayValue == this.upperLimit)
      this.displayValue = 0;
    else 
      this.displayValue++;
    
    return( String.valueOf(this.displayValue));
  }
  
  public String getDisplayValue() { // Getter that returns a DecimalFormat of the displayValue
    DecimalFormat df = new DecimalFormat("00");  // DecimalFormat object
    return( df.format(this.displayValue));
  }
  
}


  
  