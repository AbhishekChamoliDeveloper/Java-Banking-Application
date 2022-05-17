package com.abhishekchamoli;

import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private final String name;
    private final Map<Long, Customer>customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new TreeMap<>();
    }

    public boolean addCustomer(Customer newCustomer){
        if(newCustomer!=null){
            long accountNumber = generateAccountNumber();
            for(Customer customer: customers.values()){
                if(customer.equals(newCustomer)){
                    return false;
                }
            }
            customers.put(accountNumber,newCustomer);
            return true;
        }

        return false;
    }

    private long generateAccountNumber(){
       long newAccountNumber = (long) (Math.random()*(999999-100000+1)+100000);
       for(long accountNumber: customers.keySet()){
           if(accountNumber==newAccountNumber){
               newAccountNumber = (long) (Math.random()*(999999-100000+1)+100000);
           }
       }

       return newAccountNumber;
    }

    public boolean removeCustomer(String customerName, String customerAdhaarCard){
        if(customerName!=null && customerAdhaarCard!=null){
            for(long accountNumber: customers.keySet()){
                if(customers.get(accountNumber).getName().equals(customerName) &&
                        customers.get(accountNumber).getAdhaarNumber().equals(customerAdhaarCard)){
                    customers.remove(accountNumber);
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public void searchCustomer(String customerName){
       if(customerName!=null){
           for(long accountNumber: customers.keySet()){
               if(customers.get(accountNumber).getName().equals(customerName)){
                   searchCustomer(accountNumber);
               }
           }
       }
    }

    public void searchCustomer(long customerAccountNumber){
            for(long accountNumber: customers.keySet()){
                if(accountNumber==customerAccountNumber){
                    System.out.println(customers
                    .get(customerAccountNumber).toString());
                }
            }

    }

    public void getCustomerInformation(String adhaarNumber){
        if(adhaarNumber!=null){
            for(long accountNumber: customers.keySet()){
                if(customers.get(accountNumber).getAdhaarNumber().equals(adhaarNumber)){
                    System.out.println();
                    System.out.println(customers.get(accountNumber) + "\n" +
                            "Account Number : " + accountNumber);
                    System.out.println();
                }
            }
        }
    }


    public void printCustomer(){
        System.out.println();
        System.out.println("<===================================>");
        System.out.println();
        for (long accountNumber: customers.keySet()){
            System.out.println(customers.get(accountNumber).toString() + "\n" + "Account Number : " + accountNumber);
            System.out.println();
        }
        System.out.println();
        System.out.println("<====================================>");

    }

    public boolean deposit(long customerAccountNumber, double amount){
        for(long accountNumber: customers.keySet()){
            if(accountNumber==customerAccountNumber){
                customers.get(customerAccountNumber).deposit(amount);
                System.out.println();
                System.out.println("\u20B9 " + amount + " IS CREDIT TO " +  "\n" +
                        "NAME : " + customers.get(customerAccountNumber).getName() + "\n" +
                        "ACCOUNT N0 : " + customerAccountNumber + "\n" +
                        "BANK BALANCE : " + customers.get(customerAccountNumber).getBankBalance());
                System.out.println();;
                return true;
            }
        }

        return false;
    }

    public boolean withDraw(long customerAccountNumber, double amount){
        for(long accountNumber: customers.keySet()){
            if(accountNumber==customerAccountNumber){
                customers.get(customerAccountNumber).withdraw(amount);
                System.out.println();
                System.out.println("\u20B9 " + amount +" IS DEBIT FROM " +  "\n" +
                        "NAME : " + customers.get(customerAccountNumber).getName() + "\n" +
                        "ACCOUNT N0 : " + customerAccountNumber + "\n" +
                        "BANK BALANCE : " + customers.get(customerAccountNumber).getBankBalance());
                System.out.println();
                return true;
            }
        }

        return false;
    }


}
