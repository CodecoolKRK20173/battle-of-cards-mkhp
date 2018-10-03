import java.util.ArrayList;
import java.util.List;

public class Table {
	
    private List<Card> listOfCards;
    private String dealerParameter;
    
    public Table(){
        this.listOfCards = new ArrayList<>();
      }
      
    public List<Card> getListOfCards(){
        return this.listOfCards;
    }
    
    public String getDealerParameter(){
        return this.dealerParameter;
    }
	
	public void setDealerParameter(String newParameter){
		this.dealerParameter=newParameter;
	}
  
}