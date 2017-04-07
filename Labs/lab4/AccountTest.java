/**
 * NAME: Norman Kuang
 * DATE: February 2017
 * ASSN: Lab 4
 * 
 * 
 * 
 * CS101 - Spring 2017 -Lab 4 Tester file
 *
 * Instantiates 3 objects of type SavingsAccount and 
 * CheckingAccount subclasses. Does a deposit, a
 * transfer, and a withdrawal and then prints the 
 * balance of each account.
 *  
 * After writing the classes BankAccount, SavingsAccount
 * and CheckingAccount, run this program to test your 
 * classes.  Then try to figure out the errors that occur 
 * when the 3 lines in the main method that are commented 
 * out are uncommented.
 * 
 * Lastly, uncomment the processAccount static method and
 * find reasons for the error messages that occur.
 */
public class AccountTest
{
  public static void main(String[] args)
  {
    BankAccount savings1 = new SavingsAccount(0);
    BankAccount savings2 = new SavingsAccount(0);
    BankAccount check = new CheckingAccount(12000);
    
    savings1.deposit(10000.00); 
    savings1.transfer(savings2, 2000);
    
    check.withdraw(7500.0);
    
    savings1 = processAccount(savings1);
    savings2 = processAccount(savings2);
    check = processAccount(check);
    
    System.out.println(savings1); // calls toString method
    System.out.println(savings2); // on each object
    System.out.println(check);
    
  }
  
// Why do errors occur here when the 3 commented statements in
// the main method and this method are uncommented?
  
  

  public static BankAccount processAccount(BankAccount acct)
  {
    if (acct instanceof SavingsAccount)
      ((SavingsAccount)acct).addPeriodicInterest();
    else if (acct instanceof CheckingAccount)
      ((CheckingAccount)acct).subtractPenalty();
    return acct;
  }

}

