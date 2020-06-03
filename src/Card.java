import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;



public class Card {

    private int cost;
    private int attack;
    private final int defence;
    private boolean breakthrough = false;
    private boolean guard = false;
    private boolean smmnSickness = true;
    private int hpChange;
    private int hpChangeEnemy;
    private int cardDraw;

    public Card(int cost, int attack, int defence, String abilities, int hpChange, int hpChangeEnemy, int cardDraw) {
        this.cost = cost;
        this.attack = attack;
        this.defence = defence;
        this.abilityParse(abilities);
        this.hpChange = hpChange;
        this.hpChangeEnemy = hpChangeEnemy;
        this.cardDraw = cardDraw;
    }

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

    public static int getHpChange(int uid) {
        return getCard(uid).hpChange;
    }

    public static int getHpChangeEnemy(int uid) {
        return getCard(uid).hpChangeEnemy;
    }

    public static int getCardDraw(int uid) {
        return getCard(uid).cardDraw;
    }

    public static int getCost(int uid) {
        return getCard(uid).cost;
    }

    public static int getAttack(int uid) {
        return getCard(uid).attack;
    }

    public static int getDefence(int uid) {
        return getCard(uid).defence;
    }

    public static boolean isGuard(int uid) {
        return getCard(uid).guard;
    }

    public static boolean isBreakthrough(int uid) {
        return getCard(uid).breakthrough;
    }

    public static boolean isSmmnSickness(int uid) {
        return getCard(uid).smmnSickness;
    }

    static void abilityParse(String abiltyString, Card card) {
        String abiltyRef = "BCGDLW";
        for(int i = 0; i < abiltyString.length(); i++) {
            if(abiltyString.indexOf(abiltyRef.charAt(i)) != -1) {
                switch(i) {
                    case 0:
                        card.breakthrough = true;
                        break;
                    case 1:
                        card.smmnSickness = false;
                        break;
                    case 2:
                        card.guard = true;
                        break;
                }
            }
        }
    }
}

