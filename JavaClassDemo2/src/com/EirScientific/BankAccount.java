package com.EirScientific;

/**
 * Created by Terry Song on 09/07/2017.
 */
public class BankAccount {

	private String account_number;
	private double account_balance;
	private String customer_given_name;
	private String customer_surname;
	//private String customer_name;
	private String customer_email1;
	private String customer_phone1;

	/* Constructors */
	public BankAccount()
	{
		// Default class constructor, use default values
		// call overloaded constructor
		this("0000000000", 0.0, "Given name", "Surname", "customer@address.co.uk", "2223335555");
	}

	public BankAccount(String account_number, double account_balance,
					   String customer_given_name, String customer_surname,
					   String  customer_email1, String customer_phone1)
	{
		this.account_number = account_number;
		this.account_balance = account_balance;
		this.customer_given_name = customer_given_name;
		this.customer_surname = customer_surname;
		this.customer_email1 = customer_email1;
		this.customer_phone1 = customer_phone1;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	public void setCustomer_given_name(String customer_given_name) {
		this.customer_given_name = customer_given_name;
	}

	public void setCustomer_surname(String customer_surname) {
		this.customer_surname = customer_surname;
	}

	public void setCustomer_email1(String customer_email1) {
		this.customer_email1 = customer_email1;
	}

	public void setCustomer_phone1(String customer_phone1) {
		this.customer_phone1 = customer_phone1;
	}

	public String getAccount_number() {
		return this.account_number;
	}

	public double getAccount_balance() {
		return this.account_balance;
	}

	public String getCustomer_given_name() {
		return this.customer_given_name;
	}

	public String getCustomer_surname() {
		return this.customer_surname;
	}

	public String getCustomer_name() {
		return this.customer_given_name + " " + this.customer_surname;
	}

	public String getCustomer_email1() {
		return this.customer_email1;
	}

	public String getCustomer_phone1() {
		return this.customer_phone1;
	}

	public void MakeDeposit(double deposit)
	{
		if (deposit > 0)
		{
			this.account_balance += deposit;
			System.out.println(deposit + " is successfully deposited.");
		}
		else
		{
			System.out.println("Deposit amount cannot be less than 0");
		}
	}

	public void MakeWithdraw(double withdraw)
	{
		if (withdraw > 0)
		{
			if (this.account_balance > withdraw)
			{
				this.account_balance -= withdraw;
				System.out.println(withdraw + " is successfully withdrawn.");
			}
			else
			{
				System.out.println("Insufficient fund");
			}
		}
		else
		{
			System.out.println("Withdraw amount cannot be less than 0");
		}
	}
}
