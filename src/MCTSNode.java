import java.util.*;

public class MCTSNode{

    public static MCTS algorithm;

    private List<MCTSNode> children = new ArrayList<>(); //will represent available actions from given state
    private boolean expanded = false; //
    private MCTSNode parent;
    private State state;
    private Map<ActionType, ArrayList<CardRef>> action = new HashMap<>(); //preceding action that got us to the current state
    private float reward = 0;
    private float timesVisited = 0;

    public MCTSNode(State state, MCTS mcts) {
        MCTSNode.algorithm = mcts;
        this.parent = null;
        this.action.put(ActionType.ROOT, null);
    }

    public MCTSNode(MCTSNode parent, State state, ActionType actionType, ArrayList<CardRef> cardRefs) {
        this.parent = parent;
        this.state = state;
        this.action.put(actionType, cardRefs);
    }

    public MCTSNode(MCTSNode parent, State state, ActionType actionType, CardRef cardRef) {
        this.parent = parent;
        this.state = state;
        this.action.put(actionType, new ArrayList<>().add(cardRef));
    }

    public MCTSNode(MCTSNode parent, State state, ActionType actionType) {
        assert actionType == ActionType.PASS;
        this.parent = parent;
        this.state = state;
        this.action.put(actionType, null);
    }

    public void appendToActionStrings() {
        if (getActionCards().size() == 0) {
            algorithm.appendSelectionAction(state.doAction(action.keySet().iterator().next()));
        } else if (getActionCards().size() == 1) {
            algorithm.appendSelectionAction(state.doAction(action.keySet().iterator().next(), getActionCards().get(0)));
        } else if (getActionCards().size() == 2) {
            algorithm.appendSelectionAction(state.doAction(action.keySet().iterator().next(), getActionCards().get(0), getActionCards().get(1)));
        } else throw new IllegalStateException("something is wrong with the action picked during selection");
    }

    public List<MCTSNode> getChildren() {
        return children;
    }

    public void appendChild(MCTSNode mctsNode) {
        children.add(mctsNode);
    }

    public void setChildren(List<MCTSNode> children) {
        this.children = children;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public MCTSNode getParent() {
        return parent;
    }

    public void setParent(MCTSNode parent) {
        this.parent = parent;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ActionType getAction() {
        return action.keySet().iterator().next();
    }

    public ArrayList<CardRef> getActionCards() {
        return action.get(action.keySet().iterator().next());
    }

    public void setAction(Map<ActionType, ArrayList<CardRef>> action) {
        this.action = action;
    }

    public float getReward() {
        return reward;
    }

    public void setReward(float reward) {
        this.reward = reward;
    }

    public float getTimesVisited() {
        return timesVisited;
    }

    public void setTimesVisited(float timesVisited) {
        this.timesVisited = timesVisited;
    }

    public MCTSNode selection(double epsilon) {
        if(children.size() == 0) return this;
        MCTSNode chosen = children.get((int)(Math.random() * children.size()));
        if (Math.random() < epsilon) {
            return chosen;
        }
        double score = 0;
        for (MCTSNode node : children) {
            if (node.getTimesVisited() == 0) { //something in here to print actions so the game does them
                continue;
            }
            double prospectiveScore = node.getReward() / node.getTimesVisited() + Math.sqrt(2 * Math.log(node.getParent().getTimesVisited()) / node.getTimesVisited());
            if (prospectiveScore > score) {
                score = prospectiveScore;
                chosen = node;
            }
        }
            return chosen.selection(epsilon);
    }


    public void expand() {
        this.setExpanded(true);
    }
}
