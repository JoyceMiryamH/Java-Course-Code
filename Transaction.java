/*
 * Transaction
 *
 * Created on May 20th, 2014
 * Last updated on June 4th, 2014
 *
 * Course:      1121 X
 * Assignment:  1
 */

import java.util.Date;

public class Transaction {
  
  // Number of customer with particular transaction
  private String customerNumber;
  // Transaction type of particular transaction
  private String transactionType;
  // amount of particular transaction
  private double amount;
  // date of particular transaction
  private Date date;
  // description of fees of particular transaction
  private String fees;
  
  /**
     * Class constructor; 
     *
     */
  
  public Transaction(String customerNumber, String transactionType, double amount, String fees) {
    this.customerNumber = customerNumber;
    this.transactionType = transactionType;
    this.amount = amount;
    date = new Date();
    this.fees = fees;
  }
    
   public String toString()
   {
     return ("Customer Number: "+customerNumber+" Transaction type: "+transactionType+" Amount "+amount+" Date: "+date+" Fees: "+fees);
   }
    
  // method processTran
   public void processTransaction (Bank bank)
   {
     if (transactionType.equals("deposit"))
       bank.makeDeposit(customerNumber, amount);
     else if (transactionType.equals("withdrawl"))
       bank.makeWithdrawal(customerNumber, amount);
   }
}
