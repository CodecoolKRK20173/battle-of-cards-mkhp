import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.smartcardio.Card;

public class TableController {

    public int checkMaxCardParam(List<Card> listOfCards){
        List<Integer> checkingParam = new ArrayList<>();
        for (Card card: listOfCards){
            checkingParam.add(card.getDealerParameter(dealerParameter));
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
            if (card.getDealerParameter(dealerParameter) == maxParam){
                wonPlayers.add(i);
            }
        }
        return wonPlayers;
    }
  
    public void collectCardsByWinner(){

    }
}


/*

https://stackoverflow.com/questions/31378324/how-to-find-maximum-value-from-a-integer-using-stream-in-java-8

Optional<Integer> max = list.stream().max(Comparator.naturalOrder());

https://stackoverflow.com/questions/7414667/identify-duplicates-in-a-list (odp z 10 pkt)

*/