import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TODO need to parse list of LOCM cards into a kv pair of dictionaries
//TODO make this store at at most if poss uid, iid and sequence of modifications to card instance
public class Card {


    private static Map<Integer, Card> cardList = new HashMap<>();

    public static void main(String[] args)
    {
        Card.loadCards();
    }

    public static void loadCards() {
        try(BufferedReader in = new BufferedReader(new FileReader("res/cardlist.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] stringSplits = str.split(" ; ");
                for(String s : stringSplits) { System.out.println(s); }
                int cardId = Integer.parseInt(stringSplits[0]);
                Card card = new Card();
                switch (stringSplits[2]) {
                    case "creature":
                        card.cardType = 0;
                        break;
                    case "itemGreen":
                        card.cardType = 1;
                        break;
                    case "itemRed":
                        card.cardType = 2;
                        break;
                    case "itemBlue":
                        card.cardType = 3;
                        break;
                }
                card.cost = Integer.parseInt(stringSplits[3]);
                card.attack = Integer.parseInt(stringSplits[4]);
                card.defense = Integer.parseInt(stringSplits[5]);
                card.abilities = stringSplits[6];
                card.hpChange = Integer.parseInt(stringSplits[7]);
                card.hpChangeEnemy = Integer.parseInt(stringSplits[8]);
                card.cardDraw = Integer.parseInt(stringSplits[9]);
                Card.cardList.put(cardId, card);
                //cardList.put()
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    private int iid;
    private int location;
    private int cardType;
    private int cost;
    private int attack;
    private int defense;
    private String abilities;
    private int hpChange;
    private int hpChangeEnemy;
    private int cardDraw;

    public int getIid() {
        return iid;
    }
    public void setIid(int iid) {
        this.iid = iid;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    public int getCardType() {
        return cardType;
    }
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public String getAbilities() {
        return abilities;
    }
    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }
    public int getHpChange() {
        return hpChange;
    }
    public void setHpChange(int hpChange) {
        this.hpChange = hpChange;
    }
    public int getHpChangeEnemy() {
        return hpChangeEnemy;
    }
    public void setHpChangeEnemy(int hpChangeEnemy) {
        this.hpChangeEnemy = hpChangeEnemy;
    }
    public int getCardDraw() {
        return cardDraw;
    }
    public void setCardDraw(int cardDraw) {
        this.cardDraw = cardDraw;
    }
}
