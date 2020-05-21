import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

public class Player {
    private Map<Integer, Integer> costCurve = new HashMap<>() {{
            for(int i=0; i<13; i++) {
                put(i, 0);
            }
        }};
    private int hp;
    private int cost;
    private int cardsRemaining;
    private int rune;
    private int draw;
    private int handSize;
    private int totalMovesLastTurn;
    private List<Card> hand = new ArrayList<>();
    private List<Card> board = new ArrayList<>();

    public int getCostCurveForGivenVal(int cost) {
        return costCurve.get(cost);
    }

    public void incrementCostCurveForGivenVal(int cost) {
        costCurve.put(cost, costCurve.get(cost) + 1);
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
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
    public int getTotalMovesLastTurn() {
        return totalMovesLastTurn;
    }
    public void setTotalMovesLastTurn(int totalMovesLastTurn) {
        this.totalMovesLastTurn = totalMovesLastTurn;
    }
    public int getHandSize() {
        return handSize;
    }
    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }
    public void appendHand(Card card) {
        hand.add(card);
    }
    public List<Card> getHand() {
        return hand;
    }
    public void appendBoard(Card card) {
        board.add(card);
    }
    public List<Card> getBoard() {
        return board;
    }
    public void clearCards() {
        hand = new ArrayList<>();
        board = new ArrayList<>();
    }
}

