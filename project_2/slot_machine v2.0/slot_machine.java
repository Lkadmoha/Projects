import java.util.Scanner;
import java.util.Random;

public class slot_machine {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] numbers = new int[7];
        int credit = 0;
        int spinsAvailable = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("\nWelcome to the Slot Machine!");
        System.out.println("\nThere are multiple prizes you can win:\n");
        System.out.println("    *Double Match: 2 slots with the same number -> 50 Credits.");
        System.out.println("    *Escalade: 3 consecutive numbers -> 100 Credits");
        System.out.println("    *Jackpot: 3 slots with the same number -> 300 Credits.");
        System.out.println("    *Jackpot of Jackpots: triple 7s -> 500 Credits.");
        System.out.println("\nReady to test your luck? Type 'Start' to spin or 'Exit' to leave.");

        while (true) {
            String answer = myScanner.nextLine();
            if (answer.equalsIgnoreCase("start")) {
                System.out.println("\nNice! Let's start\n");
                System.out.println("First of all, pick the amount of credit you would like to use:");
                System.out.println("    50 Credits -> 2 spins");
                System.out.println("    100 Credits -> 3 spins");
                System.out.println("    200 Credits -> 6 spins\n");

                while (true) {
                    String creditPick = myScanner.nextLine();
                    if (creditPick.equalsIgnoreCase("50")) {
                        spinsAvailable = 2;
                        System.out.println("Nice! you get to spin " + spinsAvailable + " times.");
                        break;
                    } else if (creditPick.equalsIgnoreCase("100")) {
                        spinsAvailable = 3;
                        System.out.println("Nice! you get to spin " + spinsAvailable + " times.");
                        break;
                    } else if (creditPick.equalsIgnoreCase("200")) {
                        spinsAvailable = 6;
                        System.out.println("Nice! you get to spin " + spinsAvailable + " times.\n");
                        break;
                    } else
                        System.out.println("Please answer only with 50, 100 or 200!");
                }
                while (spinsAvailable != 0) {
                    spinsAvailable--;
                    Sleep.pause(1500);
                    credit = spin(numbers, credit, spinsAvailable);
                }
                System.out.println("Looks like you're out of spins! Add some credits and keep the fun going!\n");
                break; // for the main while
            } else if (answer.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! See you next time!");
                break; // for the main while
            } else {
                System.out.println("Please answer only with 'Start' or 'Exit'!");
            }
        }
        myScanner.close();
    }

    static int spin(int[] arr, int credit, int spinsAvailable) {
        int[] result = new int[3];
        Random slots = new Random();
        result[0] = slots.nextInt(7) + 1;
        result[1] = slots.nextInt(7) + 1;
        result[2] = slots.nextInt(7) + 1;
        System.out.println("Spinning...");
        Sleep.pause(1200);
        slot_machine.printResult(result);
        Sleep.pause(500);

        if ((result[0] == result[1] && result[1] == result[2]) && result[0] != 7) {
            credit = credit + 300;
            System.out.println("\nYou hit the jackpot!");
            Sleep.pause(500);
            System.out.println("Current credit: " + credit);
            Sleep.pause(500);
            System.out.println("Amount of spins remaining: " + spinsAvailable + "\n");
        } else if ((result[0] == result[1] && result[1] == result[2]) && result[0] == 7) {
            credit = credit + 500;
            System.out.println("JACKPOT OF JACKPOTS! Triple 7s! You're unstoppable!");
            Sleep.pause(500);
            System.out.println("Current credit: " + credit);
            Sleep.pause(500);
            System.out.println("Amount of spins remaining: " + spinsAvailable + "\n");
        } else if (result[0] == result[1] || result[0] == result[2] || result[1] == result[2]) {
            credit = credit + 50;
            System.out.println("\nDouble Match - You win half the prize!");
            Sleep.pause(500);
            System.out.println("Current credit: " + credit);
            Sleep.pause(500);
            System.out.println("Amount of spins remaining: " + spinsAvailable + "\n");
        } else if ((result[1] == result[0] + 1) && (result[2] == result[0] + 2)) {
            credit = credit + 100;
            System.out.println("\nEscalade! Not bad, luck's warming up!\"");
            Sleep.pause(500);
            System.out.println("Current credit: " + credit);
            Sleep.pause(500);
            System.out.println("Amount of spins remaining: " + spinsAvailable + "\n");
        } else {
            System.out.println("\nNo matches!");
            Sleep.pause(500);
            System.out.println("Current credit: " + credit);
            Sleep.pause(500);
            System.out.println("Amount of spins remaining: " + spinsAvailable + "\n");
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
