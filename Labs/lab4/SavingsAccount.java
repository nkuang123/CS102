// * NAME: Norman Kuang
// * DATE: February 2017
// * ASSN: Lab 4


public class SavingsAccount extends BankAccount {
  
  private double interestRate = 0.005;
  
  public SavingsAccount( double initialAmount) {
    
    super( initialAmount);
    
  } // end of SavingsAccount() constructor
  
  public void addPeriodicInterest() {
   
    double interestAmount = super.balance * this.interestRate;
    
    super.deposit( interestAmount);
    
  } // end of addPeriodicInterest()
  
  public String toString() {
   
    return ("Savings " + super.toString());
    
  } // end of toString()
  
  
} // end of SavingsAccount subclass