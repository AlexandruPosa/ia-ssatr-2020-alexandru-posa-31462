/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.bank.sim;

/**
 *
 * @author Alex
 */
public class AccountManager {
    
    BankAccount[] accounts = new BankAccount[15];
    
       public void addAccount(BankAccount a) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = a;
                System.out.println("New account added.");
                return;
            }
        }
        System.out.println("No empty position found.");
    }
       
       
       public int getTotalBalance(){
            int totalBalance = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                totalBalance += 0;
            } else {
                totalBalance += accounts[i].getBalance();
            }
        }
        System.out.println("Total balance: " + totalBalance);
        return totalBalance;
    }
       public String displayResults(){
           String results ="";
           for(BankAccount a: accounts){ 
           if(a!=null){
            String line = "Owner="+a.getOwner()+" Balance="+a.getBalance()+"\n";
            results=results+line;
           }
       }
       return results;
   }
       public boolean transferMoney(String fromOwnerName, String toOwnerName, int amount){
           int transactionNumber = 0;
           for(BankAccount a: accounts){
               if (a!=null){
                   if (a.getOwner().equals(fromOwnerName)) {
                       if (a.getBalance()> amount){
                       a.setBalance(a.getBalance() - amount);
                       transactionNumber = transactionNumber + 1;
                       System.out.println("Final Balance for " + a.getOwner()+ " = " + a.getBalance());
                       }else return false;
                   }
                           
               }
           }
           for(BankAccount a: accounts){
               if (a!=null){
                   if (a.getOwner().equals(toOwnerName)) {
                       a.setBalance(a.getBalance() + amount);
                       transactionNumber = transactionNumber + 1;
                       System.out.println("Final Balance for " + a.getOwner()+ " = " + a.getBalance());
                   }
                           
               }
           }
           if (transactionNumber == 2){
               return true;
           }
           return false;
       }
}

