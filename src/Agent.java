import java.util.Scanner;

public class Agent {



    private State state;
    Scanner in = new Scanner(System.in);
    CardActionPairGenerator cardActionPairGenerator = new CardActionPairGenerator();

    void draft() {
        //noinspection InfiniteLoopStatement
        while (true) {
            this.read();
            System.out.println("PICK 0");
        }
    }

    void play() {
        //noinspection InfiniteLoopStatement
        while (true) {
            this.read();
            System.out.println("PASS");
        }
    }

    void read() {
        for(Player player : state.getPlayers())
        {
            player.setHp(in.nextInt());
            player.setCostBudget(in.nextInt());
            player.setCardsRemaining(in.nextInt());
            player.setRune(in.nextInt());
            player.setDraw(in.nextInt());
            player.clearCards();
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
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
            int uid = in.nextInt();
            int iid = in.nextInt();
            CardRef cardRef = new CardRef(iid, uid);
            int location = in.nextInt();
            if(location == 0) {
                state.turnPlayer().appendHand(cardRef);
            } else {
                in.nextInt(); //cardType
                int cost = in.nextInt();
                int attack = in.nextInt();
                int defense = in.nextInt();
                String abilities = in.next();
                int hpChange = in.nextInt();
                int hpChangeEnemy = in.nextInt();
                int cardDraw = in.nextInt();
                state.updateDiff(cardRef,
                        new Card(cost, attack, defense, abilities, hpChange, hpChangeEnemy, cardDraw),
                        location);
            state.turnPlayer().setHandSize(); //move this to Player
        }
    }

    void cardEvalForDraft(Card[] draftOptions) {
        double score = 0;
        int prospectiveCard = 0;
        for (int i = 0; i < 2; i++) {
            int cardCost = draftOptions[i].getCost();
            double prospectScore = Card.getCostWeighting(cardCost)*Math.pow(0.95, state.turnPlayer().getCostCurveForGivenVal(cardCost));
            if (prospectScore > score) {
                score = prospectScore;
                prospectiveCard = i;
            }
        }
        System.out.println("PICK " + prospectiveCard + ";");
        state.turnPlayer().incrementCostCurveForGivenVal(draftOptions[prospectiveCard].getCost());
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
        for(Card card : state.turnPlayer().getBoard()) {
            score += card.getAttack() + card.getDefense();
        }
        for(Card card : state.nonTurnPlayer().getBoard()) {
            score -= card.getAttack() - card.getDefense();
        }
        return score;
    }
}