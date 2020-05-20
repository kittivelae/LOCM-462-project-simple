class Main {
    public static void main(String[] args) {
        Agent agent = new Agent();
        if(args[0].equals("draft")) {
        agent.draft();
        } else if (args[0].equals("play")) {
            agent.play();
        }
    }
}
