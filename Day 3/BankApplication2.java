import java.io.IOException;
import java.util.Scanner;

public class BankApplication2{
    public static void main(String[] args) {
        Account accountList[] = new Account[3];
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter account names and balances");
            for (int i = 0; i < accountList.length; i++) {
                String name = sc.next();
                double bal = sc.nextDouble();
                accountList[i]= new Account(bal, name);
            }

            boolean online = true;
            while (online) {
                System.out.println("enter your name");
                String name= sc.next();
                Account customer = Account.searchAccount(accountList, name);
                double amt = sc.nextDouble();
                System.out.println(customer.withdraw(amt)? "Withdraw succefull" : "not enough balance");
                System.out.println("press 1 to go offline");
                online = !(sc.nextInt() == 1);
            }
        } catch(NullPointerException e){
            System.err.println("Account not found");
        } catch(IOException e){
            System.err.println("amount is more than balance");
        }
    }
    
}

class Account{
    
    private double balance;
    public String accountHolderName;

    public Account(double balance, String accountHolderName) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amt)throws IOException{
        if(this.getBalance()> amt){
            this.balance-=amt;
            return true;
        }
        throw(new IOException());
        
    }
    public static Account searchAccount(Account accountList[], String name){
        for (Account account : accountList) {
            if (account.accountHolderName.equals(name))
                return account;
        }

        return null;
    }
}
