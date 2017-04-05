// NAME : Norman Kuang
// DATE: February 2017
// CLASS: CMPU-102-52
// ASSIGNMENT #2

// The StartClockDisplay.java file is a class that runs the main program that displays
//   the clock. This class creates two DoubleDigit objects using the ClockDisplay() constructor.
//   Each of these objects represent the hour and minutes of a digital clock. A menu provides the user
//   with many options in regards to what they want to do with the clock object, such as displaying,
//   incrementing, and resetting the time on the clock.

import javax.swing.*; // package that allows JOptionPane access

public class StartClockDisplay {
  
  public static void main(String[] args) {
    
    ClockDisplay clock = new ClockDisplay();   // Declaration/Instantialization of objects and variables
    int menuOption;     

    do {  // do-while loop; this program keeps running until the user quits
      
      String menu = ( "Please choose one of the\nfollowing menu options:\n" +   // Menu 
                      "1 - Display the time.\n" +
                      "2 - Fast forward the time. \n" +
                      "3 - Reset the time. \n" +
                      "4 - Quit.");
      
      menuOption = Integer.parseInt( JOptionPane.showInputDialog( menu)); // User's menu option choice
      
      if ( menuOption == 1)  // Displays the time with the getTime() method
        JOptionPane.showMessageDialog( null, ("It is " + clock.getTime()));
      
      else if ( menuOption == 2) {  // Advances the clock by a certain amount of minutes with 
                                    //  incrementClock() method
    	int advanceClock;
        advanceClock = Integer.parseInt( JOptionPane.showInputDialog( "How many minutes would you like\n"+
                                                    "to advance the clock?"));
        clock.incrementClock( advanceClock);
      }
      
      else if ( menuOption == 3) {  // Resets the clock using setTime() method
        int resetHours, resetMinutes;  // Variables that stores user input
        int totalMinutes;
        
        do { // Keeps prompting until inputs are within limits
          resetHours = Integer.parseInt( JOptionPane.showInputDialog( "Reset to what hour (0-23)? "));
        } while (resetHours >= clock.hours.upperLimit || resetHours < 0);
        
        do { // Keeps prompting until inputs are within limits
          resetMinutes = Integer.parseInt( JOptionPane.showInputDialog( "Reset to what minute (0-59)?"));
        } while (resetMinutes >= clock.minutes.upperLimit || resetMinutes < 0);
        
        // end of do-while loops
        
        totalMinutes = ( resetHours * 60) + resetMinutes;  // Hour -> Minute conversion
        clock.setTime( totalMinutes); 
      }
     
      else if ( menuOption == 4) // Quits the program
        break;
    
      else // Message that appears when the user enters an invalid integer option
        JOptionPane.showMessageDialog( null, "Please choose one of the following menu options.");
   
    } while ( true); // end of menu do-while loop
    
    // End of Program
    JOptionPane.showMessageDialog( null, "Thank you, the program will now shut down.");
    System.exit(0);
    
  } // end of main()
} // end of StartClockDisplay class