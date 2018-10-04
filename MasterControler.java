import java.util.ArrayList;
import java.util.List;
public class MasterControler{
	
    private CardController cardController;
    private List<Card> deck;
    private List<Player> players;
    private TableController tableController;
    private View view;

	public MasterControler(){

        this.view = new View();
		this.cardController= new CardController();
        deck = cardController.getCardParser().getDeck();
        players = cardController.getPlayerController().getPlayers();
        tableController = new TableController();
        
	}
	
	
	public static void main(String[] args){
        boolean playTime = true;
        int max=0;
        int winner=0;
        MasterControler a = new MasterControler();
        a.cardController.shuffleCards(); //tasuje
      //  System.out.println("pierwsza karta z decku: " + a.deck.get(0).getName()); //pierwsza karta z decku get name 
      //  System.out.println("mapa statystyk: "+a.deck.get(0).getStats()); // mapa statystyk pierwszej karty
       // System.out.println("pierwszy wpisany player: " + a.players.get(0).getNick()); //bierze nick pierwszego wpisanego playera
        a.cardController.sendCardToPlayer(); //tasuje i rozdaje karty graczom
      //  System.out.println("hand pierwszego gracza: " + a.players.get(0).getHand()); //printuje reke po rozdaniu gracza






        while (playTime){ //warunek dopoki nie jest pusta reka playera
            List<Card> cardsOnTable = a.tableController.getTable().getListOfCards();
            cardsOnTable = a.cardController.getPlayerController().playCard(a.players);
            System.out.print("\033[H\033[2J");
            for(int j = 0; j<cardsOnTable.size(); j++){
                System.out.println("Amount of cards in hand: " + a.players.get(j).getHand().size());
                System.out.println(a.players.get(j).getNick());
                System.out.print(a.view.createCardDesign(cardsOnTable.get(j)));
            }
            a.cardController.getPlayerController().setDealer(a.players);
            String parametrChosen = a.cardController.getPlayerController().dealerChooseParam();
            a.tableController.getTable().setDealerParameter(parametrChosen);
            int valueOfHighestCard = a.tableController.checkMaxCardParam(cardsOnTable);
            List<Integer> wonPlayers = new ArrayList<>();
            wonPlayers = a.tableController.checkIfDraw(cardsOnTable, valueOfHighestCard);
            List<Player> wonPlayersList = new ArrayList<>();
            for (int i=0; i<wonPlayers.size(); i++){
                wonPlayersList.add(a.players.get(wonPlayers.get(i)));
            }
            a.tableController.sendCardsToWinner(wonPlayersList, cardsOnTable);
            playTime = !a.cardController.getPlayerController().isEmpty();

            
        }

        for(int i=0; i<a.players.size();i++){
            if(a.players.get(i).getHand().size()>max){
                max=a.players.get(i).getHand().size();
                winner = i;
            }
        }
        System.out.println("THE WINNER ISSSSSSS...  "+a.players.get(winner).getNick());
	}
	
	
}