package com.EirScientific;

public class Main {

    public static void main(String[] args) {
	    int caseVal_1 = 1;
	    int caseVal_2 = 2;

	    int switchVal = 4;

		SwitchNumber(switchVal);
		SwitchString("Zulu");
    }

    public static void SwitchNumber(int switchValu)
	{
		/* example when case value is integer liberal */
		switch(switchValu)
		{
			case 1:
			{
				System.out.println("value = " + 1);
				break;
			}
			case 2:
			{
				System.out.println("value = " + 2);
				break;
			}
			case 3:case 4:case 5:
		{
			System.out.println("the value is " + switchValu);
			break;
		}
			default:
			{
				System.out.println("value not found");
				break;
			}
		}
	}

	public static void SwitchString(String switchVal)
	{
		/* example when case value is string */
		switch(switchVal)
		{
			case "Alpha":
			{
				System.out.println("value = " + "Alpha");
				break;
			}
			case "Bravo":
			{
				System.out.println("value = " + "Bravo");
				break;
			}
			case "Charlie":case "Delta":case "Echo":
		{
			System.out.println("the value is " + switchVal);
			break;
		}
			default:
			{
				System.out.println("value not found");
				break;
			}
		}
	}
}
