import java.util.ArrayList;
import java.util.List;

public class Player{
    private String nick;
    private List<Card> hand = new ArrayList<>();
    private boolean isDealer;
    public Player(String nick){
        this.nick = nick;
    }
    public List<Card> getHand() {
        return this.hand;
    }
    
    public String getNick() {
        return this.nick;
    }
    public void setIsDealer(boolean isDealer) {
        this.isDealer = isDealer;
    }
    
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}