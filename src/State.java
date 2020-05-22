import java.util.*;


public class State {

    //private Player[] players = new Player[2];
    //maybe use enummap copy constructor to copy info to MCTS nodes?
    private Map<PlayerStat, Object> me;
    private Map<PlayerStat, Object> opp = new EnumMap<>(PlayerStat.class);

    public State() {
        opp.put(PlayerStat.HP, Constants.INITIAL_HEALTH);
        opp.put(PlayerStat.BUDGET, 0);
        opp.put(PlayerStat.CARDSLEFT, 0);
        opp.put(PlayerStat.RUNE, 0);
        opp.put(PlayerStat.DRAW, 0);
        opp.put(PlayerStat.HANDSIZE, 0);
        //put(PlayerStat.MOVESLASTTURN, 0);
        opp.put(PlayerStat.BOARD, new HashMap<Integer, Card>());
        me = new EnumMap<>(opp);
        me.put(PlayerStat.HAND, new HashMap<Integer, Card>());
    }

    public Object getOppHp() { opp.get(PlayerStat.HP); }
    public Object getOppBudget() { opp.get(PlayerStat.BUDGET); }
    public Object getOppCardsLeft() { opp.get(PlayerStat.CARDSLEFT); }
    public Object getOppRune() { opp.get(PlayerStat.RUNE); }
    public Object getOppDraw() { opp.get(PlayerStat.DRAW); }
    public Object getOppHandSize() { opp.get(PlayerStat.HANDSIZE); }
    public Object getOppBoard() { opp.get(PlayerStat.BOARD); }
    public void setOppHp(int hp) { opp.put(PlayerStat.HP, hp); }
    public void setOppBudget(int budget) { opp.put(PlayerStat.BUDGET, budget); }
    public void setOppCardsLeft(int cardsLeft) { opp.put(PlayerStat.CARDSLEFT, cardsLeft); }
    public void setOppRune(int rune) { opp.put(PlayerStat.RUNE, rune); }
    public void setOppDraw(int draw) { opp.put(PlayerStat.DRAW, draw); }
    public void setOppHandSize(int handSize) { opp.put(PlayerStat.HANDSIZE, handSize); }
    //public void setOppBoard() { return opp.put(PlayerStat.BOARD,); }
    public Object getMeHp() { return me.get(PlayerStat.HP); }
    public Object getMeBudget() { return me.get(PlayerStat.BUDGET); }
    public Object getMeCardsLeft() { return me.get(PlayerStat.CARDSLEFT); }
    public Object getMeRune() { return me.get(PlayerStat.RUNE); }
    public Object getMeDraw() { return me.get(PlayerStat.DRAW); }
    public Object getMeHandSize() { return me.get(PlayerStat.HANDSIZE); }
    public Object getMeBoard() { return me.get(PlayerStat.BOARD); }
    public Object getMeHand() { return me.get(PlayerStat.HAND); }
    public void setMeHp(int hp) { me.put(PlayerStat.HP, hp); }
    public void setMeBudget(int budget) { me.put(PlayerStat.BUDGET, budget); }
    public void setMeCardsLeft(int cardsLeft) { me.put(PlayerStat.CARDSLEFT, cardsLeft); }
    public void setMeRune(int rune) { me.put(PlayerStat.RUNE, rune); }
    public void setMeDraw(int draw) { me.put(PlayerStat.DRAW, draw); }
    public void setMeHandSize(int handSize) { me.put(PlayerStat.HANDSIZE, handSize); }
    //public void setOppBoard() { return opp.put(PlayerStat.BOARD,); }
    //public void setOppHand() { return opp.put(PlayerStat.HAND,); }


}


