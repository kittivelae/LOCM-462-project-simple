import java.util.List;

public class MCTS {

    class UCT implements BranchSelector {

        @Override
        public BranchSelection1Param<List<MCTSNode>, Double> selector() {
            //something in here to actually do the actions
            return (children, epsilon) -> {

            };
        }
    }
}

