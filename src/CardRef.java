import java.io.BufferedReader;
import java.io.FileReader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class CardRef {

    //Special card ref that indicates non-turn player is targeted for attack
    public static final CardRef nonTurnPlayer = new CardRef(-1, -1);


    // acknowledgment: class from this SO answer:
    // https://stackoverflow.com/questions/10234487/storing-number-pairs-in-java
    final int iid;
    final int uid;
    private boolean smmnSickness = true;

    CardRef(int iid, int uid) {
        this.iid=iid;
        this.uid=uid;
    }

    public int getIid() {
        return iid;
    }

    public int getUid() {
        return uid;
    }

    public int getCost() {
        return Card.getCost(uid);
    }

    public int getAttack() {
        return Card.getAttack(uid);
    }

    public int getDefence() {
        return Card.getDefence(uid);
    }

    public int getHpChange() {
        return Card.getHpChange(uid);
    }

    public int getHpChangeEnemy() {
        return Card.getHpChangeEnemy(uid);
    }

    public int getCardDraw() {
        return Card.getCardDraw(uid);
    }

    public void removeSmmnSickness() {
        this.smmnSickness = false;
    }

    public boolean isSmmnSickness() {
        return smmnSickness;
    }

    public boolean isBreakthrough() {
        return Card.isBreakthrough(uid);
    }

    public boolean isGuard() {
        return Card.isGuard(uid);
    }

}
