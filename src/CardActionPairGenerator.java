import org.jetbrains.annotations.NotNull;

enum ActionType {
    SUMMON,
    ATTACK,
    PASS
}

public class CardActionPairGenerator {
    /*
        The possible actions are:
        SUMMON id to summon the creature id from your hand.
        ATTACK id1 id2 to attack creature id2 with creature id1.
        ATTACK id -1 to attack the opponent directly with creature id.
        PASS to do nothing this turn.
        Actions are preceded by the UID of the card from which it originates
        e.g. actionParams = 5 ATTACK 12 -1 means go face with instanceid 12 of card with uid 5.

        n.b probably should do some error handling for if string doesn't match input ENUM
    */

    public Action getCardActionPair(String rawActionString) {
        String[] actionParams = rawActionString.split(" ", 4);
        ActionType typeOfGivenAction = ActionType.valueOf(actionParams[1]);
        switch (typeOfGivenAction) {
            case PASS:
                return PassTurn.getInstance();
            case ATTACK:
                return new AttackCharacter(Integer.parseInt(actionParams[0]), Integer.parseInt(actionParams[2]), Integer.parseInt(actionParams[3]));
            case SUMMON:
                return new SummonMinion(Integer.parseInt(actionParams[0]), Integer.parseInt(actionParams[2]));
        }
        return null;
    }
}

class Action {
    protected ActionType action;

    public ActionType getAction() {
        return action;
    }
}

class AttackCharacter extends Action {
    private int uid;
    private int iid;
    private int iidTarget;

    public AttackCharacter(int uid, int iid, int iidTarget) {
        this.uid = uid;
        this.iid = iid;
        this.iidTarget = iidTarget;
    }

    public int getUid() {
        return uid;
    }

    public int getIid() {
        return iid;
    }

    public int getIidTarget() {
        return iidTarget;
    }
}

class SummonMinion extends Action {
    private int uid;
    private int iid;

    public SummonMinion(int uid, int iid) {
        this.uid = uid;
        this.iid = iid;
    }

    public int getUid() {
        return uid;
    }

    public int getIid() {
        return iid;
    }
}

class PassTurn extends Action {
    private static final PassTurn solitaryInstance = new PassTurn();

    private PassTurn() {
        this.action = ActionType.PASS;
    }

    public static PassTurn getInstance() {
        return solitaryInstance;
    }
}