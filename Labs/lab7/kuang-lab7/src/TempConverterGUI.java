
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * LAB 7 STARTER, CMPU102, Spring 2017
 *
 * TASK 1:
 *
 * WRITE COMMENTS TO DESCRIBE CLASS FUNCTION HERE. For this lab, we will write a
 * Java Graphical User Interface that takes input from the user and converts the
 * temperature in Fahrenheit to Celsius and vise versa.
 *
 * AUTHOR: Norman Kuang
 */
public class TempConverterGUI extends JFrame implements ActionListener {

    // Constants for window size
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    // Constants for text entry boxes
    private static final int BOX_Y = 80;
    private static final int BOX_SIZE = 50;

    // Constants for JButtons
    private static final int BUTTON_WIDTH = 70;
    private static final int BUTTON_HEIGHT = 30;

    // private instance variables to be instantiated in
    // the constructor
    private JButton quit, startOver;
    private JLabel fahr, cels, intro;
    private Container holder;
    private JTextField getCelsInput;
    private JTextField getFahrInput;
    
    // JOptionPane message in the beginning
    private static final String introDialog = 
            "Enter a temperature in degrees\n" + 
            "Fahrenheit in the left box and press\n" +
            "enter to see the equivalent temperature\n" +
            "in degrees Celsius in right box.\n" +
            "\n" +
            "Enter a temperature in degrees\n" +
            "Celsius in the right box and press\n" +
            "enter to see the equivalent temperature \n" +
            "in degrees Fahrenheit in left box.";
            
            

    public static void main(String[] args) {
        TempConverterGUI bGUI = new TempConverterGUI();
        JOptionPane.showMessageDialog(null, introDialog);
    }

    TempConverterGUI() {

        /* The lines below get the Container out of this JFrame,
       * setting the layout to null, setting the background
       * color and setting the location to 100,50
         */
        holder = this.getContentPane();
        holder.setLayout(null);
        holder.setBackground(Color.white);
        this.setLocation(100, 50);

        /* TASK 2
       * Instantiate the fahr and cels JLabels below the
       * left and right JTextFields, respectively. This
       * should include only 3 lines of code to add 
       * each JLabel). Use the BOX_SIZE AND BOX_Y constants
         */
        fahr = new JLabel("Fahrenheit");
        fahr.setBounds(50, (BOX_Y - 40), (BOX_SIZE + 40), BOX_SIZE);
        holder.add(fahr);

        cels = new JLabel("Celsius");
        cels.setBounds(200, (BOX_Y - 40), (BOX_SIZE + 40), BOX_SIZE);
        holder.add(cels);

        /* TASK 3
       * Instantiate the intro JLabel to the text shown in
       * the top figure of the instructions (again this should
       * take only three lines of code).
         */
        intro = new JLabel("Enter number to see conversion.");
        intro.setBounds(50, (BOX_Y + 50), (BOX_SIZE + 200), BOX_SIZE);
        holder.add(intro);

        /* TASK 4
       * Instantiate the quit JButton as shown in the figures
       * in the directions (This should include 4 lines of 
       * code.
         */
        quit = new JButton("QUIT");
        quit.setBounds(((WIDTH / 2) - (BUTTON_WIDTH / 2)),
                (HEIGHT - 60), BUTTON_WIDTH, BUTTON_HEIGHT);
        quit.addActionListener(this);
        holder.add(quit);

        // The JTextFields are created for you
        getFahrInput = new JTextField("");
        getFahrInput.setBounds(50, BOX_Y, BOX_SIZE, BOX_SIZE);
        getFahrInput.setEditable(true);
        getFahrInput.addActionListener(this);
        holder.add(getFahrInput);

        getCelsInput = new JTextField("");
        getCelsInput.setBounds(200, BOX_Y, BOX_SIZE, BOX_SIZE);
        getCelsInput.setEditable(true);
        getCelsInput.addActionListener(this);
        holder.add(getCelsInput);

        /* The final settings of the JFrame are done
       * for you below.
         */
        this.pack();
        this.setTitle("Temperature Converter");
        this.setSize(300, 300);
        this.setVisible(true);
    } //end of constructor 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getFahrInput)) {
            /* TASK 5
          * Write the code to get the String entered
          * in the getFahrInput JTextField, convert the
          * String to a double, use the fahrenheit to
          * celcius conversion equation, set the value
          * in the getCelsInput JTextField, and set
          * the intro text to show conversion from
          * Fahrentheit to Celsius as shown in the 
          * lower 2 figures of the instructions.
             */
            try {
                double fahrValue;
                double celsValue;

                fahrValue = Double.parseDouble(getFahrInput.getText());
                // Fahrenheit to Celsius formula
                celsValue = Math.round((((fahrValue - 32) * 5) / 9));
                getCelsInput.setText(Double.toString(celsValue)); // Sets value of Celsius box
                intro.setText("Fahrenheit to Celsius ----->"); // Changes intro message
                
            } catch (NumberFormatException err) {
                intro.setText("Enter number to see conversion.");
            }
            
        } else if (e.getSource().equals(getCelsInput)) {
            /* TASK 6
          * Do the same as above, in TASK 5, for the
          * getCelsInput JTextField
             */
            try {
                double celsValue;
                double fahrValue;
                
                celsValue = Double.parseDouble(getCelsInput.getText());
                // Celsius to Fahrenheit formula
                fahrValue = Math.round((((celsValue * 9) / 5) + 32));
                getFahrInput.setText(Double.toString(fahrValue)); // Sets value of Fahrenheit box
                intro.setText("<----- Celsius to Fahrenheit"); // Changes intro message
                
            } catch (NumberFormatException err) {
                intro.setText("Enter number to see conversion."); 
            }
            
        } else if (e.getSource().equals(quit)) {
            System.exit(0);
        }
    } // end actionPerformed
}    // end class
