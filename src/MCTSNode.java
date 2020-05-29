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

    public MCTSNode selection(BranchSelector branchSelector, Object... args) {
        if(children.size() == 0) return this;
        List<Object> newList = new ArrayList<>();
        newList.add(children);
        for(Object arg : args) newList.add(arg);
        return branchSelector.selector().select();
    }

    public void expand() {
        this.setExpanded(true);
    }
}
