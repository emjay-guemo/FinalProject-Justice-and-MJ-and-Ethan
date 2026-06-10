public abstract class CasinoGame {

    String options = """
            Games in the Casino:
            Press B for Blackjack
            Press W for War
            Press P for Poker
            Press E exit
            """;

    public void gameRun(){

        while(true){

            System.out.println(options);

            String choice = Input.getUserString("Please select your choice: ");

            if (choice.equalsIgnoreCase("P")) {
                Poker poker = new Poker();
                poker.play();
            }

            else if (choice.equalsIgnoreCase("E")) {
                break;
            }

        }
    }
}
