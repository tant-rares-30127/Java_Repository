
package isp.lab5.exercise1;

import java.util.Objects;

public class ChangePin extends Transaction {
    public String oldPin;
    public String newPin;
    public Card card;
 
    public ChangePin(String oldPin, String newPin, Card card) {
        this.oldPin = oldPin;
        this.newPin = newPin;
        this.card=card;
    }
    
    @Override
    public String execute(){
        if (this.oldPin.equals(card.getPin())){
            card.setPin(this.newPin);
            return "Schimbarea pinului a avut loc";
        }
        else return "Pin introdus gresit";
    }
   
}
