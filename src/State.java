import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class State {

    private Player[] players = new Player[2];
    private List<Action> oppActionsLastTurn = new ArrayList<>();

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


