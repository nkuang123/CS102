package assign3;

/**
 * class ConsList: representation of a non-empty list of integers
 * @author Norman Kuang
 */
public class ConsList implements IList{
    
    // private instance variables
    private int first;
    private IList rest;
    
    /**
     * Constructor for objects of type ConsList
     * @param first is an integer
     * @param rest is an IList 
     */
    public ConsList(int first, IList rest){
        this.first = first;
        this.rest = rest;
    } // end of ConsList constructor
    
    /**
     * length 
     * @return integer holding length of this list 
     */
    public int length() {
        
        return 1 + this.rest.length();
        
    } // end of length()
    
    /**
     * sum 
     * @return integer holding sum of all number in this 
     * list 
     */
    public int sum() {
        
        return this.first + this.rest.sum();
        
    } // end of sum()
    
    /**
     * doubleEach
     * @return IList representing each element multiplied by 2
     */
    public IList doubleEach() {
        
        IList doubledList = new MTList();
        
        doubledList = new ConsList ((2 * this.first), this.rest.doubleEach());
        
        return doubledList;
        
    } // end of doubleEach()
    
    /**
     * onlyEvens
     * @return IList with only the even numbers
     */
    public IList onlyEvens() {
        
        IList evenList = new MTList();
        
        if (this.first % 2 == 0)
            evenList = new ConsList (this.first, this.rest.onlyEvens());
        
        else
            evenList = this.rest.onlyEvens();
        
        return evenList;
        
    } // end of onlyEvens()
    
    /**
     * sort
     * @return IList with numbers in numerical order
     */
    public IList sort() {
        
        IList sortedList = new MTList();
        
        sortedList = this.rest.sort().insert(first);  
        // sorts the REST of the
        //  list and inserts the 
        //  first element into THAT list
        
        return sortedList;

    } // end of sort()
    
    /**
     * insert
     * @return IList with inserted element in list
     */
    public IList insert(int insertElement) {
        
        IList insertedList = new MTList();
        
        if ( insertElement <= this.first) 
           insertedList = new ConsList (insertElement, this);
            // inserts the given integer before the list
        
        else 
            insertedList = new ConsList (this.first, 
                    this.rest.insert(insertElement));
            // inserts the given integer into the rest of the list
            //  and after the first element
       
        return insertedList;
        
        
    } // end of insert()
    
    /**
     * toString
     * @return string representation of this list
     */
    public String toString() {
        // Returns string representation of this list
        return "" + this.first + " " + this.rest;
    } // end of toString()
    
} // end of ConsList class
