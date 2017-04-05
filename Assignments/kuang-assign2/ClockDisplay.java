// NAME : Norman Kuang
// DATE: February 2017
// CLASS: CMPU-102-52
// ASSIGNMENT #2

// The ClockDisplay.java file is a class used to create ClockDisplay objects. 
//  Using the ClockDisplay() constructor, we can create objects that represent
//  the hours and minutes of a digital clock. In addition, there are methods that
//  increment, set, and get the time.


public class ClockDisplay {
  
  static final int HOURS_IN_DAY = 24;       // Declaration/Instantialization of static fields
  static final int MINUTES_IN_HOUR = 60;
  DoubleDigit hours;        // Declaration of non-static fields
  DoubleDigit minutes;
  
  ClockDisplay() {  // Constructor that creates 2 DoubleDigit objects
    hours = new DoubleDigit( HOURS_IN_DAY);       // DoubleDigit object with upperLimit 24 (hours)
    minutes = new DoubleDigit( MINUTES_IN_HOUR);  // DoubleDigit object with upperLimit 60 (minutes)
  }
  
  public void incrementClock( int amountIncrement) { // Method that increments the hours/minutes on the clock
                                                     //  based on a given amount of minutes
    for (int i = 0; i < amountIncrement; i++) {  // for every minute, increment minutes by 1
      minutes.incrementValue();
      
      if ( minutes.displayValue == 60) {  // if minutes == 60, we want it to roll over to 0 and
        hours.incrementValue();           //  increment hours by 1. Also, if hours == 24, we want that
        
        if ( hours.displayValue == 24 )   //  to roll over to 0.
          hours.displayValue = 0;
        minutes.displayValue = 0;
      }
    }
  }
  
  public void setTime( int x) {  // Sets the clock based on the given amount of minutes
    minutes.setDisplayValue( x % 60);
    hours.setDisplayValue( x / 60);
  }
  
  
  public String getTime() { // Displays the time in a DecimalFormatted String
    return( hours.getDisplayValue() + ":" + minutes.getDisplayValue());
  } 
  
} // end of ClockDisplay class
  

  
      
        
      
    
    
    
  

  
  
  
  
  