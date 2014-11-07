/*
 * Bank
 *
 * Created on May 20th, 2014
 * Last updated on June 4th, 2014
 *
 * Name:        Joyce Habbouche
 * Course:      1121 X
 * Assignment:  1
 */

public class Bank {
    private Account[] accounts;
    private int size;
    private int capacity;
     
    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;    
    private static final int SENIOR = 0;
    private static final int ADULT = 1;    
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;
    
    /**
     * Class constructor; 
     *
     */
    
    /** Creates a new instance of Bank */
   public Bank() {
      this.accounts = new Account[INIT_CAPACITY];
      this.size = 0;
      this.capacity = INIT_CAPACITY;
    }

    
    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public String addAccount(String customerName, String customerAddress, 
                             int customerAge, String customerPhoneNumber, 
                             int customerType, int typeAccount) {
    if(this.capacity== this.size)
    {
      reallocate() ;
    }
    
    String buffer ;
    buffer = (Integer.toString(this.size+1));
    if(typeAccount== this.SAVINGS)
    {
      if(customerType==this.SENIOR)
      {
        Senior other = new Senior(customerName,customerAddress ,customerAge ,customerPhoneNumber,(this.size +1) );
        
        SavingsAccount account =  new SavingsAccount(other ,buffer) ;
        accounts[this.size+1] = account ;
      }
      else if(customerType== this.ADULT)
      {
        Adult other  = new Adult(customerName,customerAddress ,customerAge , customerPhoneNumber,(this.size +1)) ;
        SavingsAccount account =  new SavingsAccount(other  ,buffer) ;
        accounts[this.size+1] = account ;
      }
      else if(customerType == this.STUDENT)
      {
        Student other = new Student(customerName,customerAddress ,customerAge ,customerPhoneNumber,(this.size +1));
        SavingsAccount account =  new SavingsAccount(other  ,buffer) ;
        accounts[this.size+1] = account ;
      }
       
      
      
      this.size++ ;
    }
    else if(typeAccount== this.CHECKING) 
    {
       if(customerType==this.SENIOR)
      {
        Senior other = new Senior(customerName,customerAddress ,customerAge ,customerPhoneNumber,(this.size +1) );
        CheckingAccount  account =  new CheckingAccount(other  ,buffer) ;
        accounts[this.size+1] = account ;
       }
      else if(customerType== this.ADULT)
      {
        Adult other  = new Adult(customerName,customerAddress ,customerAge ,customerPhoneNumber,(this.size +1)) ;
        CheckingAccount  account =  new CheckingAccount(other , buffer) ;
        accounts[this.size+1] = account ;
      }
      else if(customerType == this.STUDENT)
      {
        Student other = new Student(customerName,customerAddress ,customerAge , customerPhoneNumber,(this.size +1));
        CheckingAccount  account =  new CheckingAccount(other ,buffer) ;
        accounts[this.size+1] = account ;
      }
      buffer = (Integer.toString(this.size+1)) ;
      
      this.size++ ;
    }
     return(buffer);
    }
    
    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public String makeDeposit(String accountNumber, double amount ) {
      int index = find(accountNumber);
      accounts[index].deposit(amount) ;
      Transaction t = new Transaction(accountNumber, "deposit", amount, "deposit fees");
      accounts[index].newTransaction(t);
      return Double.toString(accounts[index].getBalance()); 
    }
    
    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */    
    public String makeWithdrawal(String accountNumber, double amount){
      int index = find(accountNumber);
      accounts[index].withdrawl(amount);
      Transaction t = new Transaction(accountNumber, "deposit", amount, "deposit fees");
      accounts[index].newTransaction(t);
      return Double.toString(accounts[index].getBalance());       
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */    
    public String getAccount(String accountNumber) {
      int index = find(accountNumber) ;
      return(accounts[index].toString());
      
    }
    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */    
    private int find(String accountNumber) {
       int foo = Integer.parseInt(accountNumber) ;
      return( foo );
    }

 /***********************************************************************


    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    
    
    private void reallocate() {
      Account[] buffer = new Account[this.capacity*2];
     for(int i=0 ; i<this.capacity ;i++)
     {
       buffer[i]= this.accounts[i] ;
     }
      this.accounts = buffer ;
      this.capacity= this.capacity*2 ;
     
    }
}
