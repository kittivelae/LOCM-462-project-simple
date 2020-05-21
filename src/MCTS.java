import java.util.List;

public class MCTS {

}

class MCTSNode{
    private List<MCTSNode> children; //will represent available actions from given state
    private boolean expanded; //
    private MCTSNode parent;
    private State state;
    private Action action; //preceding action that got us to the current state
    private float expectedUtility;
    private float timesVisited;
}
