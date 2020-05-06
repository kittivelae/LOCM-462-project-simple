public class Agent {

    private State state;

    void read() {
        for (int i = 0; i < 2; i++) {
            Player player = state.getPlayerX(i);
            player.setHp(int in.nextInt());
            player.setMana(int in.nextInt());
            player.setCardsRemaining(int in.nextInt())
            //player.setRune(int in.nextInt())
            //player.setDraw(int in.nextInt())
        }
        int opponentHand = in.nextInt();
        int opponentActions = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < opponentActions; i++) {
            String cardNumberAndAction = in.nextLine();
        }
        int cardCount = in.nextInt();
        for (int i = 0; i < cardCount; i++) {
            int cardNumber = in.nextInt();
            int instanceId = in.nextInt();
            int location = in.nextInt();
            int cardType = in.nextInt();
            int cost = in.nextInt();
            int attack = in.nextInt();
            int defense = in.nextInt();
            String abilities = in.next();
            int myHealthChange = in.nextInt();
            int opponentHealthChange = in.nextInt();
            int cardDraw = in.nextInt();
        }
    }
}