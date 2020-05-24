import java.util.*;
import java.util.stream.Collectors;


public class State {

    private Player[] players = new Player[2];
    private EnumMap<ActionType, Object> validActions = new EnumMap<>(ActionType.class);


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
    public void appendValidActions(ActionType actionType, List<Integer> iids)  {
        validActions.put(ActionType.SUMMON, new ArrayList<Integer>().addAll(iids));
    }

    public void evalValidActions() {
        List<Integer> validAttackers;
        List<Integer> validAtkTargets;
        List<Integer> cardsWithinBudget;
        if(me().getBoard().size() < Constants.MAX_CREATURES_IN_LINE && me().getHand().size() != 0) {
            cardsWithinBudget = me().getHand().entrySet()
                    .stream()
                    .filter(c -> c.getValue().getCost() <= me().getCostBudget())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            appendValidActions(ActionType.SUMMON, cardsWithinBudget);
        }
    }
}


