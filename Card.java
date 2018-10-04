import java.util.Map;
import java.util.HashMap;

public class Card{

    private String type;
    private String procent;
    private String wrapping;
    private String hangover;

    private String name;
    private Map<String, Integer> stats = new HashMap<>();
	
	
	

    public Card(){

    }
    
    public Card(String name, String type, String procent, String wrapping, String hangover){
        this.type = type;
        this.procent = procent;
        this.wrapping = wrapping;
        this.hangover = hangover;
        this.name=name;
        this.stats.put("type", Integer.parseInt(type));
        this.stats.put("procent", Integer.parseInt(procent));
        this.stats.put("wrapping", Integer.parseInt(wrapping));
        this.stats.put("hangover", Integer.parseInt(hangover));
    }
	
	public int getDealerParameter(String key){
        for (Map.Entry<String, Integer> entry : this.stats.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
		return 1000;
    }

    public String getName(){
        return this.name;
    }

    public Map<String, Integer> getStats(){
        return this.stats;
    }

    public Card getCard(Card card){
        return card;
    }
}