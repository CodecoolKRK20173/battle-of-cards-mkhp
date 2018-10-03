import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class CardController{

    private Card card = new Card();
	private CardParser cardParser = new CardParser();
    private PlayerController playerController = new PlayerController();
    
    public CardController(){

    }
	
    public void shuffleCards(){
        Collections.shuffle(cardParser.getDeck());
        
    }

    public void deleteCard(List<Card> cards){
        cards.remove(cards.size() - 1);
    }
    public CardParser getCardParser(){
        return this.cardParser;
    }
    public PlayerController getPlayerController(){
        return this.playerController;
    }

    public void sendCardToPlayer(){
        shuffleCards();
		List<Player> players = playerController.getPlayers();
		while(cardParser.getDeck().size() != 0){
			for(Player player: players){
                if(cardParser.getDeck().size() > 0){
				player.getHand().add(cardParser.getDeck().get(0));
                cardParser.getDeck().remove(0);
                }

			}
		}
				
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