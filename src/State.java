import java.util.*;
import java.util.stream.Collectors;


public class State {

    private Player[] players = new Player[2];
    private EnumMap<ActionType, Object> validActions = new EnumMap<>(ActionType.class);
    private boolean playersFlipped = false;

    public State() {
        validActions.put(ActionType.PASS, null);
        validActions.put(ActionType.SUMMON, new ArrayList<CardRef>());
        validActions.put(ActionType.ATTACK, new ArrayList<CardRefPair>());
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player nonTurnPlayer() {
        if(playersFlipped) return players[0];
        return players[1];
    }

    public Player turnPlayer() {
        if(playersFlipped) return players[1];
        return players[0];
    }

    public Player getPlayerByLocation(int location) {
        if(location == 0 || location == 1) return players[0];
        return players[0];
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setPlayer(int playerNum, Player player) {
        this.players[playerNum-1] = player;
    }

    public void appendValidActions(ActionType actionType, List<CardRef> cardRefs)  {
        validActions.put(actionType, new ArrayList<CardRef>().addAll(cardRefs));
    }

    public void appendValidAttack(List<CardRefPair> cardRefs)  {
        validActions.put(ActionType.ATTACK, new ArrayList<CardRefPair>().addAll(cardRefs));
    }

    
    //need to ascertain the starting turn correctly (use cards in hand)
    public void simulateTurnChange() {
        this.playersFlipped = !this.playersFlipped;
    }

    public String doAction(ActionType action) {
        if(action == ActionType.PASS) {
            return "PASS;";
        }
        else throw new IllegalArgumentException("Not a recognised or valid action");
    }

    public String doAction(ActionType action, CardRef cardRef1, CardRef cardRef2) {
        if(action == ActionType.ATTACK) {
            this.attackCharacter(cardRef1, cardRef2);
            return "ATTACK " + cardRef1.getIid() + " " + cardRef2.getIid();
        } else throw new IllegalArgumentException("Not a recognised or valid action");
    }

    public String doAction(ActionType action, CardRef cardRef) {
        if(action == ActionType.SUMMON) {
            this.turnPlayer().summonCreatureFromHand(cardRef);
            this.turnPlayer().changeHealth(cardRef.getHpChange());
            this.nonTurnPlayer().changeHealth(cardRef.getHpChangeEnemy());
            this.turnPlayer().increaseHandSize(cardRef.getCardDraw());
            return "SUMMON " + cardRef.getIid();
        } else throw new IllegalArgumentException("Not a recognised or valid action");
    }

    public void attackCharacter(CardRef attacker, CardRef defender) {
        int defenderHealth = defender.getDefence() - attacker.getAttack();
        int attackerHealth = attacker.getDefence() - defender.getAttack();
        if(defenderHealth < 0) {
            if(attacker.isBreakthrough()) {
                nonTurnPlayer().changeHealth(defenderHealth);
            }
            nonTurnPlayer().destroyCreature(defender);
        } else {
            defender.updateCardModifiers(CardField.CURRENT_HP, defenderHealth);
        }
        if(attackerHealth < 0) {
            turnPlayer().destroyCreature(attacker);
        } else {
            attacker.updateCardModifiers(CardField.CURRENT_HP, attackerHealth);
        }
    }

    public void evalValidActions() {
        //will need to take another look at this once i implement items
        List<CardRef> validAttackers;
        List<CardRef> validAtkTargets;
        List<CardRef> cardsWithinBudget;
        List<CardRefPair> validAttacks = new ArrayList<>();
        if(turnPlayer().getBoard().size() < Constants.MAX_CREATURES_IN_LINE && turnPlayer().getHand().size() != 0) {
            cardsWithinBudget = turnPlayer().getHand()
                    .stream()
                    .filter(c -> c.getCost() <= turnPlayer().getCostBudget())
                    .collect(Collectors.toList());
            validActions.put(ActionType.SUMMON, cardsWithinBudget);
        }
        validAttackers = turnPlayer().getBoard()
                .stream()
                .filter(c -> c.isSmmnSickness())
                .collect(Collectors.toList());
        if(validAttackers.size() == 0) {
            validActions.put(ActionType.ATTACK, validAttackers);
        } else {
            //this first looks for creatures on opp's board with Guard.
            //if it finds none, it sets the valid targets to all opp's creatures
            //plus opponent themself.
            validAtkTargets = nonTurnPlayer().getBoard()
                    .stream()
                    .filter(c -> c.isGuard())
                    .collect(Collectors.toList());
            if (validAtkTargets.size() == 0) {
                validAtkTargets = new ArrayList<>(nonTurnPlayer().getBoard());
                validAtkTargets.add(CardRef.nonTurnPlayer);
            }
            for (CardRef attacker : validAttackers) {
                for (CardRef target : validAtkTargets) {
                    validAttacks.add(new CardRefPair(attacker, target));
                }
            }
            validActions.put(ActionType.ATTACK, validAttacks);
        }
    }
}


