//TODO need to parse list of LOCM cards into a kv pair of dictionaries
//TODO make this store at at most if poss uid, iid and sequence of modifications to card instance
public class Card {

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
