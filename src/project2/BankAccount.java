/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance;
	private Lock accessLock;
	private Condition sufficientFunds;
	private int numTransactions;

	public BankAccount()
	{
		balance = 0;
		accessLock = new ReentrantLock();
		sufficientFunds = accessLock.newCondition();
		numTransactions = 0;
	}
	
	public void withdraw() throws InterruptedException{
		int subAmt = Transaction.generateRandNum('w');

		accessLock.lock();
		
		try
		{
			if(subAmt >= 75)
			{
				System.out.println(" * * * Flagged Transaction - Withdrawal Agent: A withdrawal In Excess of $75 * * * ");
			}
			else if(balance > subAmt)
			{
				balance -= subAmt;
				System.out.printf("\t\t\t\tAgent W%s withdraws $%-3d\t            Balance is $%-3d\n", Thread.currentThread().getName(), subAmt, balance);
			}
			else
			{
				while(balance < subAmt)
				{
					System.out.printf("\t\t\t\tAgent W%s withdraws $%-3d\t        WITHDRAWAL BLOCKED- INSUFFICIENT FUNDS\n", Thread.currentThread().getName(), subAmt);
	                sufficientFunds.await();
				}
			}
		}
		finally
		{
			accessLock.unlock();
			numTransactions += 1;
		}
	}
	
	public void deposit()
	{
		int addAmt = Transaction.generateRandNum('d');
		//System.out.println("Current balance: " + balance);
		//System.out.println("Current withdrawal amount: " + addAmt);
		accessLock.lock();
		try
		{
			if(addAmt >= 350)
			{
				System.out.println(" * * * Flagged Transaction - Depositor Agent: A deposit In Excess of $350* * * ");
			}
			else
			{
				balance += addAmt;
				System.out.printf("Agent D%s deposits $%-3d\t\t\t\t\t\tBalance is $%-3d\n", Thread.currentThread().getName(), addAmt, balance);
		        sufficientFunds.signalAll();
			}
			
		}
		finally
		{
			accessLock.unlock();
			numTransactions += 1;
		}
	}
	
	public void audit()
	{
		accessLock.lock();
		System.out.println(" * * * Flagged Transaction - Depositor Agent: A deposit In Excess of $10,000* * * ");
		try
		{
			System.out.println("****************************************************************************");
			System.out.println("\t\tAUDIT FINDS CURRENT BALANCE TO BE: $" + balance + "\t\t\tNumber of transactions since last audit: " + numTransactions);
			System.out.println("****************************************************************************");
		}
		finally
		{
			accessLock.unlock();
			numTransactions = 0;
		}
	}
			
}
