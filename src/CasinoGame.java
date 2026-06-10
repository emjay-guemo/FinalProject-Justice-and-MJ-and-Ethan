public abstract class CasinoGame {
    String options = """
            Games in the Casino:
            Press B for Blackjack
            Press W for War
            Press P for Poker
            Press E exit
            """;

    public void gameRun(){
        while (true){
            System.out.println(options);
            Input.getUserString("Please select your choice: ");


        }
    }
}
