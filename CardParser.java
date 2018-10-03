import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CardParser{

	//private List<Card> deck;
	Document document;
	CardParser(){
		this.document=uploadFile("Cards.xml");
		createDeck(this.document);
//		this.deck=new LinkedList<>();
	
	}
	
	
	public Document uploadFile(String file){
		try{
				File inputFile = new File(file);
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(inputFile);
				return doc;
		}
		catch(Exception e){
		}
		return null;
	}
	
	public LinkedList createDeck(Document doc){
			String a="";
			String b="";
			String c="";
			String d="";
			String cardName="";
			NodeList cardList = doc.getElementsByTagName("Card");
			for(int i=0; i<cardList.getLength(); i++){
				Node card = cardList.item(i);
				Element eCard = (Element) card;
				cardName=eCard.getAttribute("name");
				NodeList statisticList = eCard.getElementsByTagName("Statistic");
				a=statisticList.item(0).getTextContent();
				b=statisticList.item(1).getTextContent();
				c=statisticList.item(2).getTextContent();
				d=statisticList.item(3).getTextContent();
				//this.deck.add(new Card(cardName,a,b,c,d));
				
			System.out.println();
			}
		//return this.deck;
		
	
	}
	
	public static void main(String args[]){
		CardParser a=new CardParser();
	}
	
	
}