package com.EirScientific;

public class Main {

    public static void main(String[] args) {
	// write your code here
		int myNum = -2;

		/*while (myNum < 105)
		{
			ShowIfEven(myNum);
			myNum++;
		}*/
		ShowOnlyEven(myNum, 108);
    }

    public static void ShowOnlyEven(int start, int stop)
	{
		int myNumber = start;
		int totalEven = 0;
		while (myNumber < stop)
		{
			if (!IsEven(myNumber))
			{
				/* not Even */
				myNumber++;
				continue;	// skip rest of the loop, return to beginning
			}
			System.out.println("Even number: " + myNumber);
			myNumber++;
			totalEven++;
			if (totalEven >= 10)
			{
				System.out.println("More than 10 even number");
				break;	// stop the loop when there is more than 10 even number
			}
		}
		System.out.println("Total even number: " + totalEven);
	}

    public static void ShowIfEven(int targetNum)
	{
		if (IsEven(targetNum))
		{
			System.out.println(targetNum + " is Even");
		}
		else
		{
			System.out.println(targetNum + " isn't an even number");
		}
	}

	public static boolean IsEven(int targetNum)
	{
		/* Evaluate if target number is even */
		if (targetNum > 2)
		{
			int remainder = targetNum % 2;

			if (remainder == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if (targetNum < 2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
