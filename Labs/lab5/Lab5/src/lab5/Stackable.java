/**
 * interface stackable requires implementation of
 * all stack methods
 */
package lab5;

/**
 *
 * @author Norman Kuang 
 */
public interface Stackable {
     // remove and return the top char from the stack 
    public Character pop();
    // put a new char on the top of the stack 
    public void push(Character ch);
    // return true if the stack is empty, false ow 
    public boolean isEmpty();
    // return the value contained in the top node of the stack
    public Character peek(); 
    
}
