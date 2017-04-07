// Name: Norman Kuang
// Date: January 30, 2017
// Description: This program prompts the user for four individual strings. Using these strings, the program outputs 
//  the concatenated version. 

import javax.swing.*;

public class StringFun {
  public static void main(String[] args){
    String stringA, stringB, stringC, stringD, totalString; // Declaration of initial strings
    stringA = JOptionPane.showInputDialog("Enter the first string: "); // Prompting user for 
    stringB = JOptionPane.showInputDialog("Enter the second string: "); // string inputs
    stringC = JOptionPane.showInputDialog("Enter the third string: ");
    stringD = JOptionPane.showInputDialog("Enter the fourth string: ");
    
    totalString = stringA + " " + stringB + " " + stringC + " " + stringD + "."; // String Concatenation
    JOptionPane.showMessageDialog(null, totalString); // Final pop-up message.
   } // End method
} // End class
