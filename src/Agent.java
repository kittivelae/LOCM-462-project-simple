import java.util.*;

public class Agent {

    private State state;
    Scanner in = new Scanner(System.in);

    void readDraft() {
        Map<Integer, Integer> costCurve = new HashMap<>() {{
            for(int i=0; i<13; i++) {
                put(i, 0);
            }
        }};
        //noinspection InfiniteLoopStatement
        for (int turn = 0; turn < 30; turn++) {
            this.readPlayerInformation();
            int cardCount = in.nextInt();
            List<CardRef> draftOptions = new ArrayList<>();
            for (int i = 0; i < cardCount; i++) {
                int iid = in.nextInt(); //iid
                int uid = in.nextInt(); //uid
                CardRef cardRef = new CardRef(iid, uid);
                in.nextInt(); //location
                in.nextInt(); //cardType
                in.nextInt(); //cost
                in.nextInt(); //attack
                in.nextInt(); //defence
                in.next(); //abilitystring
                in.nextInt(); //hpChange
                in.nextInt(); //hpChangeEnemy
                in.nextInt(); //cardDraw
                draftOptions.add(cardRef);
            }
            double score = 0;
            int prospectiveCard = 0;
            for (CardRef cardRef : draftOptions) {
                double prospectScore = Constants.getCostWeighting(cardRef.getCost())*Math.pow(0.95, costCurve.get(cardRef.getCost()));
                if (prospectScore > score) {
                    score = prospectScore;
                    prospectiveCard = draftOptions.indexOf(cardRef);
                }
            }
            System.out.println("PICK " + prospectiveCard + ";");
            costCurve.put(draftOptions.get(prospectiveCard).getCost(), costCurve.get(draftOptions.get(prospectiveCard).getCost())+1);
        }
    }

    void readPlayerInformation() {
        for(Player player : state.getPlayers())
        {
            player.setHp(in.nextInt());
            player.setCostBudget(in.nextInt());
            player.setCardsRemaining(in.nextInt());
            player.setRune(in.nextInt());
            player.setDraw(in.nextInt());
        }
        state.nonTurnPlayer().setHandSize(in.nextInt());
        state.nonTurnPlayer().setTotalMovesLastTurn(in.nextInt());
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < state.nonTurnPlayer().getTotalMovesLastTurn(); i++) {
            //sequence of strings describing actions opponent took last turn
            in.nextLine(); //on more complicated difficulties will need to use this to set card diffs correctly
        }
    }



    void readBattle() {
        List<CardRef> newHand = new ArrayList<>();
        List<CardRef> newBoard = new ArrayList<>();
        List<CardRef> newOppBoard = new ArrayList<>();
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
            int uid = in.nextInt();
            int iid = in.nextInt();
            CardRef cardRef = new CardRef(iid, uid);
            int location = in.nextInt();
            if (location == 0) {
                newHand.add(cardRef);
            } else {
                in.nextInt(); //cardType
                in.nextInt(); //cost
                in.nextInt(); //attack
                cardRef.updateCardModifiers(CardField.CURRENT_HP, in.nextInt()); //defence
                String abilities = in.next();
                in.nextInt(); //hpChange
                in.nextInt(); //hpChangeEnemy
                in.nextInt(); //draw
                if (location == 1) {
                    newBoard.add(cardRef);
                } else if (location == -1) {
                    newOppBoard.add(cardRef);
                }
            }
        }
        state.turnPlayer().setHand(newHand);
        state.turnPlayer().setBoard(newBoard);
        state.turnPlayer().setHandSize(); //move this to Player
        state.nonTurnPlayer().setBoard(newOppBoard);
    }

    int stateEvalForPlay() {
        //Acknowledgement: this is a refactor of Strategy-Card-Game-AI-Competition/referee-nim/Research/StateEvaluations/Simple.nim
        int score = 0;
        //death
        if(state.turnPlayer().getHp() <= 0) {
            score -= 1000;
        } else if(state.nonTurnPlayer().getHp() <= 0) {
            score += 1000;
        }
        score += 2 * (state.turnPlayer().getHp() - state.nonTurnPlayer().getHp()); //Health
        score += 4 * (state.turnPlayer().getHandSize() - state.nonTurnPlayer().getHandSize()); //hand advantage
        //board advantage
        score += 5 * (state.turnPlayer().getBoard().size() - state.nonTurnPlayer().getBoard().size());
        for(CardRef cardRef : state.turnPlayer().getBoard()) {
            score += cardRef.getAttack() + cardRef.getDefence();
        }
        for(CardRef cardRef : state.nonTurnPlayer().getBoard()) {
            score -= cardRef.getAttack() - cardRef.getDefence();
        }
        return score;
    }
}