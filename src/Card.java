import java.util.HashMap;
import java.util.Map;

//TODO 4 need to parse list of LOCM cards into a kv pair of dictionaries
//TODO 5 make this store at at most if poss uid, iid and sequence of modifications to card instance
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

    public static Card getFromCardDb(int uid) {
        //to be written in future and committed in another branch.
        //just to make IDE stop complaining. do not merge into master
        return new Card();
    }
}
