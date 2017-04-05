package assign3;

/**
 * class MTList: Representation of an empty list of integers
 * @author Norman Kuang
 */
public class MTList implements IList {
    
    /** 
     * length
     * @return integer length of this empty list
     */
    public int length() {
        
        return 0;
        
    } // end of length()
    
    /**
     * sum
     * @return integer representing sum of the numbers in 
     * this empty list
     */
    public int sum() {
        
        return 0;
        
    } // end of sum()
    
    /**
     * doubleEach
     * @return IList representing each element multiplied 
     * by 2.
     */
    public IList doubleEach() {
        
        return this;
    
    } // end of doubleEach()
    
    /**
     * onlyEvens
     * @return IList with only the even numbers
     */
    public IList onlyEvens() {
        
        return this;
        
    } // end of onlyEvens()
    
    /**
     * sort
     * @return IList with numbers in numerical order (empty in this case)
     */
    public IList sort() {
        
        return this;
        
    } // end of sort()
    
    /**
     * insert
     * @return IList with inserted element in empty list
     */
    public IList insert(int elementInsert) {
        
        IList insertList = new MTList();
        
        insertList = new ConsList (elementInsert, insertList);
        
        return insertList;
        
    } // end of insert()
    
    /**
     * toString 
     * @return String representation of empty list
     */
    public String toString() {
        return "";
    }   
}
