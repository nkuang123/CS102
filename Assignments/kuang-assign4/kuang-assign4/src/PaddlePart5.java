
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Paddler.java
 *
 * @author Norman Kuang Assignment 4, CMPU102, Spring 2017
 *
 * When run as a program, this class opens a window on the screen that contains
 * a ball and a paddle. The ball bounces off of the left, top, and right edges.
 * The ball also bounces off of the paddle. The objective of the game is to keep 
 * the ball bouncing as long as possible.
 * 
 *
 */
public class PaddlePart5 extends JPanel implements ActionListener, MouseMotionListener {

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
    private int xPos = 450;
    private int yPos = 100;

    // instance variable to stop drawing when ball off 
    // window
    private boolean inPlay = true;

    // instance variable for initial x coordinate of paddle
    private int paddleX = WINDOW_WIDTH / 2 - PADDLE_WIDTH / 2;

    // instance variables changing position of ball
    private int xChange = -3, yChange = 3;
    
    // duplicating the original values so that they can be referenced later on
    private static final int SAVED_X_CHANGE = -3, SAVED_Y_CHANGE = 3;

    // instance variable for keeping track of paddle hits
    private int paddleCounter = 0;

    // instance variable that keeps track of the highest score for that instance
    private int highScore = 0;

    // JLabel object used to display paddleCounter
    private final JLabel displayPaddleCount = new JLabel("");
    
    // JButtons for various functions
    private final JButton restartButton = new JButton("Restart");
    private final JButton speedButton = new JButton("Speed Increase");

    // drawFrame called by paintComponent. Use the Graphics
    // object to draw the ball (and paddles) on the scene.
    public void drawFrame(Graphics g) {
        if (inPlay) {
            checkForWallHit();
            /*
             * Uncomment the line below after the paddle is created
             */
            checkForPaddleHit();
            //
            // Change the position of the ball
            xPos = xPos + xChange;
            yPos = yPos + yChange;

            // draw the ball
            g.setColor(Color.YELLOW);

            g.fillOval(xPos, yPos, DIAMETER, DIAMETER);

            g.setColor(Color.BLACK);

            g.drawOval(xPos, yPos, DIAMETER, DIAMETER);

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

        } else {
            g.drawString("HIGH SCORE: " + highScore,
                    (WINDOW_WIDTH / 2) - 50, (WINDOW_HEIGHT / 2) - 30);
            g.drawString("Game over. Close window to quit",
                    (WINDOW_WIDTH / 4) + 20, WINDOW_HEIGHT / 2);
            g.drawString("Press restart to play again",
                    (WINDOW_WIDTH / 4) + 45, (WINDOW_HEIGHT / 2) + 30);
            
        }
        /**
         * PART 3: Add code below to draw a string that says "Game over. Close
         * window to quit." in the middle of the window if inPlay is false.
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
         * PART 2: Change the code below to set the boolean inPlay to false if
         * the ball goes off the bottom of the scene. The inPlay variable is
         * used in the drawFrame method.
         */
        // ball at bottom of scene
        if ((yPos + DIAMETER > this.getHeight()) && (yChange > 0)) {
            inPlay = false;
            // We only change the high score if it is less than the 
            //  current paddle score, resulting in the highest score.
            if (highScore < paddleCounter) {
                highScore = paddleCounter;
            }
        }
    }

    /**
     * PART 4: method checkForPaddleHit
     *
     * Write a method that checks if ball is touching the paddle and, if so,
     * changes the y direction of ball movement. After the method is written,
     * uncomment the call to this method in the drawFrame method.
     */
    public void checkForPaddleHit() {
        if ((xPos >= paddleX) && ((xPos + DIAMETER) <= (paddleX + PADDLE_WIDTH))
           && ((yPos + DIAMETER) >= PADDLE_Y) && (yPos < PADDLE_Y + PADDLE_HEIGHT) 
           && (yChange > 0)) {
            // Only bounce when the ball is in contact with the paddle and 
            //  coming down, not above it or below it. Then increment counter.
            yChange *= -1;
            paddleCounter++;
        }
    }

    /**
     * method setup
     *
     * @param drawingArea is of type PaddleStarter
     */
    public void setup(PaddlePart5 drawingArea) {
        // Create JFrame to hold a JPanel
        JFrame window = new JFrame("Half Pong!");
        window.setBackground(BACKGROUND_COLOR);
        drawingArea.setLayout(new BorderLayout());
        drawingArea.addMouseMotionListener(this);

        // Panel that holds score and button
        JPanel topBar = new JPanel();
        speedButton.addActionListener(this);
        restartButton.addActionListener(this);
        restartButton.setEnabled(false);
        topBar.add(displayPaddleCount, BorderLayout.EAST);
        topBar.add(speedButton, BorderLayout.WEST);
        topBar.add(restartButton, BorderLayout.WEST);

        drawingArea.add(topBar, BorderLayout.SOUTH);
        // set the drawingArea JPanel to be the content pane of JFrame window
        window.setContentPane(drawingArea);

        /**
         * PART 5: Add a MouseMotionListener to the drawingArea by either using
         * an anonymous inner class or by having the PaddleStarter class
         * implement both the ActionListener and MouseMotionListener.
         *
         * Implement the MouseMoved method to move the paddle. This means the
         * paddle's x,y coordinate will be set to the x,y position of the
         * cursor. Remember to add a blank method for the MouseDragged method in
         * the MouseListener interface.
         */
        // Set up JFrame before exiting main method.
        window.pack();
        window.setLocation(100, 50);
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
        PaddlePart5 da = new PaddlePart5();
        da.setup(da);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // The only events possible in this version are 
        // ActionEvents generated by the frameTimer
        repaint();
        displayPaddleCount.setText("Score: " + paddleCounter);
        if (inPlay == false) {
            restartButton.setEnabled(true);
            if (evt.getSource().equals(restartButton)) {
                // When restart is pressed, we will reset all values back to the
                //  original state and disable the restart button.
                inPlay = true;
                xPos = 450;
                xChange = SAVED_X_CHANGE;    // Original X Values
                
                yPos = 100;
                yChange = SAVED_Y_CHANGE;    // Original Y Values
                
                paddleCounter = 0;
                restartButton.setEnabled(false);
            }
        } else if (evt.getSource().equals(speedButton)) {
            // We want to subtract if value is negative and add if value is positive;
            //  that way, the values will mirror each other.
            if (xChange < 0) {
                xChange--;
            } else {
                xChange++;
            }

            if (yChange < 0) {
                yChange--;
            } else {
                yChange++;
            }
        }
    }

    @Override
    // mouseDragged() left blank because implementation not needed
    public void mouseDragged(MouseEvent evt) {
    }

    @Override
    // mouseMoved() controls the movement of the paddle
    public void mouseMoved(MouseEvent evt) {
        paddleX = evt.getX();
    }

    @Override
    // Called when program started and every time repaint() is called.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g);
    }
}
