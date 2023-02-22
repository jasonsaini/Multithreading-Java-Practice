/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

public class TheBank {
	public static void main(String[] args)
	{
		// initialize shared acct
		BankAccount acct = new BankAccount();
		
		// setup headers
	    System.out.printf("Deposit Threads\t\t\tWithdrawl Threads\t\tBaleace\t\t\t\n");
	    System.out.printf("---------------\t\t\t-----------------\t\t---------------\t\t\t\n"); 
	    
	    Depositor depositor = new Depositor(acct);
	    Withdrawal withdrawal = new Withdrawal(acct);
	    Auditor auditor = new Auditor(acct);
	    
	    Thread depositor1 = null, depositor2 = null, depositor3 = null;
	    Thread withdrawal1 = null, withdrawal2 = null, withdrawal3 = null, withdrawal4 = null, withdrawal5 = null;
	    
	    Thread auditor1 = new Thread(auditor, "A1");
	    auditor1.start(); 
	    
	    depositor1 = new Thread(depositor, "D1");
	    depositor2 = new Thread(depositor, "D2");
	    depositor3 = new Thread(depositor, "D3");
	    
	    withdrawal1 = new Thread(withdrawal, "W1"); 
	    withdrawal2 = new Thread(withdrawal, "W2");
	    withdrawal3 = new Thread(withdrawal, "W3");
	    withdrawal4 = new Thread(withdrawal, "W4");
	    withdrawal5 = new Thread(withdrawal, "W5");
	    
	    
	    
	    //System.out.println("Threads created!");
	    
	    depositor1.start();
	    depositor2.start();
	    depositor3.start();
	    
	    //System.out.println("Depositor threads started!");
	    
	    withdrawal1.start();
	    withdrawal2.start();
	    withdrawal3.start();
	    withdrawal4.start();
	    withdrawal5.start();
	    
	    //System.out.println("Withdrawal threads started!");
	    
	    
	}
}
