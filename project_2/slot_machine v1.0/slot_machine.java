import java.util.Scanner;
import java.util.Random;

public class slot_machine {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] numbers = new int[7];
        int credit = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("\nWelcome to the Slot Machine!");
        // Sleep.pause(600);
        System.out.println("\nThere are multiple prizes you can win:\n");
        // Sleep.pause(1000);
        System.out.println("    *Double Match: 2 slots with the same number -> 50 Credits.");
        System.out.println("    *Escalade: 3 consecutive numbers -> 100 Credits");
        System.out.println("    *Jackpot: 3 slots with the same number -> 300 Credits.");
        System.out.println("    *Jackpot of Jackpots: triple 7s -> 500 Credits.");
        // Sleep.pause(700);
        System.out.println("\nReady to test your luck? Type 'Start' to spin or 'Exit' to leave.");

        while (true) {
            String answer = myScanner.nextLine();
            if (answer.equalsIgnoreCase("start")) {
                System.out.println("Nice! Let's start\n");
                while (true) {
                    credit = spin(numbers, credit);
                    String again = myScanner.nextLine();
                    if (again.equalsIgnoreCase("Y")) {
                        System.out.println("\nNice! Let's go for another spin!");
                        Sleep.pause(1000);
                    } else if (again.equalsIgnoreCase("N")) {
                        System.out.println("\nThanks for playing! See you next time!");
                        break;
                    } else
                        System.out.println("\nPlease answer only with 'Y' or 'N'");
                }
                break; // for the main while
            } else if (answer.equalsIgnoreCase("exit")) {
                System.out.println("\nThanks for playing! See you next time!");
                break; // for the main while
            } else
                System.out.println("\nPlease answer only with 'Start' or 'Exit'!");
        }
        myScanner.close();
    }

    static int spin(int[] arr, int credit) {
        int[] result = new int[3];
        Random slots = new Random();
        result[0] = slots.nextInt(7) + 1;
        result[1] = slots.nextInt(7) + 1;
        result[2] = slots.nextInt(7) + 1;
        System.out.println("\nSpinning...");
        Sleep.pause(900);
        slot_machine.printResult(result);
        Sleep.pause(900);
        if ((result[0] == result[1] && result[1] == result[2]) && result[0] != 7) {
            credit = credit + 300;
            System.out.println("\nYou hit the jackpot! Can you make it two in a row? [Y/N]");
            System.out.println("Current credit: " + credit);
        } else if ((result[0] == result[1] && result[1] == result[2]) && result[0] == 7) {
            credit = credit + 500;
            System.out.println("JACKPOT OF JACKPOTS! Triple 7s! You're unstoppable!");
            System.out.println("Current credit: " + credit);
            System.out.println("Care to test your luck again? [Y/N]");
        } else if (result[0] == result[1] || result[0] == result[2] || result[1] == result[2]) {
            credit = credit + 50;
            System.out.println("\nDouble Match - You win half the prize!");
            System.out.println("Current credit: " + credit);
            System.out.println("Dare to go for the full win? [Y/N]");
        } else if ((result[1] == result[0] + 1) && (result[2] == result[0] + 2)) {
            credit = credit + 100;
            System.out.println("\nEscalade! Not bad — luck's warming up!\"");
            System.out.println("Current credit: " + credit);
            System.out.println("Want to go for a bigger prize? [Y/N]");
        } else {
            System.out.println("\nNo matches!");
            System.out.println("Current credit: " + credit);
            System.out.println("Try your luck again? [Y/N]");
        }
        return credit;
    }

    public static void printResult(int[] result) {
        System.out.println("----------------------------");
        System.out.println("| Slot 1 | Slot 2 | Slot 3 |");
        System.out.println("|--------------------------|");
        System.out.println("|    " + result[0] + "   |    " + result[1] + "   |    " + result[2] + "   |");
        System.out.println("----------------------------");
    }
}

class Sleep {
    static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}