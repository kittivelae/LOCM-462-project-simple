@FunctionalInterface
public interface BranchSelection1Param<T, E> extends BranchSelection {

    //for selectors that utilise one parameter and a list of nodes
    MCTSNode branchSelection(T t, E e);

    @Override
    @SuppressWarnings("unchecked")
    default MCTSNode select(Object... args) {
        return this.branchSelection((T) args[0], (E) args[1]);
    }
}
