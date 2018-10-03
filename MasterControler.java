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
	
        MasterControler a = new MasterControler();
        a.cardController.shuffleCards(); //tasuje
        System.out.println(a.deck.get(0).getName()); //pierwsza karta z decku get name 
        System.out.println(a.deck.get(0).getStats()); // mapa statystyk pierwszej karty
        System.out.println(a.players.get(0).getNick()); //bierze nick pierwszego wpisanego playera
        a.cardController.sendCardToPlayer(); //tasuje i rozdaje karty graczom
        System.out.println(a.players.get(0).getHand()); //printuje reke po rozdaniu gracza






        while (!a.players.isEmpty()){ //warunek dopoki nie jest pusta reka playera
            List<Card> cardsOnTable = a.tableController.getTable().getListOfCards();
            cardsOnTable = a.cardController.getPlayerController().playCard(a.players);
            System.out.println("dupa");
        }
	}
	
	
}