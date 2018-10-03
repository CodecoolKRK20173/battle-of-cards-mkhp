import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;


public class PlayerController{
    private List<Player> players;
    public PlayerController(List<Player> players){
        this.players = new ArrayList<Player>();
    }
    public List<Player> getPlayers(){
        return this.players;
    }
    public void addPlayer(Player newPlayer){
        players.add(newPlayer);
    }
    public Integer findDealer(List<Player> players){
        int whoIsDealer = 0;
        return whoIsDealer;
    }
    public Integer dealerChooseParam(){ 
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Enter param: ");
            int chosenParam = in.nextInt();
            return chosenParam;
        } catch (InputMismatchException e){
            System.out.println("Please enter valid number");
        }  finally {
            in.close();
        }
        return null;

    }

    public void nextDealer(Integer whoIsDealer){
        if (whoIsDealer < players.size()){
            whoIsDealer++;
        }
        else if (whoIsDealer == players.size()){
            whoIsDealer =0;
        }
    }

    public List<Card> playCard(List<Player> players){
        List<Card> playedCards = new ArrayList<>();
        for (Player player:players){
            playedCards.add(player.getHand().get(0));
            player.getHand().remove(0);
        }
        return playedCards;
    }

    public boolean isEmpty(){
        boolean isEmpty = false;
        for (int i=0; i < players.size(); i++){
            if(players.get(i).getHand().size()==0){
                isEmpty = true;
            }
        }
        return isEmpty;
    }
    public void endGame(){
        if (isEmpty() == true){
            System.out.println("end game");
        }
    }
    


}