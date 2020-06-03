public class Diff {
    //for this difficulty only diff that will occur is card health
    //quantity will need to take boolean values at higher difficulties

    public final CardField cardField;
    public int quantity; //for this difficulty only diff that will occur is card health

    public Diff(CardField cardField, int quantity) {
        this.quantity = quantity;
        this.cardField = cardField;
    }

    public CardField getCardField() {
        return cardField;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
