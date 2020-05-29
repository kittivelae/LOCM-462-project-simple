@FunctionalInterface
public interface BranchSelection {

    MCTSNode select(Object... args);
}
