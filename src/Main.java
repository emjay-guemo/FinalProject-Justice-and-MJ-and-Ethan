import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Player player = new Player("Player");
        System.out.println("Current Balance: $" + player.getChips()); // (Player will start with 1000$ controlled by Player class)

        // Controls whether casino is still running
        boolean running = true;

        // Welcome Message
        System.out.println("===================================");
        System.out.println("     WELCOME TO JAVA CASINO");
        System.out.println("   By: Justice, MJ, and Ethan");
        System.out.println("===================================");


        // Main casino menu loop
        while (running) {

            System.out.println();
            System.out.println("Current Balance: $" + player.getChips());

            // Check if player is broke
            if (player.getChips() <= 0) {
                System.out.println("===================================");
                System.out.println("You are out of money!");
                System.out.println("Game Over.");
                System.out.println("===================================");
                running = false;
                break;

                System.out.println();
                System.out.println("Choose a game:");
                System.out.println("1. Poker");
                System.out.println("2. Blackjack");
                System.out.println("3. War");
                System.out.println("4. Exit");
                System.out.print("Choice: ");

                int choice = input.nextInt();
                int bet;

                switch (choice) {

                    // Poker
                    case 1:

                        bet = getBet(input, player);

                        Poker poker = new Poker(player);

                        boolean pokerWon = poker.play();

                        if (pokerWon) {
                            player.addChips(bet);
                            System.out.println("You won $" + bet + "!");
                        } else {
                            player.removeChips(bet);
                            System.out.println("You lost $" + bet + "!");
                        }

                        break;

                    // Blackjack
                    case 2:

                        bet = getBet(input, player);

                        Blackjack blackjack = new Blackjack(player);

                        boolean blackjackWon = blackjack.play();

                        if (blackjackWon) {
                            player.addChips(bet);
                            System.out.println("You won $" + bet + "!");
                        } else {
                            player.removeChips(bet);
                            System.out.println("You lost $" + bet + "!");
                        }

                        break;

                    // War
                    case 3:

                        bet = getBet(input, player);

                        War war = new War(player);

                        boolean warWon = war.play();

                        if (warWon) {
                            player.addChips(bet);
                            System.out.println("You won $" + bet + "!");
                        } else {
                            player.removeChips(bet);
                            System.out.println("You lost $" + bet + "!");
                        }

                        break;

                    // Exit
                    case 4:
                        running = false;
                        System.out.println("Thanks for playing, come again!");
                        break;

                    // Invalid Input
                    default:
                        System.out.println("Invalid choice, please enter a valid option.");
                }
            }
            input.close();
        }
    }

    // Handles all betting logic in one place
    public static int getBet(Scanner input, Player player) {

        int bet;

        while (true) {

            // Ask how much the player wants to bet
            System.out.print("Enter your bet: $");
            bet = input.nextInt();

            // Check if bet is valid
            if (bet <= 0) {
                System.out.println("Invalid bet. Try again.");
            }
            else if (bet > player.getChips()) {
                System.out.println("You don't have enough chips!");
            }
            else {
                return bet; // valid bet
            }
        }
    }
}