package com.abhishekchamoli;

import java.util.Scanner;

public class Main {
    public static Bank bank = new Bank("State Bank of India");
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("1. TO ADD COSTUMER." + "\n" +
                           "2. TO REMOVE COSTUMER." + "\n" +
                           "3. TO SEARCH COSTUMER." + "\n" +
                           "4. TO PRINT CUSTOMER." + "\n" +
                           "5. TO TRANSFER AMOUNT." + "\n" +
                           "6. TO WITHDRAW AMOUNT." + "\n" +
                           "7. TO QUIT");
        System.out.println();

        boolean quit = false;

        while(!quit){
            System.out.println();
            System.out.print("Enter Your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice){
                case 1:
                    System.out.println();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Mobile Number: ");
                    String mobileNumber = scanner.nextLine();
                    System.out.print("Enter Customer Adhaar Number: ");
                    String adhaarNumber = scanner.nextLine();
                    System.out.print("Enter Customer Address: ");
                    String address = scanner.nextLine();
                    if(bank.addCustomer(new Customer(name,mobileNumber,adhaarNumber,address))){
                        bank.getCustomerInformation(adhaarNumber);
                    }

                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Customer Adhaar Number: ");
                    String adhaarNumberOfCustomer = scanner.nextLine();
                    if(bank.removeCustomer(customerName,adhaarNumberOfCustomer)){
                        System.out.println("NAME : " + customerName + "\n" +
                                           "ADHAAR CARD : " + adhaarNumberOfCustomer + "\n" +
                                "IS REMOVED.");

                    }
                    break;

                case 3:
                    System.out.println("* PRESS 1 TO SEARCH CUSTOMER BY NAME." + "\n" +
                                       "* PRESS 2 TO SEARCH CUSTOMER BY ACCOUNT NUMBER." + "\n");
                    System.out.print("Enter Option To Search : ");
                    int action = scanner.nextInt();

                    switch(action) {
                        case 1:
                            System.out.print("Enter Customer Name : ");
                            String nameOfCustomer = scanner.nextLine();
                            scanner.nextLine();
                            bank.searchCustomer(nameOfCustomer);
                            System.out.println();
                            break;

                        case 2:
                            System.out.print("Enter Customer Account Number : ");
                            long customerAccountNumber = scanner.nextLong();
                            System.out.println();
                            bank.searchCustomer(customerAccountNumber);
                            break;

                    }
                    break;

                case 4:
                    bank.printCustomer();
                    break;

                case 5:
                    System.out.print("Enter Customer Account Number : ");
                    long acccountNumber = scanner.nextLong();
                    System.out.print("Enter Amount To Deposit : ");
                    double amountToDeposit = scanner.nextDouble();
                    bank.deposit(acccountNumber,amountToDeposit);
                    break;

                case 6:
                    System.out.print("Enter Customer Account Number : ");
                    long acccountNumberofCustomer = scanner.nextLong();
                    System.out.print("Enter Amount To WithDraw : ");
                    double amountToWithdraw = scanner.nextDouble();
                    bank.withDraw(acccountNumberofCustomer,amountToWithdraw);
                    break;

                case 7:
                    quit = true;
                    break;


            }
        }
    }
}
