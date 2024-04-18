/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem01;

/**
 * Represents a bank account.
 */
public class Account {
    private String name;
    private String accnum;
    private double balance;
    private String passcode;

    //@ invariant balance >= 0.0;
    //@ invariant name != null && accnum != null && passcode != null;

    //@ ensures balance == 0.0;
    //@ ensures name != null && accnum != null && passcode != null;
    public Account() {
        this.name = "";
        this.accnum = "";
        this.balance = 0.0;
        this.passcode = "";
    }

    //@ requires name != null && accnum != null && passcode != null;
    //@ ensures this.name.equals(name) && this.accnum.equals(accnum) && this.balance == balance && this.passcode.equals(passcode);
    public Account(String name, String accnum, double balance, String passcode) {
        this.name = name;
        this.accnum = accnum;
        this.balance = balance;
        this.passcode = passcode;
    }

    //@ requires amount >= 0;
    //@ ensures balance == \old(balance + amount);
    //@ ensures \result ==> (balance >= \old(balance));
    public void deposit(double amount) {
        assert amount >= 0 : "Amount to deposit should be non-negative";
        double newBalance = balance + amount;
        assert newBalance >= balance : "Balance should not decrease during deposit";
        balance = newBalance;
    }

    //@ requires amount >= 0 && amount <= balance;
    //@ ensures balance == \old(balance - amount);
    //@ ensures \result ==> (balance <= \old(balance));
    public void withdraw(double amount) {
        assert amount >= 0 : "Amount to withdraw should be non-negative";
        assert amount <= balance : "Withdrawal amount should not exceed balance";
        double newBalance = balance - amount;
        assert newBalance <= balance : "Balance should not increase during withdrawal";
        balance = newBalance;
    }

    //@ ensures \result == name;
    public String getName() {
        return name;
    }

    //@ ensures \result == accnum;
    public String getAccnum() {
        return accnum;
    }

    //@ ensures \result == balance;
    public double getBalance() {
        return balance;
    }

    //@ ensures \result == passcode;
    public String getPasscode() {
        return passcode;
    }

    //@ requires name != null;
    //@ ensures this.name.equals(name);
    public void setName(String name) {
        this.name = name;
    }

    //@ requires accnum != null;
    //@ ensures this.accnum.equals(accnum);
    public void setAccnum(String accnum) {
        this.accnum = accnum;
    }

    //@ ensures this.balance == balance;
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //@ requires passcode != null;
    //@ ensures this.passcode.equals(passcode);
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }
}

