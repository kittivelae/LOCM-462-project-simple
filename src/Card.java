import java.util.HashMap;
import java.util.Map;


public class Card {

    private static final Map<Integer, Float> costWeights = new HashMap<>() {
        {
            put(0, 0.9f);
            put(1, 1.2f);
            put(2, 1.1f);
            put(3, 1.0f);
            put(4, 0.9f);
            put(5, 0.8f);
            put(6, 0.7f);
            put(7, 0.6f);
            put(8, 0.4f);
            put(9, 0.4f);
            put(10, 0.2f);
            put(11, 0.2f);
            put(12, 0.2f);
        }

    };

    public static float getCostWeighting(int cost) {
        return Card.costWeights.get(cost);
    }


    /*private static Map<Integer, Card> cardList = new HashMap<>();

    public static void main(String[] args)
    {
        Card.loadCards();
    }

    public static void loadCards() {
        try(BufferedReader in = new BufferedReader(new FileReader("res/cardlist.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String[] stringSplits = str.split(" ; ");
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
    }*/

    private int uid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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
