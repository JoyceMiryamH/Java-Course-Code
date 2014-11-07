/*
 * SavingsAccount
 *
 * Created on May 20th, 2014
 * Last updated on June 4th, 2014
 *
 * Course:      1121 X
 * Assignment:  1
 */
public class SavingsAccount extends Account {
  
  /**
     * Class constructor; 
     *
     */
  
  public SavingsAccount(Customer customer, String accountNumber) {
    super(customer, accountNumber);
  } 
  
  // deposit method
  public void deposit(double amount) {
  this.setBalance(this.getBalance() + amount);
  }

  // withdraw method
  public void withdrawl(double amount) {
    this.setBalance(this.getBalance() - amount);
  }

  // method to add interest
  public void addInterest(double interest) {
    this.setBalance(this.getBalance()*(1+interest));
  }
}
