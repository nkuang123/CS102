/**
 * Class CharStack implements a stack of Characters
 */
package lab5;

/**
 *
 * @author Norman Kuang
 */
public class CharStack implements Stackable{
    
    Node top = null;
    
    private class Node {
        
        Character item = null;
        Node next = null;
        
        Node(Character item, Node next) {
             
            this.item = item;
            this.next = next;
            
        }

                
    }
    

    
    public Character pop() {
        
        System.out.println("Popping " + top.item + " from stack.");
        
        Node originalTop = top;
        
        top = top.next;
        
        return originalTop.item;
                
    }

    
    public void push(Character ch) {
        
        System.out.println("Pushing " + ch + " on stack.");
        
        if ( top == null) {
            
             top = new Node(ch, null);
                   
        }
        else {
            
             Node newTop = new Node(ch, top);
             top = newTop;
            
        }
        
    }

    
    public boolean isEmpty() {
        
        return ( top == null);

    }

    
    public Character peek() {
        
        System.out.println("Peeking at " + top.item + " from stack.");
        
        return top.item;

    }
    
    
    
    
    
}
