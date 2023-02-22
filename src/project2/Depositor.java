/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

public class Depositor implements Runnable {
	final static int DEPOSIT_SLEEP_TIME = 7500;
	
	private BankAccount bankAcct;
	
	public Depositor(BankAccount sharedAcct)
	{
		bankAcct = sharedAcct;
	}
	
	public void run()
	{
		//System.out.println("Starting depositor thread");
		try
		{
			while(true)
			{
				//System.out.println("Entering infinite depositor loop!");
				bankAcct.deposit();
				Thread.sleep(DEPOSIT_SLEEP_TIME);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
