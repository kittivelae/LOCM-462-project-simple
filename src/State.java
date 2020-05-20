import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class State {

    private Player[] players = new Player[2];
    //TODO 6: move 'opp*' member vars into Player class
    private int oppHandSize;
    private int oppTotalMovesLastTurn;
    private List<Action> oppActionsLastTurn = new ArrayList<>();
    private Map<Integer, List<Card>> cards = new HashMap<>(); //may need to change if it turns out card placement matters in this game

    public State() {
        clearCards();
    }
    public Player[] getPlayers() {
        return players;
    }
    public Player getPlayerX(int playerNum) {
        return players[playerNum - 1];
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void setPlayerX(int playerNum, Player player) {
        this.players[playerNum-1] = player;
    }
    public int getOppHandSize() {
        return oppHandSize;
    }
    public void setOppHandSize(int oppHandSize) {
        this.oppHandSize = oppHandSize;
    }
    public List<Card> getCards(int location) {
        return cards.get(location);
    }
    public void appendCards(Card card, int location) {
        cards.get(location).add(card);
    }
    public void clearCards() {
        cards.put(1, new ArrayList<>());
        cards.put(0, new ArrayList<>());
        cards.put(-1, new ArrayList<>());
    }
    public int getOppTotalMovesLastTurn() {
        return oppTotalMovesLastTurn;
    }
    public void setOppTotalMovesLastTurn(int oppTotalMovesLastTurn) {
        this.oppTotalMovesLastTurn = oppTotalMovesLastTurn;
    }
    public List<Action> getOppActionsLastTurn() {
        return oppActionsLastTurn;
    }
    public void appendOppActionsLastTurn(Action cardActionPair) {
        this.oppActionsLastTurn.add(cardActionPair);
    }
    public void clearOppActionsLastTurn() {
        this.oppActionsLastTurn = new ArrayList<>();
    }
}


