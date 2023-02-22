/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

public class Withdrawal implements Runnable{
	
	public static int WITHDRAW_SLEEP_TIME = 500;
	private BankAccount bankAccount;
	
	public Withdrawal(BankAccount mainBankAccount)
	{
		bankAccount = mainBankAccount;
	}
	
	public void run()
	{
		//System.out.println("Starting withdrawal thread");
		try
		{
			while(true)
			{
				//System.out.println("Entering infinite withdrawal loop!");
				bankAccount.withdraw();
				Thread.sleep(WITHDRAW_SLEEP_TIME);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
		
}
