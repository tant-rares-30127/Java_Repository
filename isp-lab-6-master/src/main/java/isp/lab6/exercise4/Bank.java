package isp.lab6.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private List<Account> accountList=new ArrayList<>();

    public Bank() {
    }
    
    public String executeTransaction(Transaction transaction){
        System.out.println(transaction.execute());
        return "Tranzactia a fost procesata!";
    } 
    
    public void addAccount(Account account){
        accountList.add(account);
    }
    
    public Account getAccountByCardId(String cardId){
            return this.accountList.stream().filter(acc-> acc.getCard().getCardId().equals(cardId)).findAny().orElse(null);
    }
    
}
