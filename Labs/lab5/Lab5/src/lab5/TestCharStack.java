/**
 * Class TestCharStack is used to test the CharStack
 * and its associated class Stackable.java
 */
package lab5;

/**
 *
 * @author Norman Kuang
 */
public class TestCharStack {  
     /**
     * main method creates a new object of type CharStack,
     * pushes 4 Characters on the stack, and then empties
     * the stack using the toString() method, displaying its 
     * contents in the order they are removed from the stack.
     */
    public static void main (String[] args) { 
        CharStack cs = new CharStack(); 
        cs.push('A');
        cs.push('B');
        cs.push('Y');
        cs.push('Z');
        System.out.println();
        while(!cs.isEmpty()){
            
            
            cs.pop();
        }
    } 
}
