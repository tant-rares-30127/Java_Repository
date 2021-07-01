
package isp.lab5.exercise1;

public class WithdrawMoney extends Transaction{
    
    public double amount;
    public Account account;

    public WithdrawMoney(double amount, Account account) {
        this.amount = amount;
        this.account=account;
    }

    @Override
    public String execute(){
        String s="";
        this.account.setBalance(this.account.getBalance()-this.amount);
        s="Au fost extrasi "+this.amount+" lei";
        return s;
    }
    
}
