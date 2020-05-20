import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class State {

    private Player[] players = new Player[2];
    private List<Action> oppActionsLastTurn = new ArrayList<>();
    private Map<Integer, List<Card>> cards = new HashMap<>(); //may need to change if it turns out card placement matters in this game

    public State() {
        clearCards();
    }
    public Player[] getPlayers() {
        return players;
    }
    public Player opp() {
        return players[1];
    }
    public Player me() {
        return players[0];
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void setPlayer(int playerNum, Player player) {
        this.players[playerNum-1] = player;
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


