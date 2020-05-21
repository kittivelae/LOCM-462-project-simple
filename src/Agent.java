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
            player.setCost(in.nextInt());
            player.setCardsRemaining(in.nextInt());
            player.setRune(in.nextInt());
            player.setDraw(in.nextInt());
            player.clearCards();
        }
        state.opp().setHandSize(in.nextInt());
        state.opp().setTotalMovesLastTurn(in.nextInt());
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < state.opp().getTotalMovesLastTurn(); i++) {
            in.nextLine();
        }
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
            Card card = new Card();
            card.setUid(in.nextInt());
            card.setIid(in.nextInt());
            int location = in.nextInt();
            card.setCardType(in.nextInt());
            card.setCost(in.nextInt());
            card.setAttack(in.nextInt());
            card.setDefense(in.nextInt());
            card.setAbilities(in.next());
            card.setHpChange(in.nextInt());
            card.setHpChangeEnemy(in.nextInt());
            card.setCardDraw(in.nextInt());
            if(location == 0) {
                state.me().appendHand(card);
            } else if(location == 1) {
                state.me().appendBoard(card);
            } else if(location == -1) {
                state.opp().appendBoard(card);
            }
            state.me().setHandSize(state.me().getHand().size()); //move this to Player
        }
    }

    void cardEvalForDraft(Card[] draftOptions) {
        double score = 0;
        int prospectiveCard = 0;
        for (int i = 0; i < 2; i++) {
            int cardCost = draftOptions[i].getCost();
            double prospectScore = Card.getCostWeighting(cardCost)*Math.pow(0.95, state.me().getCostCurveForGivenVal(cardCost));
            if (prospectScore > score) {
                score = prospectScore;
                prospectiveCard = i;
            }
        }
        System.out.println("PICK " + prospectiveCard + ";");
        state.me().incrementCostCurveForGivenVal(draftOptions[prospectiveCard].getCost());
    }

    int stateEvalForPlay() {
        //Acknowledgement: this is a refactor of Strategy-Card-Game-AI-Competition/referee-nim/Research/StateEvaluations/Simple.nim
        int score = 0;
        //death
        if(state.me().getHp() <= 0) {
            score -= 1000;
        } else if(state.opp().getHp() <= 0) {
            score += 1000;
        }
        score += 2 * (state.me().getHp() - state.opp().getHp()); //Health
        score += 5 * (state.me().getHandSize() - state.opp().getHandSize()); //hand advantage
        //board advantage
        score += 5 * (state.me().getBoard().size() - state.opp().getBoard().size());
        for(Card card : state.me().getBoard()) {
            score += card.getAttack() + card.getDefense();
        }
        for(Card card : state.opp().getBoard()) {
            score -= card.getAttack() - card.getDefense();
        }
        return score;
    }
}