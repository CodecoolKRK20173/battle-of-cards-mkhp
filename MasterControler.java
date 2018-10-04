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
    
    public void runGame(MasterControler a){
        boolean playTime = true;
        int max=0;
        int winner=0;
        a.cardController.shuffleCards();
        a.cardController.sendCardToPlayer();

        while (playTime){
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