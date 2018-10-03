import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class CardController{

    private Card card = new Card();

    public List<Card> shuffleCards(List<Card> deck){
        Collections.shuffle(deck);
        return deck;
    }

    public void deleteCard(List<Card> cards){
        cards.remove(cards.size() - 1);
    }

    public void sendCardToPlayer(Card card, Player player){
        List<Card> shuffledCardsList = shuffleCards(deck);
        // TO DO
    }

    public int getDealerParameter(String key){
        for (Entry<String, Integer> entry : card.getStats().entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
    }


}