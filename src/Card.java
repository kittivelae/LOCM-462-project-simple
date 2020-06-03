import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


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

    private static final Map<Integer, Card> cardDb = new HashMap<>() {{
        try (BufferedReader br = new BufferedReader(new FileReader("res/cardlist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ; ");
                put(parseInt(values[0]), new Card(
                        parseInt(values[3]),
                        parseInt(values[4]),
                        parseInt(values[5]),
                        values[6],
                        parseInt(values[7]),
                        parseInt(values[8]),
                        parseInt(values[9])));
            }
        }
    }};

    public static Card getCard(int uid) {
        return cardDb.get(uid);
    }

    public static int getCost(int uid) {
        return getCard(uid).getCost();
    }
    public static int getAttack(int uid) {
        return getCard(uid).getAttack();
    }
    public static int getDefence(int uid) {
        return getCard(uid).getAttack();
    }
    public static boolean isGuard(int uid) {
        return getCard(uid).isGuard();
    }

    public static float getCostWeighting(int cost) {
        return Card.costWeights.get(cost);
    }

    //private int uid;
    //private int iid;
    //private int location;
    //private int cardType;
    private int cost;
    private int attack;
    private int defense;
    private boolean breakthrough = false;
    private boolean guard = false;
    private boolean smmnSickness = true;
    //private String abilities;
    private int hpChange;
    private int hpChangeEnemy;
    private int cardDraw;

    public Card(int cost, int attack, int defense, String abilities, int hpChange, int hpChangeEnemy, int cardDraw) {
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.abilityParse(abilities);
        this.hpChange = hpChange;
        this.hpChangeEnemy = hpChangeEnemy;
        this.cardDraw = cardDraw;
    }

//    public int getUid() {
//        return uid;
//    }
//
//    public void setUid(int uid) {
//        this.uid = uid;
//    }
//
//    public int getIid() {
//        return iid;
//    }
//    public void setIid(int iid) {
//        this.iid = iid;
//    }
//    public int getLocation() {
//        return location;
//    }
//    public void setLocation(int location) {
//        this.location = location;
//    }
//    public int getCardType() {
//        return cardType;
//    }
//    public void setCardType(int cardType) {
//        this.cardType = cardType;
//    }
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
//    public String getAbilities() {
//        return abilities;
//    }
//    public void setAbilities(String abilities) {
//        this.abilities = abilities;
//    }
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

    public void setBreakthrough(boolean hasBreakthrough) {
        this.breakthrough = hasBreakthrough;
    }

    public void setGuard(boolean hasGuard) {
        this.guard = hasGuard;
    }

    public void setSmmnSickness(boolean hasSmmnSickness) {
        this.smmnSickness = hasSmmnSickness;
    }

    public boolean isBreakthrough() {
        return breakthrough;
    }

    public boolean isGuard() {
        return guard;
    }

    public boolean isSmmnSickness() {
        return smmnSickness;
    }

    void abilityParse(String abiltyString) {
        String abiltyRef = "BCGDLW";
        for(int i = 0; i < abiltyString.length(); i++) {
            if(abiltyString.indexOf(abiltyRef.charAt(i)) != -1) {
                switch(i) {
                    case 0:
                        this.setBreakthrough(true);
                        break;
                    case 1:
                        this.setSmmnSickness(false);
                        break;
                    case 2:
                        this.setGuard(true);
                        break;
                }
            }
        }
    }
}

