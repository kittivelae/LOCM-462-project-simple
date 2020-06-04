import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class MCTS {

    private MCTSNode root;
    private MCTSNode tail;
    private List<String> selectedActionString = new ArrayList<>();
    private final double computeTime;
    private final double epsilon;
    private final ThreadMXBean timeCounter = ManagementFactory.getThreadMXBean();

    public MCTS(State state, double computeTime, double epsilon) {
        this.root = new MCTSNode(state, this);
        this.computeTime = computeTime;
        this.epsilon = epsilon;
    }

    public String algorithm() {
        long startTime = this.timeCounter.getCurrentThreadCpuTime();


    }

    public void appendSelectionAction(String actionString) {
        selectedActionString.add(actionString);
    }
}

