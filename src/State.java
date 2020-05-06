import java.util.List;

public class State {

    private Player[] players = new Player[2];
    private int oppHandSize;
    private List<Card> cards;

    public Player[] getPlayers(int i) {
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
