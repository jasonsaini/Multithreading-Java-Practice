package project2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance;
	private Lock accessLock;
	private Condition sufficientFunds;


	public BankAccount()
	{
		balance = 0;
		accessLock = new ReentrantLock();
		sufficientFunds = accessLock.newCondition();
	}
	
	public void deposit()
	{
		int add = randTransaction.newNumber(true);
	}
			
}
