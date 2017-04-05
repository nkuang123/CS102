package assign3;

/**
 *
 * @author Norman Kuang
 */
public class TestIList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      IList listRan = new MTList();
      final int TOP = 20;
      
      for (int i = 0; i < TOP; i++) {
        listRan = new ConsList(generateNumber(), listRan);         
      }
      
      System.out.println("The list of random numbers: "+listRan+"\n");
      System.out.println("The length of the list is "+listRan.length()+"\n");
      System.out.println("The sum of the numbers in the list is "+
                          listRan.sum()+"\n");
      System.out.println("The doubled numbers in the random "+
                           "list are: "+listRan.doubleEach()+"\n");

      System.out.println("The even numbers in the random "+
                         "list are "+listRan.onlyEvens()+"\n");

      System.out.println("The random list is \n"+ listRan+"\n");
      System.out.println("The sorted list is \n"+ listRan.sort()+"\n");
      
      
      
      
    }
     
    /**
     * generateNumber: returns "random" 
     * @return integer generated randomly between 1 and 100
     */
    public static int generateNumber() {
        // Returns a random number between 1 and 100
         return (int)(Math.floor(Math.random() * 100 + 1));
        
    }
          
}
