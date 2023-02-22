/*
 Name:
 Course: CNT 4714 Spring 2023
 Assignment title: Project 2 -- Synchronized, Cooperating threads Under Locking
 Due Date: February 12, 2023
 */

package project2;

import java.util.Random;

public class Transaction {
	final static int DEPOSIT_RANGE = 500;
	final static int WITHDRAW_RANGE = 99;
	final static int AUDIT_RANGE = 10000;
	
	public static int generateRandNum(char transaction)
	{
		
		int randomNum = 0;
		Random random = new Random();
		if(transaction == 'w')
		{
			randomNum = random.ints(1,WITHDRAW_RANGE).findFirst().getAsInt();
		}
		else if(transaction == 'd')
		{
			randomNum = random.ints(1,DEPOSIT_RANGE).findFirst().getAsInt();
		}
		else if(transaction == 'a')
		{
			randomNum = random.ints(300, 10000).findFirst().getAsInt();
		}
		return randomNum;
	}
	
	public static int randSleepDuration(char transaction)
	{
		Random random = new Random();
		int sleepDur = 0;
		
		if(transaction == 'w')
		{
			sleepDur = random.nextInt(200);
		}
		else if(transaction == 'd')
		{
			sleepDur = random.nextInt(500);
		}
		
		return sleepDur;
	}
}
