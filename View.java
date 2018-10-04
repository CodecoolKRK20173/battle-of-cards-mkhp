import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Formatter;

public class View{

    private CardParser cardParser = new CardParser();
    private String total = "";

    public StringBuilder createDashes(int scope, String sign){
        StringBuilder nazwa = new StringBuilder();
        for (int i = 0; i < scope+1; i++) {
            nazwa.append(sign);
        }
        return nazwa;
    }

    public StringBuilder createSpaces(int scope, String name, String sign){
        StringBuilder nazwa = new StringBuilder();
        for(int i=0; i<scope+1-name.length(); i++){
            nazwa.append(sign);
        }
        return nazwa;
    }

    public StringBuilder createSpacesForName(String sign){
        StringBuilder nazwa = new StringBuilder();
        for(int i=0; i<14; i++){
            nazwa.append(sign);
        }
        return nazwa;
    }

    public String createCardDesign(){
        List<Card> deck = cardParser.getDeck();
        
        int maxName = "name".length();   
        int maxVolumen = "volumen".length();
        int maxProcent = "procent".length();
        int maxYearbook = "yearbook".length();
        int maxHangover = "hangover".length();
        int maxAttributes = "attributes".length();

        List<Integer> maxLengthList = new ArrayList<>();
        maxLengthList.add(maxName);
        maxLengthList.add(maxVolumen);
        maxLengthList.add(maxProcent);
        maxLengthList.add(maxYearbook);
        maxLengthList.add(maxHangover);
        maxLengthList.add(maxAttributes);

        int maxLengthFromList = Collections.max(maxLengthList);
        
        // System.out.println(maxLengthFromList);

        StringBuilder typeDashes = createDashes(maxLengthFromList, "-");
        StringBuilder powerDashes = createDashes(5, "-");

        StringBuilder headerAttributes = createSpaces(maxLengthFromList, "Attributes", " ");
        StringBuilder headerPower = createSpaces(5, "Power", " ");

        StringBuilder headerName = createSpacesForName(" ");



        // StringBuilder firstLineOfHeader = new StringBuilder();
        // firstLineOfHeader.append("+" + typeDashes + "-" + powerDashes + "+");

        StringBuilder secondLineOfHeader = new StringBuilder();
        secondLineOfHeader.append(deck.get(0).getName());

        StringBuilder thirdLineOfHeader = new StringBuilder();
        thirdLineOfHeader.append("+" + typeDashes + "-" + powerDashes + "+");

        StringBuilder fourthLineOfHeader = new StringBuilder();
        fourthLineOfHeader.append("|" + headerAttributes + "Attributes" + "|" + headerPower + "Power" + "|");

        StringBuilder fifthLineOfHeader = new StringBuilder();
        fifthLineOfHeader.append("|" + typeDashes + "+" + powerDashes + "|");

        // System.out.println(firstLineOfHeader);
        System.out.println(secondLineOfHeader);
        System.out.println(thirdLineOfHeader);
        System.out.println(fourthLineOfHeader);
        System.out.println(fifthLineOfHeader);





        //for(int i=0; i<deck.size(); i++){
        total = "";

        String leftAlignFormat = "|%-" + maxLengthFromList + "s | %-" + 5 + "s|%n";

        Formatter formatter = new Formatter();
        formatter.format(leftAlignFormat, "Volumen", deck.get(0).getStats().get("volumen"));
        String finalText = formatter.toString();

        Formatter formatter2 = new Formatter();
        formatter2.format(leftAlignFormat, "Procent", deck.get(0).getStats().get("procent"));
        String finalText2 = formatter2.toString();

        Formatter formatter3 = new Formatter();
        formatter3.format(leftAlignFormat, "Yearbook", deck.get(0).getStats().get("yearbook"));
        String finalText3 = formatter3.toString();

        Formatter formatter4 = new Formatter();
        formatter4.format(leftAlignFormat, "Hangover", deck.get(0).getStats().get("hangover"));
        String finalText4 = formatter4.toString();


        StringBuilder lastLineTable = new StringBuilder();
        lastLineTable.append("|" + typeDashes + "+" + powerDashes + "|"); 

        StringBuilder endLine = new StringBuilder();
        endLine.append("+" + typeDashes + "+" + powerDashes + "+");
        
        total += finalText + lastLineTable.toString() + "\n" + finalText2 + lastLineTable.toString() + "\n" + finalText3 + lastLineTable.toString() + "\n" +
                 finalText4 + endLine.toString();

        // for(int i=0; i<deck.size(); i++){

        //     String leftAlignFormat = "|%-" + maxLengthFromList + "s | %-" + 5 + "s|%n";

        //     Formatter formatter = new Formatter();
        //     formatter.format(leftAlignFormat, "Volumen", deck.get(0).getStats().get("volumen"));
        //     String finalText = formatter.toString();

        //     StringBuilder lastLineTable = new StringBuilder();
        //     lastLineTable.append("|" + typeDashes + "+" + powerDashes + "|"); 
            
        //     total += finalText + lastLineTable.toString() + "\n";
        // }
        return total;
    }

    public static void main(String[] args){
        View view = new View();

        System.out.print(view.createCardDesign());


    }
}