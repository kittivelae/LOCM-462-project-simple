import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class MCTS {

    private MCTSNode root;
    private MCTSNode tail;
    private List<String> selectedActionString = new ArrayList<>();
    private final double computeTime;
    private long startTime;
    private final double epsilon;

    public MCTS(State state, double computeTime, double epsilon) {
        this.root = new MCTSNode(state, this);
        this.computeTime = computeTime;
        this.epsilon = epsilon;
    }

    public String algorithm() {
        startTime = Constants.timeCounter.getCurrentThreadCpuTime();
        MCTSNode toExpand = root.selection(epsilon);
        toExpand.getState().evalValidActions();
        ArrayList<CardRefPair> validAttacks = toExpand.getState().getValidAttacks();
        ArrayList<CardRef> validSummons = toExpand.getState().getValidSummons();
    }

    public void appendSelectionAction(String actionString) {
        selectedActionString.add(actionString);
    }
}

