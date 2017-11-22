package com.EirScientific;

public class BankAccount {

    private String christian_name;
    private String surname;
    private double balanace;

    public BankAccount(String christian_name, String surname, double balanace) {
        this.christian_name = christian_name;
        this.surname = surname;
        this.balanace = balanace;
    }

    public String getChristian_name() {
        return christian_name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalanace() {
        return balanace;
    }

    /**
     * Branch parameter is true if transaction is done at a branch with a teller
     * It's false if transaction is done on an ATM
     */
    public double deposit(double amount, boolean branch)
    {
        balanace += amount;
        return balanace;
    }

    /**
     * Branch parameter is true if transaction is done at a branch with a teller
     * It's false if transaction is done on an ATM
     */
    public double withdraw(double amount, boolean branch)
    {
        balanace -= amount;
        return balanace;
    }
}
