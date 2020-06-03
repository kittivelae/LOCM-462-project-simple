import java.util.*;

public class Player {

    private int hp;
    private int costBudget;
    private int cardsRemaining;
    private int rune;
    private int draw;
    private int handSize;
    private int totalMovesLastTurn;
    private List<CardRef> board = new ArrayList<>();
    private List<CardRef> hand = new ArrayList<>();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCostBudget() {
        return costBudget;
    }

    public void setCostBudget(int costBudget) {
        this.costBudget = costBudget;
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

    public void setHandSize() {
        this.handSize = this.getHand().size();
    }

    public void appendHand(CardRef cardRef) {
        hand.add(cardRef);
    }

    public List<CardRef> getHand() {
        return hand;
    }

    public void summonCreatureFromHand(CardRef cardRef) {
        this.hand.remove(cardRef);
        this.board.add(cardRef);
        this.setHandSize(this.getHandSize() - 1);
    }

    public void destroyCreature(CardRef cardRef) {
        board.remove(cardRef);
    }

    public void appendBoard(CardRef cardRef) {
        board.add(cardRef);
    }

    public List<CardRef> getBoard() {
        return board;
    }

    //remove maybe
    public void clearCards() {
        hand = new ArrayList<>();
        board = new ArrayList<>();
    }

    public void changeHealth(int amount) {
        this.hp += amount;
    }

    public void increaseHandSize(int cardDraw) {
        this.handSize = Math.min(this.handSize + cardDraw, Constants.MAX_CARDS_IN_HAND);
    }
}

