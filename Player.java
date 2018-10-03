import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.Card;

public class Player{
    private String nick;
    private List<Card> hand = new ArrayList<>();
    private boolean isDealer;
    public Player(String nick, boolean isDealer){
        this.isDealer = isDealer;
        this.nick = nick;
    }
    public ArrayList<Card> getHand() {
        return this.hand;
    }
    
    public String getNick() {
        return this.nick;
    }
    public void setIsDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }
    
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}