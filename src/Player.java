import java.util.*;
import java.util.stream.Collectors;

public class Player {

    private Map<Integer, Integer> costCurve = new HashMap<>() {{
            for(int i=0; i<13; i++) {
                put(i, 0);
            }
        }};

    private int hp;
    private int costBudget;
    private int cardsRemaining;
    private int rune;
    private int draw;
    private int handSize;
    private int totalMovesLastTurn;
    private Map<CardRef, List<Diff>> board = new HashMap<>();
    private List<CardRef> hand = new ArrayList<>();


    public int getCostCurveForGivenVal(int cost) {
        return costCurve.get(cost);
    }

    public void incrementCostCurveForGivenVal(int cost) {
        costCurve.put(cost, costCurve.get(cost) + 1);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCostBudget() {
        return costBudget;
    }

    public void setCostBudget(int costBudget) {
        this.costBudget = costBudget;
    }

    public int getCardsRemaining() {
        return cardsRemaining;
    }

    public void setCardsRemaining(int cardsRemaining) {
        this.cardsRemaining = cardsRemaining;
    }

    public int getRune() {
        return rune;
    }

    public void setRune(int rune) {
        this.rune = rune;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getTotalMovesLastTurn() {
        return totalMovesLastTurn;
    }

    public void setTotalMovesLastTurn(int totalMovesLastTurn) {
        this.totalMovesLastTurn = totalMovesLastTurn;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize) {
        this.handSize = handSize;
    }

    public void setHandSize() {
        this.handSize = this.getHand().size();
    }

    public void appendHand(CardRef cardRef) {
        hand.add(cardRef);
    }
    public List<CardRef> getHand() {
        return hand;
    }
    public void appendBoard(CardRef cardRef) { ;
        board.put(cardRef, new ArrayList<>());
    }
    public void appendDiff(CardRef cardRef, Diff diff) {
        this.board.get(cardRef).add(diff);
    }
    public Map<CardRef, List<Diff>> getBoard() {
        return board;
    }
    //remove maybe
    public void clearCards() {
        hand = new ArrayList<>();
        board = new HashMap<>();
    }

    public String doAction(ActionType action, CardRef... args) {
        if(args.length == 0 && action == ActionType.PASS) {
            return "PASS";
        } else if(args.length == 1 && action == ActionType.SUMMON) {
            this.summonCreatureFromHand(args[0]);
            return "SUMMON " + args[0].getIid();
        } else if(args.length == 2 && action == ActionType.ATTACK) {
            this.attackCharacter(args[0], args[1]);
            return "ATTACK " + args[0] + " " + args[1];
        } else throw new IllegalArgumentException("Not a recognised or valid action");
    }

    public void attackCharacter(CardRef attacker, CardRef defender) {
        defenderHealth = attacker.getAttack() - defender.getDefence();
        attackerHealth = defender.getAttack() - attacker.getDefence();
        if(defenderDamage < 0) {
            if(attacker.isBreakthrough()) {
                //need to be able to deal damage to opponent but cant access from Player
            }
            //destroy defender
        }
        if(attackerHealth < 0) {
            //destroy attacker
        }
    }

    public void summonCreatureFromHand(CardRef cardRef) {
        hand.remove(cardRef);
        this.board.put(cardRef, new ArrayList<Diff>());
        this.setHandSize(this.getHandSize() - 1);
    }
    public void damagePlayer(int damage) {this.hp -= damage;}
    public void healPlayer(int heal) {this.hp += heal;}
}

