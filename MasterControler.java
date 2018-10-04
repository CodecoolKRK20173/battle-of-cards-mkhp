import java.util.ArrayList;
import java.util.List;
public class MasterControler{
	
    private CardController cardController;
    private List<Card> deck;
    private List<Player> players;
    private TableController tableController;
	
	public MasterControler(){
	
		this.cardController= new CardController();
        deck = cardController.getCardParser().getDeck();
        players = cardController.getPlayerController().getPlayers();
        tableController = new TableController();
        
	}
	
	
	public static void main(String[] args){
        boolean playTime = true;
        MasterControler a = new MasterControler();
        a.cardController.shuffleCards(); //tasuje
        System.out.println("pierwsza karta z decku: " + a.deck.get(0).getName()); //pierwsza karta z decku get name 
        System.out.println("mapa statystyk: "+a.deck.get(0).getStats()); // mapa statystyk pierwszej karty
        System.out.println("pierwszy wpisany player: " + a.players.get(0).getNick()); //bierze nick pierwszego wpisanego playera
        a.cardController.sendCardToPlayer(); //tasuje i rozdaje karty graczom
        System.out.println("hand pierwszego gracza: " + a.players.get(0).getHand()); //printuje reke po rozdaniu gracza






        while (playTime){ //warunek dopoki nie jest pusta reka playera
            List<Card> cardsOnTable = a.tableController.getTable().getListOfCards();
            cardsOnTable = a.cardController.getPlayerController().playCard(a.players);
            System.out.println("ilosc kart");
            System.out.println(cardsOnTable);
            a.cardController.getPlayerController().setDealer(a.players);
            String parametrChosen = a.cardController.getPlayerController().dealerChooseParam();
            a.tableController.getTable().setDealerParameter(parametrChosen);
            // int parametrChoosen = Integer.parseInt(parametrChosen);
            // parametrChoosen -=1;
            System.out.println("chosen param : " + parametrChosen);
            int valueOfHighestCard = a.tableController.checkMaxCardParam(cardsOnTable);
            System.out.println("index valueOfHighestCard: " + valueOfHighestCard);
            List<Integer> wonPlayers = new ArrayList<>();
            wonPlayers = a.tableController.checkIfDraw(cardsOnTable, valueOfHighestCard);
            List<Player> wonPlayersList = new ArrayList<>();
            for (int i=0; i<wonPlayers.size(); i++){
                wonPlayersList.add(a.players.get(wonPlayers.get(i)));
            }
            a.tableController.sendCardsToWinner(wonPlayersList, cardsOnTable);
            playTime = !a.cardController.getPlayerController().isEmpty();
            
        }
	}
	
	
}