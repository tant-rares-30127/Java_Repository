
package isp.lab6.exercise4;

public class ATM {
    
    private Card card;
    private Account account;
    private Bank bank;

    public ATM(Bank bank) {
        this.bank=bank;
    }
    
    
    public boolean insertCard(Card card, String pin){
        if (pin.equals(card.getPin())){
            this.card=card;
            this.account=this.bank.getAccountByCardId(card.getCardId());
            return true;
        }
        else return false;
    }
    
    public void checkMoney(){
        CheckMoney check=new CheckMoney(this.account);
        System.out.println(this.bank.executeTransaction(check));
//        System.out.println(check.execute());
    }
    
    public void withdraw(double amount){
        WithdrawMoney withdraw=new WithdrawMoney(amount, account);
        System.out.println(this.bank.executeTransaction(withdraw));
//        System.out.println(withdraw.execute());
    }
    
    public void changePin(String oldPin, String newPin){
        ChangePin change=new ChangePin(oldPin,newPin,this.card);
        System.out.println(this.bank.executeTransaction(change));
//        System.out.println(change.execute());
    }
    
    public void removeCard(){
        this.card=null;
    }
    
}
