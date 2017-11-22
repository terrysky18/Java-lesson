package com.EirScientific;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void getBalanace_deposit() {
        BankAccount account = new BankAccount("James", "Benson", 1000);
        double balance = account.deposit(200, true);
        assertEquals(1200.00, account.getBalanace(), 0.0001);
    }

    @Test
    void getBalanace_withdraw() {
        BankAccount account = new BankAccount("James", "Benson", 1000);
        double balance = account.withdraw(200, true);
        assertEquals(800.00, account.getBalanace(), 0.0001);
    }

    @Test
    void deposit() {
        BankAccount account = new BankAccount("James", "Benson", 1000);
        double balance = account.deposit(200, true);
        assertEquals(1200.00, balance, 0.0001);
    }

    @Test
    void withdraw() {
        fail("Test not yet implemented");
    }

}