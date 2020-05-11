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
            //TODO 2: make this pass the uid and iid of the card only to allow lookup in card db
            //TODO 3: make this track changes in card instance from one turn to next
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

    Card cardEvalForDraft() {
        float score = 0;
        Integer[] draftOptionsUids; //from whiteboarded code, dunno what this is yet
        Card[] draftOptions = new Card[3];
        for (int i = 0; i < 2; i++) {
            draftOptions[i] = Card.getFromCardDb(draftOptionsUids[i]); //todo 7 need to implement this in Card, see todos 4 & 5
        }
        for (int i = 0; i < 2; i++) {
            int cardCost = draftOptions[i].getCost();
            float prospectScore = Card.getCostWeighting(cardCost))*0.95^state.getPlayerX(0).getAmtDraftedXMana(cardCost); //todo 8 need to implement this in player
            if (prospectScore > score) {
                score = prospectScore;
                int prospectiveCard = i;
            }
        }
        return new Card(); //todo 9 need to make this return actual chosen card
    }
}