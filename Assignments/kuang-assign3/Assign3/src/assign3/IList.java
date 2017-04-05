package assign3;

/**
 * interface IList: used to simulate a
 * structurally recursive list of integers
 * @author Norman Kuang
 */
public interface IList {

    /**
     * length returns an integer representing
     * the length of the list
     */
    public int length();
    /**
     * sum returns an integer representing
     *  the sum of all the integers in the list
     */
    public int sum();
    /**
     * doubleEach returns an IList containing
     * the original data items, each multiplied 
     * by 2
     */
    public IList doubleEach();
    /**
     * onlyEvens returns an IList containing
     * only the even numbers in this list
     */
    public IList onlyEvens();
    /**
     * sorts the integers in the this list using 
     * both the sort and insert methods below
     */   
    public IList sort();
    public IList insert(int num);
            
}
