package isp.lab6.exercise4;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        String cardId="1234567";
        String cardPin="1237";
        Card card = new Card(cardId, cardPin);
        
        String owner="Tant Rares";
        double balance=10000;
        Account account = new Account(owner, balance, card);
        
        Bank bank = new Bank();
        bank.addAccount(account);
        
        ATM atm = new ATM(bank);
        
        System.out.print("Introduceti pinul:");
        String pin=in.nextLine();
        boolean sem=atm.insertCard(card, pin);
        
        if (sem==true) {
            System.out.println("Card introdus cu succes");
            System.out.print("Ce actiune doriti sa faceti: 1 (ChangePin)    2 (WithdrawMoney)   3 (CheckMoney)  4 (RemoveCard) ");
            int x=in.nextInt();
        
            while (x!=4){
                switch(x){
                    case 1:{
                        System.out.print("Introduceti vechiul pin:");
                        in.nextLine();
                        String pinV=in.nextLine();
                        System.out.print("Introduceti noul pin:");
                        String pinN=in.nextLine();
                        atm.changePin(pinV, pinN);
                        break;
                    }
                    case 2:{
                        System.out.print("Ce suma doriti sa retrageti:");
                        double amount=in.nextDouble();
                        atm.withdraw(amount);
                        break;
                    }
                    case 3:{
                        atm.checkMoney();
                        break;
                    }
                    default:{
                        System.out.println("Numar gresit, reincercati");
                    }
                
                }
                System.out.print("Ce actiune doriti sa faceti: 1 (ChangePin)    2 (WithdrawMoney)   3 (CheckMoney)  4 (RemoveCard) ");
                x=in.nextInt();
            }
        }
        else System.out.println("Card nu a fost introdus corect");
        atm.removeCard();
        System.out.println("Card extras cu succes!");
        
    }
}
