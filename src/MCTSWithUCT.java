import java.util.List;

public class MCTSWithUCT {

    class UCT implements BranchSelector {

        @Override
        public BranchSelection1Param<List<MCTSNode>, Double> selector() {
            //something in here to actually do the actions
            return (children, epsilon) -> {
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
                return chosen;
            };
        }
    }
}

