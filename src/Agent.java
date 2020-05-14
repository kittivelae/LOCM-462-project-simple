import java.util.Scanner;

public class Agent {

    private State state;
    Scanner in = new Scanner(System.in);
    CardActionPairGenerator cardActionPairGenerator = new CardActionPairGenerator();

    void read() {
        //todo 1 add lanes functionality
        for(Player player : state.getPlayers())
        {
            player.setHp(in.nextInt());
            player.setMana(in.nextInt());
            player.setCardsRemaining(in.nextInt());
            player.setRune(in.nextInt());
            player.setDraw(in.nextInt());
        }
//        for (int i = 0; i < 2; i++) {
//            Player player = state.getPlayerX(i);
//            player.setHp(in.nextInt());
//            player.setMana(in.nextInt());
//            player.setCardsRemaining(in.nextInt());
//            player.setRune(in.nextInt());
//            player.setDraw(in.nextInt());
//        } N.B. fallback code for if the above doesn't work
        state.setOppHandSize(in.nextInt());
        state.setOppTotalMovesLastTurn(in.nextInt());
        if (in.hasNextLine()) {
            in.nextLine();
        }
        state.clearOppActionsLastTurn();
        for (int i = 0; i < state.getOppTotalMovesLastTurn(); i++) {
            state.appendOppActionsLastTurn(cardActionPairGenerator.getCardActionPair(in.nextLine()));
        }
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
            Card card = new Card();
            state.clearCards();
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
            state.appendCards(card, location);
        }
    }

    void cardEvalForDraft(Card[] draftOptions) {
        double score = 0;
        int prospectiveCard = 0;
        for (int i = 0; i < 2; i++) {
            int cardCost = draftOptions[i].getCost();
            double prospectScore = Card.getCostWeighting(cardCost)*Math.pow(0.95, state.getPlayerX(0).getManaCurveForGivenVal(cardCost));
            if (prospectScore > score) {
                score = prospectScore;
                prospectiveCard = i;
            }
        }
        System.out.println("PICK " + prospectiveCard + ";");
        state.getPlayerX(0).incrementManaCurveForGivenVal(draftOptions[prospectiveCard].getCost());
    }
}