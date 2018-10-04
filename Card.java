import java.util.Map;
import java.util.HashMap;

public class Card{

    private String volumen;
    private String procent;
    private String yearbook;
    private String hangover;

    private String name;
    private Map<String, Integer> stats = new HashMap<>();
	
    public Card(){

    }
    
    public Card(String name, String volumen, String procent, String yearbook, String hangover){
        this.volumen = volumen;
        this.procent = procent;
        this.yearbook = yearbook;
        this.hangover = hangover;
        this.name=name;
        this.stats.put("volumen", Integer.parseInt(volumen));
        this.stats.put("procent", Integer.parseInt(procent));
        this.stats.put("yearbook", Integer.parseInt(yearbook));
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