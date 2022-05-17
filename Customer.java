package com.abhishekchamoli;

import java.util.Objects;

public class Customer {
    private final String name;
    private final String mobileNumber;
    private final String adhaarNumber;
    private final String address;
    private double bankBalance;

    public Customer(String name, String mobileNumber, String adhaarNumber, String address) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.adhaarNumber = adhaarNumber;
        this.address = address;
        this.bankBalance = 0;
    }


    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void deposit(double amount){
        if(amount>0){
            bankBalance+=amount;
        }
    }

    public void withdraw(double amount){
        if(amount>0 && bankBalance>amount){
            bankBalance-=amount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(mobileNumber, customer.mobileNumber) || Objects.equals(adhaarNumber, customer.adhaarNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNumber, adhaarNumber);
    }

    @Override
    public String toString() {
        return  "Name           : " + getName() + "\n" +
                "Phone Number   : " + getMobileNumber() + "\n" +
                "Adhaar Number  : " + getAdhaarNumber() + "\n" +
                "Address        : " + getAddress() + "\n" +
                "Balance        : " + "\u20B9 " + getBankBalance();

    }

}
