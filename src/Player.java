import java.util.HashMap;
import java.util.Map;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class Player {
    private Map<Integer, Integer> manaCurve = new HashMap<>() {{
            for(int i=0; i<13; i++) {
                put(i, 0);
            }
        }};
    private int hp;
    private int mana;
    private int cardsRemaining;
    private int rune;
    private int draw;

    public Integer getManaCurveForGivenVal(int mana) {
        return manaCurve.get(mana);
    }

    public void incrementManaCurveForGivenVal(int mana) {
        manaCurve.put(mana, manaCurve.get(mana) + 1);
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getCardsRemaining() {
        return cardsRemaining;
    }
    public void setCardsRemaining(int cardsRemaining) {
        this.cardsRemaining = cardsRemaining;
    }
    public int getRune() {
        return rune;
    }
    public void setRune(int rune) {
        this.rune = rune;
    }
    public int getDraw() {
        return draw;
    }
    public void setDraw(int draw) {
        this.draw = draw;
    }
}

