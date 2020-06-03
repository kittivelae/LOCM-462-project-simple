public class CardRefPair {

    private final CardRef card1;
    private final CardRef card2;


    public CardRefPair(CardRef card1, CardRef card2) {
        this.card1 = card1;
        this.card2 = card2;
    }

    public CardRef getCard1() {
        return card1;
    }

    public CardRef getCard2() {
        return card2;
    }
}
