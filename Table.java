import java.util.ArrayList;
import java.util.List;

public class Table {
	
    private List<Card> listOfCards;
    private String dealerParameter;
    
    public Table(String dealerParameter){
        this.listOfCards = new ArrayList<>();
        this.dealerParameter = dealerParameter;
      }
      
    public List<Card> getListOfCards(){
        return this.listOfCards;
    }
    
    public String getDealerParameter(){
        return this.dealerParameter;
    }
  
}