import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class CardController{

    private Card card = new Card();
	private CardParser cardParser = new CardParser();
	
    public void shuffleCards(){
        Collections.shuffle(cardParser.getDeck());
        
    }

    public void deleteCard(List<Card> cards){
        cards.remove(cards.size() - 1);
    }

    public void sendCardToPlayer(Card card, Player player){
        shuffleCards();
        // TO DO
    }

    public int getDealerParameter(String key){
        for (Map.Entry<String, Integer> entry : card.getStats().entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
		return 0;
    }


}