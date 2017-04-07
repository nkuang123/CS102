





// Name: Norman Kuang
// Date: February 6, 2017

import javax.swing.*;

public class AssignGradeCheck {
  public static void main(String[] args) {
    String userGradeString;
    double userGrade;
    char letterGrade;
    
    do {
      userGradeString = JOptionPane.showInputDialog( "Please enter a score between 0 and 100");
      userGrade = Double.parseDouble(userGradeString);
    } while ((userGrade > 100) || (userGrade < 0));
    
    
    if ( userGrade >= 90)
      letterGrade = 'A';
    else if ( userGrade >= 80)
      letterGrade = 'B';
    else if ( userGrade >= 70)
      letterGrade = 'C';
    else if ( userGrade >= 60)
      letterGrade = 'D';
    else
      letterGrade = 'F'; 
    // end of if statements and char conversion
    
    
    switch ( letterGrade ) {
      case 'A': {
        System.out.println( "The grade is A: Outstanding work!");
        break;
      }
      case 'B': {
        System.out.println( "The grade is B: Very good work!");
        break;
      }
      case 'C': {
        System.out.println( "The grade is C: Nice work.");
        break;
      }
      case 'D': {
        System.out.println( "The grade is D: Good try.");
        break;
      }
      case 'F': {
       System.out.println( "The grade is F: Happy trails.");
       break; 
      }
    } // end of switch
     
  } // end of main method
} // end of AssignGradeCheck class