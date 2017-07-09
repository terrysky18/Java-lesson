package com.EirScientific;

public class Main {

    public static void main(String[] args) {
		BankAccount account1 = new BankAccount();

		account1.setCustomer_given_name("James");
		account1.setCustomer_surname("Bond");
		account1.setCustomer_email1("james.bond@sis.co.uk");
		account1.setAccount_number("8866742159");
		account1.setCustomer_phone1("+44(0)3083659950");
		account1.setAccount_balance(28563.37);

		System.out.println(account1.getCustomer_name());
		System.out.println(account1.getCustomer_email1());
		System.out.println(account1.getAccount_number());
		System.out.println(account1.getCustomer_phone1());
		System.out.println(account1.getAccount_balance());

		//account1.MakeDeposit(10000);
		System.out.println(account1.getAccount_balance());

		account1.MakeWithdraw(500000);
		System.out.println(account1.getAccount_balance());

		BankAccount account2 = new BankAccount("7682904729", 1039.20,
												"John", "Ashcroft",
												"john.ashcroft@sis.co.uk", "+44(0)8902342265");

		VipCustomer customer1 = new VipCustomer("Terry Song", "terry.song@sis.co.uk");
		System.out.println(customer1.getCustomer_name());
		System.out.println(customer1.getCredit_limit());
		System.out.println(customer1.getCustomer_email1());

		VipCustomer customer2 = new VipCustomer();
	}
}
