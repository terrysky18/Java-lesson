package com.EirScientific;

public class Main {

    public static void main(String[] args) {
		for (int i=0; i<1000; i++)
		{
			ShowIfPrime(i);
		}
    }

    public static void ShowIfPrime(int targetNum)
	{
		if (IsPrime(targetNum))
		{
			System.out.println(targetNum + " is Prime");
		}
		else
		{
			System.out.println(targetNum + " isn't a prime number");
		}
	}

	public static boolean IsPrime(int inputVal)
	{
		/* Use For loop to determine if input value is a prime number */
		if (inputVal <= 1)
		{
			return false;
		}
		else
		{
			for (int i=2; i<=inputVal/2; i++)
			{
				if (inputVal % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
}
