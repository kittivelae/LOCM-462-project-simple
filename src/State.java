import java.util.*;
import java.util.stream.Collectors;


public class State {

    private Player[] players = new Player[2];
    private EnumMap<ActionType, Object> validActions = new EnumMap<>(ActionType.class);
    private boolean playersFlipped = false;

    public Player[] getPlayers() {
        return players;
    }
    public Player nonTurnPlayer() {
        if(playersFlipped) return players[0];
        return players[1];
    }
    public Player turnPlayer() {
        if(playersFlipped) return players[1];
        return players[0];
    }
    public Player getPlayerByLocation(int location) {
        if(location == 0 || location == 1) return players[0];
        return players[0];
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    public void setPlayer(int playerNum, Player player) {
        this.players[playerNum-1] = player;
    }
    public void appendValidActions(ActionType actionType, List<Integer> iids)  {
        validActions.put(ActionType.SUMMON, new ArrayList<Integer>().addAll(iids));
    }
    //need to ascertain the starting turn correctly (use cards in hand)
    public void simulateTurnChange() {
        this.playersFlipped = !this.playersFlipped;
    }
    public void updateDiff(CardRef cardRef, Card card, int location) {
        Card referenceCard = Card.getCard(cardRef);
        int cardHealthDiff = referenceCard.getDefense() - card.getDefense();
        if (cardHealthDiff != 0) {
            this.getPlayerByLocation(location).appendDiff(cardRef, new Diff(CardField.HP, cardHealthDiff));
        if(!referenceCard.isSmmnSickness()) {
            cardRef.removeSmmnSickness();
        }
    }
    public void evalValidActions() {
        List<CardRef> validAttackers;
        List<CardRef> validAtkTargets;
        List<CardRef> cardsWithinBudget;
        if(turnPlayer().getBoard().size() < Constants.MAX_CREATURES_IN_LINE && turnPlayer().getHand().size() != 0) {
            cardsWithinBudget = turnPlayer().getHand().entrySet()
                    .stream()
                    .filter(c -> c.getValue().getCost() <= turnPlayer().getCostBudget())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            appendValidActions(ActionType.SUMMON, cardsWithinBudget);
        }
        turnPlayer().getBoard().entr
        }
    }
}


