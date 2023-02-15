package project2;

public class Withdrawal implements Runnable{

	private BankAccount bankAccount;
	
	public Withdrawal(BankAccount mainBankAccount)
	{
		bankAccount = mainBankAccount;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				bankAccount.withdraw();
				Thread.sleep(5);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
		
}
