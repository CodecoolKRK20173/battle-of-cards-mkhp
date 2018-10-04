import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableController {
	private Table table;
	
	
	public TableController(){
		this.table = new Table();
    }
    public Table getTable(){
        return this.table;
    }

    public int checkMaxCardParam(List<Card> listOfCards){
        List<Integer> checkingParam = new ArrayList<>();
        for (Card card: listOfCards){
            checkingParam.add(card.getDealerParameter(table.getDealerParameter()));
        }
        int maxParam = 0;
        for (int i = 0; i < checkingParam.size(); i++){
            if (checkingParam.get(i) > maxParam){
                maxParam = checkingParam.get(i);
            }
        }
        return maxParam;
    }

    public List<Integer> checkIfDraw(List<Card> listOfCards, int maxParam){
        List<Integer> wonPlayers = new ArrayList<>();
        for (int i = 0; i < listOfCards.size(); i++){
            if (listOfCards.get(i).getDealerParameter(table.getDealerParameter()) == maxParam){
                wonPlayers.add(i);
            }
        }
        return wonPlayers;
    }
  
    public void sendCardsToWinner(List<Player> wonPlayers, List<Card> playedCards){
		while(playedCards.size() != 0){
			for(Player player: wonPlayers){
				player.getHand().add(playedCards.get(0));
				playedCards.remove(0);
			}
		}
    }
}


/*

https://stackoverflow.com/questions/31378324/how-to-find-maximum-value-from-a-integer-using-stream-in-java-8

Optional<Integer> max = list.stream().max(Comparator.naturalOrder());

https://stackoverflow.com/questions/7414667/identify-duplicates-in-a-list (odp z 10 pkt)

*/