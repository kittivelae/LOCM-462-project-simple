import java.util.List;
import java.util.ArrayList;

public class MCTSNode{

    private List<MCTSNode> children = new ArrayList<>(); //will represent available actions from given state
    private boolean expanded = false; //
    private MCTSNode parent;
    private State state;
    private Action action; //preceding action that got us to the current state
    private float reward = 0;
    private float timesVisited = 0;

    public List<MCTSNode> getChildren() {
        return children;
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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
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
