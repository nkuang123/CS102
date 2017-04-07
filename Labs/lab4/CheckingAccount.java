// * NAME: Norman Kuang
// * DATE: February 2017
// * ASSN: Lab 4


public class CheckingAccount extends BankAccount {
  
  static final double MINIMUM_BALANCE = 5000;
  double penalty = 5.00;
  
  public CheckingAccount( double initialAmount) {
   
    super( initialAmount);
    
  } // end of CheckingAmount() constructor
  
  public void subtractPenalty() {
   
    if ( super.balance < this.MINIMUM_BALANCE) 
      
      super.withdraw( penalty);
    
    
    
  } // end of subtractPenalty()
  
  public String toString() {
   
    return ("Checking " + super.toString());
    
  } // end of toString() 
  
  
  
} // end of CheckingAccount class
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  