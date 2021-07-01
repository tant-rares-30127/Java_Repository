
package isp.lab5.exercise1;

public class CheckMoney extends Transaction {

    public Account account;

    public CheckMoney(Account account) {
        this.account = account;
    }
    
    @Override
    public String execute(){
        return "Aveti in cont "+this.account.getBalance();
    }
}
