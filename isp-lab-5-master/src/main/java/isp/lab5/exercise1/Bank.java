package isp.lab5.exercise1;

public class Bank {
    
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }
    
    public String executeTransaction(Transaction transaction){
        System.out.println(transaction.execute());
        return "Tranzactia a fost procesata!";
    } 
    
    public Account getAccountByCardId(String cardId){
            return this.account;
    }
    
}
