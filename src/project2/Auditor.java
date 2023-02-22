/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

public class Auditor implements Runnable {
	final static int AUDIT_SLEEP_TIME = 7500 ;
	
	private BankAccount bankAcct;
	
	public Auditor(BankAccount sharedAcct)
	{
		bankAcct = sharedAcct;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(AUDIT_SLEEP_TIME);
				bankAcct.audit();
				Thread.sleep(AUDIT_SLEEP_TIME);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
