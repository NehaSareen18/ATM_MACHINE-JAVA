

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input=new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");

    //Set the customer number
    public int setCustomerNumber(int customerNumber){
        this.customerNumber=customerNumber;
        return customerNumber;
    }
    // Get the customer number
    public int getCustomerNumber(){
        return customerNumber;
    }    

    //Set the pin number

    public int setPinNumber(int pinNumber){
        this.pinNumber=pinNumber;
        return pinNumber;
    }

    //Get the pin number

    public int getPinNumber(){
        return pinNumber;
    }

    //Get Checking  Account Balance
    
    public double getCheckingBalance(){
        return checkingBalance;
    }

    //Get Saving Account Balance

    public double getSavingBalance(){
        return savingBalance;
    }

    //Calculating Checking Account withdrawal

    public double calcCheckingWithdraw(double amount){
        checkingBalance=(checkingBalance - amount);
        return checkingBalance;
    }

    //Calculating Saving Account withdrawal
    public double calcSavingWithdraw(double amount){
        savingBalance= (savingBalance - amount);
        return savingBalance;
    }

    //Calculating Checking Account deposit

    public double calcCheckingDeposit(double amount){
        checkingBalance=(checkingBalance + amount);
        return checkingBalance;
    }

    //checking saving Account deposit

    public double calcSavingDeposit(double amount){
        savingBalance=(savingBalance + amount);
        return savingBalance;
    }

    //customer checking Account Withdraw input

    public void getCheckingWithdrawInput(){
        System.out.println("checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount= input.nextDouble();

        if((checkingBalance -amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance:"+ moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Balance cannot be negative."+"\n");
        }
    }

    // customer Saving Account Withdraw input

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance :"+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account : ");
        double amount= input.nextDouble();

        if((savingBalance- amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Saving Account balance: "+ savingBalance+"\n");
        }else{
            System.out.println("Balance cannot be negative"+"\n");
        }
    }

    // Customer Checking Account Deposit input

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance : "+ moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit from Checking Account: ");
        double amount= input.nextDouble();

        if((checkingBalance+amount )>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account balance: "+ moneyFormat.format(checkingBalance));
        }else{
            System.out.println("Balance cannot be negative. "+"\n");
        }
    }

    //Customer Saving Account Deposit input

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from Saving Account: ");
        double amount=input.nextDouble();

        if((savingBalance + amount)>=0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: "+ moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance cannot be negative."+ "\n");
        }
    }

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance=0; 
    private double savingBalance=0;

}
