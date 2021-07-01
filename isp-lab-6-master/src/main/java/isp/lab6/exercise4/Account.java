package isp.lab6.exercise4;

public class Account {
    
    private String owner;
    private double balance;
    private Card card;

    public Account(String owner, double balance, Card card) {
        this.owner = owner;
        this.balance = balance;
        this.card = card;
    }
    
    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    public Card getCard() {
        return card;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    
}
