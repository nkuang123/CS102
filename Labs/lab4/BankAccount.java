// * NAME: Norman Kuang
// * DATE: February 2017
// * ASSN: Lab 4



import java.text.*; // required for DecimalFormat class

public abstract class BankAccount {
  
  protected double balance;
  
  public BankAccount() {
    
    this.balance = 0.00;
    
  } // end of BankAccount() zero-parameter constructor 
  
  public BankAccount( double initialAmount) {
   
    this.balance = initialAmount;
    
  } // end of BankAccount() one-parameter constructor 
  
  public void deposit( double amount) {
   
    this.balance += amount;
    
  } // end of deposit(), adds to balance 
  
  public void withdraw( double amount) {
   
    this.balance -= amount;
    
  } // end of withdraw(), subtracts balance 
  
  public String toString() {
    
    DecimalFormat df = new DecimalFormat( "#.00");
    return ("Account balance: " + df.format( this.balance));
  
  } // end of toString()
  
  public void transfer( BankAccount other, double amount) {
    
    this.withdraw( amount);
    other.deposit( amount);
    
  } // end of transfer()
  
  
} // end of BankAccount() abstract class