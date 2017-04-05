import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Paddler.java 
 *
 * @author Norman Kuang
 * Assignment 4, CMPU102, Spring 2017
 *
 *  When run as a program, this class opens a window on the screen that
 *  contains a ball that bounces off all 4 walls
 * 
 */
public class PaddlePart2 extends JPanel implements ActionListener
{
    
    // constant for size of ball
    private static final int DIAMETER = 20;
    
    // constant for color of background
    private static final Color BACKGROUND_COLOR = Color.CYAN;
    
    // constant for milliseconds between Timer events
    private static final int MS = 15;
    
    // constant for size of window
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;
    
    //constants for position and size of paddle
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_HEIGHT = 20;
    
    // Paddle has unchanging y coordinate
    private static final int PADDLE_Y = WINDOW_HEIGHT - 100;
    
    // instance variables for position of ball
    private int xPos = 100; 
    private int yPos = 100;
    
    // instance variable to stop drawing when ball off 
    // window
    private boolean inPlay = true;
    
    // instance variable for initial x coordinate of paddle
    private int paddleX = WINDOW_WIDTH/2 - PADDLE_WIDTH/2;
    
    // instance variables changing position of ball
    private int xChange = -2, yChange = 2;
    
    // drawFrame called by paintComponent. Use the Graphics
    // object to draw the ball (and paddles) on the scene.
    public void drawFrame(Graphics g) { 
        if (inPlay) {
            checkForWallHit();
            /*
             * Uncomment the line below after the paddle is created
             */
            //checkForPaddleHit(g);
            //
            // Change the position of the ball
            xPos = xPos + xChange;
            yPos = yPos + yChange;
            
            // draw the ball
            g.setColor(Color.YELLOW);
            
            g.fillOval(xPos,yPos,DIAMETER,DIAMETER);
            
            g.setColor(Color.BLACK);
            
            g.drawOval(xPos, yPos, DIAMETER,DIAMETER);
            
            /* PART 1:
             * 
             * Draw a paddle (a rectangle), at PADDLE_Y pixels from 
             * the bottom. 
             * 
             * Use the variable paddleX, defined at the top of this 
             * file for the x coordinate of the paddle's top left
             * corner. 
             * 
             * Use the constant PADDLE_Y for the y coordinate of the 
             * paddle, and use PADDLE_WIDTH, and PADDLE_HEIGHT that are 
             * defined at the top of this file. 
             */
            g.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
        }
        /**
         * PART 3: Add code below to draw a string that says 
         *      "Game over. Close window to quit."
         * in the middle of the window if inPlay is false.
         */
    }
    
    /**
     * method checkForWallHit
     * 
     * Checks if ball is touching any of the edges.
     */
    public void checkForWallHit() {
        // ball at left of scene
        if ((xPos < 0) && (xChange < 0)) {
            xChange *= -1;
        }
        // ball at right of scene
        if (((xPos + DIAMETER) > this.getWidth())
                && (xChange > 0)) {
            xChange *= -1;
        } 
        
        // ball at top of scene
        if ((yPos < 0) && (yChange < 0)) {
            yChange *= -1;
        }
        
        /**
         * PART 2: Change the code below to set 
         * the boolean inPlay to false if the 
         * ball goes off the bottom of the scene.
         * The inPlay variable is used in          
         * the drawFrame method.
         */
        
        // ball at bottom of scene
        if ((yPos + DIAMETER > this.getHeight()) && (yChange > 0)){
            inPlay = false;
        }
    }
    
    /** PART 4:
      * method checkForPaddleHit
      * 
      * Write a method that checks if ball is touching 
      * the paddle and, if so, changes the y direction 
      * of ball movement. After the method is written,
      * uncomment the call to this method in the drawFrame 
      * method.
      */
    // public void checkForPaddleHit() {}
    
    
    
    /**
     * method setup
     * 
     * @param drawingArea is of type PaddleStarter
     */
    public void setup(PaddlePart2 drawingArea){
        // Create JFrame to hold a JPanel
        JFrame window = new JFrame("Half Pong!");
        window.setBackground(BACKGROUND_COLOR);
        drawingArea.setLayout(new BorderLayout());
        // set the drawingArea JPanel to be the content pane of JFrame window
        window.setContentPane(drawingArea);
        
        /** PART 5:
          * Add a MouseMotionListener to the drawingArea 
          * by either using an anonymous inner class or
          * by having the PaddleStarter class implement 
          * both the ActionListener and MouseMotionListener. 
          * 
          * Implement the MouseMoved method to move the paddle. 
          * This means paddle's x,y coordinate will be set to
          * the x,y position of the cursor. Remember to add
          * a blank method for the MouseDragged method in
          * the MouseListener interface.
          */
        
        // Set up JFrame before exiting main method.
        window.pack();
        window.setLocation(100,50);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        drawingArea.requestFocusInWindow();
        
        Timer frameTimer = new Timer(MS, drawingArea);
        frameTimer.start();  
    } 
    
    
    // starting point for execution
    public static void main(String[] args) {              
        // Create an item of 'this' type (JPanel)
        PaddlePart2 da = new PaddlePart2();
        da.setup(da);
    }
    
    
    public void actionPerformed(ActionEvent evt) {
        // The only events possible in this version are 
        // ActionEvents generated by the frameTimer
        repaint();
    }
    
    // Called when program started and every time repaint() is called.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g);
    }
}

