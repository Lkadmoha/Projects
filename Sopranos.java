import java.util.Random;
import java.util.Scanner;

public class Sopranos {
    public static void main(String[] args) {
        int BossRank = 1;
        int underBossRank = 2;
        int consigliereRank = 3;
        int captainRank = 4;
        int soldierRank = 5;

        Boss bossT = new Boss("Anthony Soprano", "Tony",
                returnSalaries(BossRank), "The real Boss of the family.");

        UnderBoss underS = new UnderBoss("Corrado John Soprano, Jr", "Junior",
                returnSalaries(underBossRank), "Underboss of the family, advises the Boss too.");

        Consigliere consigliereS = new Consigliere("Silvio Dante", "Sil",
                returnSalaries(consigliereRank), "Right hand of the Boss.");

        Capo captain0 = new Capo("Paulie Gualtieri", "Paulie",
                returnSalaries(captainRank), "Captain of a crew.");

        Capo captain1 = new Capo("Ralph Cifaretto", "Ralphie",
                returnSalaries(captainRank), "Captain of a crew.");

        Capo captain2 = new Capo("Vito Spatafore, Sr.", "Vince",
                returnSalaries(captainRank), "Captain of a crew.");

        Capo captain3 = new Capo("Cristopher Moltisanti", "Chrissy",
                returnSalaries(captainRank), "Captain of a crew.");

        Soldier soldier1 = new Soldier("Walden Belfiore", "/",
                returnSalaries(soldierRank), "Soldier of a crew.");

        Soldier soldier2 = new Soldier("Dante Greco", "Buddha",
                returnSalaries(soldierRank), "Soldier of a crew.");

        Soldier soldier3 = new Soldier("Benito Fazio, Jr.", "Benny",
                returnSalaries(soldierRank), "Soldier of a crew.");

        Soldier soldier4 = new Soldier("Paul Germani", "Little Paulie",
                returnSalaries(soldierRank), "Soldier of a crew.");

        Member[] C0Members = new Member[] { captain0, soldier1 };
        Crew crew0 = new Crew(captain0, captain0.nickName + "'s Crew", C0Members.length, C0Members);

        Member[] C1Members = new Member[] { captain1, soldier2 };
        Crew crew1 = new Crew(captain1, captain1.nickName + "'s Crew", C1Members.length, C1Members);

        Member[] C2Members = new Member[] { captain2, soldier3 };
        Crew crew2 = new Crew(captain2, captain2.nickName + "'s Crew", C2Members.length, C2Members);

        Member[] C3Members = new Member[] { captain3, soldier4 };
        Crew crew3 = new Crew(captain3, captain3.nickName + "'s Crew", C3Members.length, C3Members);

        captain0.soldiersPass(soldier1);
        captain1.soldiersPass(soldier2);
        captain2.soldiersPass(soldier3);
        captain3.soldiersPass(soldier4);

        boolean memberCreationError = true;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! Please choose what you'd like to do.");
        System.out.println("1. Pick a task");
        System.out.println("2. Work with current data.");

        while (true) {
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("1")) {
                Sleep.pause(600);
                System.out.println("\nOkay, pick a task!\n");
                Sleep.pause(800);
                System.out.print("1. Someone flipped.\n2. Someone doesn't pay.\n3. A Hit needs to be made.\n");
                while (true) {
                    String answer1 = input.nextLine();
                    if (answer1.equals("1") || answer1.equals("2")) {
                        Ranks.taskPick(answer1, captain2, captain3);
                        break;
                    } else if (answer1.equals("3")) {
                        aHitToMake(captain0, captain1, input, bossT, consigliereS);
                        break;
                    } else {
                        System.out.print("The value must be between 1 and 3, please try again\n");
                    }
                }
                input.close();
                break;
            }

            else if (answer.equalsIgnoreCase("2")) {
                System.out.println("What would you like to do with the data?");
                System.out.println("1. Read data\n2. Write data");
                while (true) {
                    String answer2 = input.nextLine();
                    if (answer2.equalsIgnoreCase("1")) {
                        System.out.println("Great! You selected 'Read'. What would you like to read?");
                        System.out.println("1. Crew\n2. Member");
                        while (true) {// start here
                            answer2 = input.nextLine();
                            if (answer2.equalsIgnoreCase("1")) {
                                ShowCrew.showCrews(crew0, crew1, crew2, crew3);
                                readCrew(crew0, crew1, crew2, crew3, input);
                                break;
                            } else if (answer2.equalsIgnoreCase("2")) {
                                System.out.println("Alright, which type of member would you like to read?");
                                System.out.println(" 1. Boss\n 2. Underboss\n 3. Consigliere\n 4. Capo\n 5. Soldier");
                                readMember(input, bossT, underS, consigliereS, captain0, captain1, captain2, captain3,
                                        soldier1, soldier2, soldier3, soldier4);
                                break;
                            } else
                                System.out.println("Please answer with '1' or '2' only!");
                        }
                        break;
                    } else if (answer2.equalsIgnoreCase("2")) {
                        System.out.println("Great! You selected 'Write'. What would you like to Create?");
                        System.out.println("1. Crew\n2. Member");
                        while (true) {
                            answer = input.nextLine();
                            if (answer.equalsIgnoreCase("1")) {
                                System.out.println("Great! So you want to create a Crew.");
                                Sleep.pause(800);
                                createCrew(input, captain0, captain1, captain2, captain3, soldier1, soldier2, soldier3,
                                        soldier4);
                                break;
                            } else if (answer.equalsIgnoreCase("2")) {
                                System.out.println("Great! So you want to create a Member.");
                                Sleep.pause(800);
                                System.out.println("What exact member would you like to create?");
                                Sleep.pause(600);
                                System.out.println("1. Boss\n2. UnderBoss\n3. Consigliere\n4. Captain\n5. Soldier");
                                while (memberCreationError) {
                                    answer2 = input.nextLine();
                                    switch (answer2) {
                                        case "1":
                                            createBoss(input, BossRank);
                                            memberCreationError = false;
                                            break;
                                        case "2":
                                            createUnderBoss(input, underBossRank);
                                            memberCreationError = false;
                                            break;
                                        case "3":
                                            createConsigliere(input, consigliereRank);
                                            memberCreationError = false;
                                            break;
                                        case "4":
                                            createCapo(input, captainRank);
                                            memberCreationError = false;
                                            break;
                                        case "5":
                                            createSoldier(input, soldierRank);
                                            memberCreationError = false;
                                            break;
                                        default:
                                            System.out.println("Only numbers 1 to 5 are allowed. Please try again.");
                                            break;
                                    }
                                }
                                break;
                            } else
                                System.out.println("Please answer only with 1 or 2");
                        }
                        break;
                    } else
                        System.out.println("Please answer with '1' or '2' only!");
                }
                input.close();
                break;
            }

            else
                System.out.println("Please answer with '1' or '2' only!");
        }
    }

    public static void readCrew(Crew a, Crew b, Crew c, Crew d, Scanner input) {
        boolean limits = true;
        Sleep.pause(700);
        System.out.println("\nWhich crew would you like to select?\n");
        while (limits) {
            String CrewWahl = input.nextLine();
            switch (CrewWahl) {
                case "1":
                    ShowCrew.returnCrew(a);
                    limits = false;
                    break;
                case "2":
                    ShowCrew.returnCrew(b);
                    limits = false;
                    break;
                case "3":
                    ShowCrew.returnCrew(c);
                    limits = false;
                    break;
                case "4":
                    ShowCrew.returnCrew(d);
                    limits = false;
                    break;
                default:
                    System.out.println("Please answer with a number between 1 and 4!");
                    break;
            }
        }

    }

    public static void readMember(Scanner Scan, Boss x, UnderBoss y, Consigliere z, Capo a, Capo b, Capo c, Capo d,
            Soldier... s) {
        boolean overLimit = true;
        boolean overLimitSwitch = true;
        while (overLimit) {
            int pickMember = Scan.nextInt();
            int pickSpecific;
            switch (pickMember) {
                case 1:
                    System.out.println("\nOkay, you picked 'Boss' here is the list of Bosses, Please pick one:\n");
                    ShowMember.showBosses(x);
                    while (overLimitSwitch) {
                        pickSpecific = Scan.nextInt();
                        if (pickSpecific == 1) {
                            ShowMember.returnBosses(x);
                            overLimitSwitch = false;
                        } else
                            System.out.println("You only have one option to choose from here!");
                    }
                    overLimit = false;
                    break;
                case 2:
                    System.out.println(
                            "\nOkay, you picked 'UnderBoss' here is the list of UnderBosses, Please pick one:\n");
                    ShowMember.showUnderBosses(y);
                    while (overLimitSwitch) {
                        pickSpecific = Scan.nextInt();
                        if (pickSpecific == 1) {
                            ShowMember.returnUnderBosses(y);
                            overLimitSwitch = false;
                        } else
                            System.out.println("You only have one option to choose from here!");
                    }
                    overLimit = false;
                    break;
                case 3:
                    System.out.println(
                            "\nOkay, you picked 'Consigliere' here is the list of Consiglieries, Please pick one:\n");
                    ShowMember.showConsiglieries(z);
                    while (overLimitSwitch) {
                        pickSpecific = Scan.nextInt();
                        if (pickSpecific == 1) {
                            ShowMember.returnConsiglieries(z);
                            overLimitSwitch = false;
                        } else
                            System.out.println("You only have one option to choose from here!");
                    }
                    overLimit = false;
                    break;
                case 4:
                    System.out.println("\nOkay, you picked 'Capo' here is the list of Capos, Please pick one:\n");
                    ShowMember.showCapos(a, b, c, d);
                    while (overLimitSwitch) {
                        pickSpecific = Scan.nextInt();
                        if (pickSpecific == 1) {
                            ShowMember.returnCapos(a);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 2) {
                            ShowMember.returnCapos(b);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 3) {
                            ShowMember.returnCapos(c);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 4) {
                            ShowMember.returnCapos(d);
                            overLimitSwitch = false;
                        } else
                            System.out.println("Please only select from the available options (1-4)!");
                    }
                    overLimit = false;
                    break;
                case 5:
                    Sleep.pause(500);
                    System.out.println("\nOkay, you picked 'Soldier' here is the list of Soldiers, Please pick one:\n");
                    ShowMember.showSoldiers(s[0], s[1], s[2], s[3]);
                    while (overLimitSwitch) {
                        pickSpecific = Scan.nextInt();
                        if (pickSpecific == 1) {
                            ShowMember.returnSoldiers(s[0]);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 2) {
                            ShowMember.returnSoldiers(s[1]);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 3) {
                            ShowMember.returnSoldiers(s[2]);
                            overLimitSwitch = false;
                        } else if (pickSpecific == 4) {
                            ShowMember.returnSoldiers(s[3]);
                            overLimitSwitch = false;
                        } else
                            System.out.println("Please only select from the available options (1-4)!");
                    }
                    overLimit = false;
                    break;
                default:
                    System.out.println("\nPlease respond with a number between 1 and 5.");
                    break;
            }
        }
    }

    public static void createCrew(Scanner Scan, Capo a, Capo b, Capo c, Capo d, Soldier... s) {
        boolean mainWhile = true;
        while (mainWhile) {
            Capo picked = null;
            Member[] pickedM = new Member[3];
            int totalMembers = pickedM.length;
            Soldier sold1 = null;
            Soldier sold2 = null;
            boolean capoPick = true;
            boolean soldierPick = true;
            System.out.println("First of all, what would you like to call the Crew?");
            String crewName = Scan.nextLine();
            Sleep.pause(650);
            System.out.println("Okay, who is going to be the captain of this Crew?");
            ShowMember.showCapos(a, b, c, d);
            String crewCaptain = Scan.nextLine();
            while (capoPick) {
                if (crewCaptain.equalsIgnoreCase("1")) {
                    picked = a;
                    pickedM[0] = a;
                    capoPick = false;
                } else if (crewCaptain.equalsIgnoreCase("2")) {
                    picked = b;
                    pickedM[0] = b;
                    capoPick = false;
                } else if (crewCaptain.equalsIgnoreCase("3")) {
                    picked = c;
                    pickedM[0] = c;
                    capoPick = false;
                } else if (crewCaptain.equalsIgnoreCase("4")) {
                    picked = d;
                    pickedM[0] = d;
                    capoPick = false;
                } else
                    System.out.println("Only numbers 1 to 4 are allowed. Please try again.");
            }
            Sleep.pause(650);
            System.out.println("\nOkay! Now pick the Soldiers that are part of the Crew.");
            Sleep.pause(1150);
            System.out.println("Combo 1: " + s[0].name + " and " + s[1].name);
            Sleep.pause(350);
            System.out.println("Combo 2: " + s[1].name + " and " + s[2].name);
            Sleep.pause(350);
            System.out.println("Combo 3: " + s[2].name + " and " + s[3].name);
            Sleep.pause(350);
            System.out.println("Combo 4: " + s[3].name + " and " + s[0].name);
            String SoldPick1 = Scan.nextLine();
            while (soldierPick) {
                switch (SoldPick1) {
                    case "1":
                        sold1 = s[0];
                        sold2 = s[1];
                        pickedM[1] = s[0];
                        pickedM[2] = s[1];
                        soldierPick = false;
                        break;
                    case "2":
                        sold1 = s[1];
                        sold2 = s[2];
                        pickedM[1] = s[1];
                        pickedM[2] = s[2];
                        soldierPick = false;
                        break;
                    case "3":
                        sold1 = s[2];
                        sold2 = s[3];
                        pickedM[1] = s[2];
                        pickedM[2] = s[3];
                        soldierPick = false;
                        break;
                    case "4":
                        sold1 = s[3];
                        sold2 = s[0];
                        pickedM[1] = s[3];
                        pickedM[2] = s[0];
                        soldierPick = false;
                        break;
                    default:
                        System.out.println("Please pick only a Number between 1 and 4");
                        break;
                }
            }
            System.out.println("\nNice! Here is the information you provided.");
            Sleep.pause(1000);
            System.out.println("Crewname: " + crewName);
            Sleep.pause(850);
            System.out.println("Captain of the Crew: " + picked.name);
            Sleep.pause(850);
            System.out.println("Total members of Crew: " + totalMembers);
            Sleep.pause(850);
            System.out.println("Member 1: " + picked.name + " (Captain)");
            Sleep.pause(350);
            System.out.println("Member 2: " + sold1.name + " (Soldier)");
            Sleep.pause(350);
            System.out.println("Member 3: " + sold2.name + " (Soldier)");
            Sleep.pause(850);
            System.out.println("\nDoes everything match? (Yes/No)");
            while (true) {
                String matchCheck = Scan.nextLine();
                if (matchCheck.equalsIgnoreCase("Yes")) {
                    Crew UserCreated = new Crew(picked, crewName, pickedM.length, pickedM);
                    System.out.println("Creating Crew...");
                    Sleep.pause(700);
                    System.out.println("Confirmed! The Crew has been created.");
                    Warningsoff.offCrew(UserCreated);
                    mainWhile = false;
                    break;
                } else if (matchCheck.equalsIgnoreCase("No")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the Crew");
                            Crew UserCreated = new Crew(picked, crewName, pickedM.length, pickedM);
                            Sleep.pause(860);
                            System.out.println("Creating Crew...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The Crew has been created.");
                            Warningsoff.offCrew(UserCreated);
                            mainWhile = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please Answer only with 'Yes' or 'No'");
            }
        }
    }

    public static void createBoss(Scanner Scan, int rank) {
        boolean mainWhileBoss = true;
        while (mainWhileBoss) {
            String bossname;
            String nickname;
            double salary = returnSalaries(rank);
            String Description = "Boss of a family";
            Sleep.pause(890);
            System.out.println("Alright! You would like to create a Boss");
            Sleep.pause(800);
            System.out.println("For starters, What is the name of the Boss?");
            bossname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("What is the nickname of the Boss?");
            nickname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("Okay! Here is the information you provided");
            Sleep.pause(850);
            System.out.println("Boss's name: " + bossname);
            Sleep.pause(1000);
            System.out.println("Boss's nickname: " + nickname);
            Sleep.pause(1000);
            System.out.println("Boss's salary: " + salary + " Grand");
            Sleep.pause(1000);
            System.out.println("Description: " + Description);
            Sleep.pause(1000);
            System.out.println("Does everything match? Yes/No");
            while (true) {
                String confirm = Scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    Sleep.pause(900);
                    System.out.println("Creating Boss...");
                    Boss createdBoss = new Boss(bossname, nickname, salary, Description);
                    Sleep.pause(1000);
                    Warningsoff.offBoss(createdBoss);
                    System.out.println("Confirmed, the Boss has been created!");
                    mainWhileBoss = false;
                    break;
                } else if (confirm.equalsIgnoreCase("no")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the Boss");
                            Boss createdBoss = new Boss(bossname, nickname, salary, Description);
                            Sleep.pause(860);
                            System.out.println("Creating Boss...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The Boss has been created.");
                            Warningsoff.offBoss(createdBoss);
                            mainWhileBoss = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please only answer with 'Yes' or 'No'");
            }
        }
    }

    public static void createUnderBoss(Scanner Scan, int Rank) {
        boolean mainWhile = true;
        while (mainWhile) {
            String underbossname;
            String nickname;
            double salary = returnSalaries(Rank);
            String Description = "Underboss of the family, advises the Boss too";
            Sleep.pause(890);
            System.out.println("Alright! You would like to create a Underboss");
            Sleep.pause(800);
            System.out.println("For starters, What is the name of the Underboss?");
            underbossname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("What is the nickname of the Underboss?");
            nickname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("Okay! Here is the information you provided");
            Sleep.pause(850);
            System.out.println("Underboss's name: " + underbossname);
            Sleep.pause(1000);
            System.out.println("Underboss's nickname: " + nickname);
            Sleep.pause(1000);
            System.out.println("Underboss's salary: " + salary + " Grand");
            Sleep.pause(1000);
            System.out.println("Description: " + Description);
            Sleep.pause(1000);
            System.out.println("\nDoes everything match? Yes/No");
            while (true) {
                String confirm = Scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    Sleep.pause(900);
                    System.out.println("Creating UnderBoss...");
                    UnderBoss createdUnderBoss = new UnderBoss(underbossname, nickname, salary, Description);
                    Sleep.pause(1000);
                    Warningsoff.offUnderBoss(createdUnderBoss);
                    System.out.println("Confirmed, the UnderBoss has been created!");
                    mainWhile = false;
                    break;
                } else if (confirm.equalsIgnoreCase("no")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the UnderBoss");
                            UnderBoss createdUnderBoss = new UnderBoss(underbossname, nickname, salary, Description);
                            Sleep.pause(860);
                            System.out.println("Creating UnderBoss...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The UnderBoss has been created.");
                            Warningsoff.offUnderBoss(createdUnderBoss);
                            mainWhile = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please only answer with 'Yes' or 'No'");
            }
        }
    }

    public static void createConsigliere(Scanner Scan, int Rank) {
        boolean mainWhile = true;
        while (mainWhile) {
            String consigliersname;
            String nickname;
            double salary = returnSalaries(Rank);
            String Description = "Right hand of the Boss";
            Sleep.pause(890);
            System.out.println("Alright! You would like to create a Consigliere");
            Sleep.pause(800);
            System.out.println("For starters, What is the name of the Consigliere?");
            consigliersname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("What is the nickname of the consigliere?");
            nickname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("Okay! Here is the information you provided");
            Sleep.pause(850);
            System.out.println("Consigliere's name: " + consigliersname);
            Sleep.pause(1000);
            System.out.println("Consigliere's nickname: " + nickname);
            Sleep.pause(1000);
            System.out.println("Consiglier's salary: " + salary + " Grand");
            Sleep.pause(1000);
            System.out.println("Description: " + Description);
            Sleep.pause(1000);
            System.out.println("\nDoes everything match? Yes/No");
            while (true) {
                String confirm = Scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    Sleep.pause(900);
                    System.out.println("Creating Consigliere...");
                    Consigliere createdCons = new Consigliere(consigliersname, nickname, salary, Description);
                    Sleep.pause(1000);
                    Warningsoff.offConsigliere(createdCons);
                    System.out.println("Confirmed, the Consigliere has been created!");
                    mainWhile = false;
                    break;
                } else if (confirm.equalsIgnoreCase("no")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the Consigliere");
                            Consigliere createdCons = new Consigliere(consigliersname, nickname, salary, Description);
                            Sleep.pause(860);
                            System.out.println("Creating Consigliere...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The Consigliere has been created.");
                            Warningsoff.offConsigliere(createdCons);
                            mainWhile = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please only answer with 'Yes' or 'No'");
            }
        }
    }

    public static void createCapo(Scanner Scan, int Rank) {
        boolean mainWhile = true;
        while (mainWhile) {
            String caponame;
            String nickname;
            double salary = returnSalaries(Rank);
            String Description = "Captain of a crew";
            Sleep.pause(890);
            System.out.println("Alright! You would like to create a Captain");
            Sleep.pause(800);
            System.out.println("For starters, What is the name of the Captain?");
            caponame = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("What is the nickname of the Captain?");
            nickname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("Okay! Here is the information you provided");
            Sleep.pause(850);
            System.out.println("Captain's name: " + caponame);
            Sleep.pause(1000);
            System.out.println("Captain's nickname: " + nickname);
            Sleep.pause(1000);
            System.out.println("Captain's salary: " + salary + " Grand");
            Sleep.pause(1000);
            System.out.println("Description: " + Description);
            Sleep.pause(1000);
            System.out.println("\nDoes everything match? Yes/No");
            while (true) {
                String confirm = Scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    Sleep.pause(900);
                    System.out.println("Creating Captain...");
                    Capo createdCapo = new Capo(caponame, nickname, salary, Description);
                    Sleep.pause(1000);
                    Warningsoff.offCapo(createdCapo);
                    System.out.println("Confirmed, the Captain has been created!");
                    mainWhile = false;
                    break;
                } else if (confirm.equalsIgnoreCase("no")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the Captain");
                            Capo createdCapo = new Capo(caponame, nickname, salary, Description);
                            Sleep.pause(860);
                            System.out.println("Creating Captain...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The Captain has been created.");
                            Warningsoff.offCapo(createdCapo);
                            mainWhile = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please only answer with 'Yes' or 'No'");
            }
        }
    }

    public static void createSoldier(Scanner Scan, int Rank) {
        boolean mainWhile = true;
        while (mainWhile) {
            String soldiername;
            String nickname;
            double salary = returnSalaries(Rank);
            String Description = "Soldier of a crew";
            Sleep.pause(890);
            System.out.println("Alright! You would like to create a Soldier");
            Sleep.pause(800);
            System.out.println("For starters, What is the name of the Soldier?");
            soldiername = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("What is the nickname of the soldier?");
            nickname = Scan.nextLine();
            Sleep.pause(800);
            System.out.println("Okay! Here is the information you provided");
            Sleep.pause(850);
            System.out.println("Soldier's name: " + soldiername);
            Sleep.pause(1000);
            System.out.println("Soldier's nickname: " + nickname);
            Sleep.pause(1000);
            System.out.println("Soldier's salary: " + salary + " Grand");
            Sleep.pause(1000);
            System.out.println("Description: " + Description);
            Sleep.pause(1000);
            System.out.println("\nDoes everything match? Yes/No");
            while (true) {
                String confirm = Scan.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    Sleep.pause(900);
                    System.out.println("Creating Soldier...");
                    Soldier createdSold = new Soldier(soldiername, nickname, salary, Description);
                    Sleep.pause(1000);
                    Warningsoff.offSoldier(createdSold);
                    System.out.println("Confirmed, the Soldier has been created!");
                    mainWhile = false;
                    break;
                } else if (confirm.equalsIgnoreCase("no")) {
                    System.out.println("Would you like to start over?");
                    while (true) {
                        String userdesc = Scan.nextLine();
                        if (userdesc.equalsIgnoreCase("Yes")) {
                            break;
                        } else if (userdesc.equalsIgnoreCase("No")) {
                            System.out.println("Okay, proceeding to create the Soldier");
                            Soldier createdSold = new Soldier(soldiername, nickname, salary, Description);
                            Sleep.pause(860);
                            System.out.println("Creating Soldier...");
                            Sleep.pause(900);
                            System.out.println("Confirmed! The Soldier has been created.");
                            Warningsoff.offSoldier(createdSold);
                            mainWhile = false;
                            break;
                        } else
                            System.out.println("Please Answer only with 'Yes' or 'No'");
                    }
                    break;
                } else
                    System.out.println("Please only answer with 'Yes' or 'No'");
            }
        }
    }

    public static Double returnSalaries(int rank) {
        switch (rank) {
            case 1:
                return 100.000;
            case 2:
                return 50.000;
            case 3:
                return 12.000;
            case 4:
                return 40.000;
            case 5:
                return 20.000;
            default:
                return 2.000;
        }
    }

    public static void aHitToMake(Capo one, Capo two, Scanner input, Boss B, Consigliere S) {
        // capo 1 = paulie, capo 2 = Ralf
        System.out.println("Is the hit a high priority?\nYes/No");
        while (true) {
            String answer2 = input.nextLine();
            if (answer2.equalsIgnoreCase("Yes")) {
                System.out.println("Contacting the Boss...");
                Sleep.pause(2500);
                B.hearsOfEvent();
                Sleep.pause(2000);
                B.asksForAdvice(S, null);
                B.takesDesicions(null);
                B.picksCaptain(one, two);
                Sleep.pause(2000);
                break;
            } else if (answer2.equalsIgnoreCase("No")) {
                one.gotOrders(one);
                one.confirmsOrderDone();
                Sleep.pause(850);
                System.out.println("The Target is gone!\n");
                break;
            } else
                System.out.println("Answer only with Yes or No!");
        }
        input.close();
    }

    public static void taskPick(String answer1, Capo captain2, Capo captain3) {
        switch (answer1) {
            case "1":
                Sleep.pause(1000);
                captain2.gotOrders(captain2);
                captain2.confirmsOrderDone();
                Sleep.pause(850);
                System.out.println("The flipper has been dealt with!");
                break;
            case "2":
                Sleep.pause(1000);
                captain3.gotOrders(captain3);
                Sleep.pause(500);
                captain3.confirmsOrderDone();
                Sleep.pause(860);
                System.out.println("The Person has been dealt with and will pay from now on!\n");
                break;
        }
    }
}

abstract class Member {
    String name;
    String nickName;
    Double salary;
    String description;

    Member(String name, String nickName, Double salary, String description) {
        this.name = name;
        this.nickName = nickName;
        this.salary = salary;
        this.description = description;
    }
}

class Boss extends Member {
    Boss(String name, String nickName, Double salary, String description) {
        super(name, nickName, salary, description);
    }

    public void hearsOfEvent() {
        System.out.println("The Boss has been contacted and has been informed about the matter!");
    };

    public void asksForAdvice(Consigliere consigliereS, Sleep pause) {
        System.out.println("The Boss is asking the consigliere for advice...");
        Sleep.pause(3000);
        consigliereS.advisesOnMatters(null, consigliereS);
    }

    public void takesDesicions(Sleep pause) {
        System.out.println("The Boss has taken a decision.");
        Sleep.pause(2000);
        System.out.println("The Boss is picking a crew for the solution");
        Sleep.pause(3000);
    }

    public void picksCaptain(Capo capo1, Capo capo2) {
        Random cap = new Random();
        int pick = cap.nextInt(2) + 1;
        if (pick == 1) {
            System.out.println("The Boss Picked " + capo1.nickName + "'s crew for the job!");
            Sleep.pause(2000);
            capo1.gotOrders(capo1);
        } else {
            System.out.println("The Boss Picked " + capo2.nickName + "'s crew for the job!");
            Sleep.pause(2000);
            capo2.gotOrders(capo2);
        }
    }
}

class Consigliere extends Member {
    Consigliere(String name, String nickName, Double salary, String description) {
        super(name, nickName, salary, description);
    }

    public void advisesOnMatters(Sleep p, Consigliere s) {
        System.out.println("Consigliere " + "(" + s.nickName + ")" + " is giving his opinion...");
        Sleep.pause(2000);
    }
}

class UnderBoss extends Member {
    UnderBoss(String name, String nickName, Double salary, String description) {
        super(name, nickName, salary, description);
    }

    public void stepsUp() {
        System.out.println("Boss is in the can, so for now I step up");
    }
}

class Soldier extends Member {
    Soldier(String name, String nickName, Double salary, String description) {
        super(name, nickName, salary, description);
    }

    void gotOrders(Soldier s) {
        Sleep.pause(2000);
        System.out.println(s.name + " Executes the order given to him");
        Sleep.pause(2000);
    }
}

class Capo extends Member {
    private Soldier sold;

    Capo(String name, String nickName, Double salary, String description) {
        super(name, nickName, salary, description);
    }

    public void soldiersPass(Soldier a) {
        this.sold = a;
    }

    public void gotOrders(Capo picked) {
        System.out.println(picked.nickName + " got the order.");
        Sleep.pause(1000);
        calling(picked);
    }

    public void calling(Capo a) {
        System.out.println(a.nickName + " is Calling his soldiers to Execute the order.");
        Sleep.pause(1000);
        if (a.nickName == "Paulie") {
            sold.gotOrders(sold);
        } else if (a.nickName == "Ralphie") {
            sold.gotOrders(sold);
        } else if (a.nickName == "Vince") {
            sold.gotOrders(sold);
        }
    }

    void confirmsOrderDone() {
        Sleep.pause(1000);
        System.out.println("The order has been successfully executed!\n");
        Sleep.pause(1000);
    }
}

class Crew {
    String CrewName;
    Capo captainOfCrew;
    Member[] members;
    int totalMembers;

    Crew(Capo capo, String CrewName, int totalMembers, Member[] members) {
        this.captainOfCrew = capo;
        this.CrewName = CrewName;
        this.totalMembers = totalMembers;
        this.members = members;
    }
}

class ShowCrew {
    public static void returnCrew(Crew C) {
        int members_amount = C.members.length;
        System.out.println();
        Sleep.pause(1000);
        System.out.println("Crew name: " + C.CrewName);
        Sleep.pause(1500);
        System.out.println("Captain of the crew: " + C.captainOfCrew.name);
        Sleep.pause(1500);
        System.out.println("Total of Members: " + C.totalMembers + " Member" + (members_amount == 1 ? "" : "s"));
        Sleep.pause(1500);
        System.out.println("The Members are the following:");
        Sleep.pause(1500);
        for (Member member : C.members) {
            System.out.println(member.name);
            Sleep.pause(500);
        }
    }

    public static void showCrews(Crew a, Crew b, Crew c, Crew d) {
        Sleep.pause(1000);
        System.out.println("The available Crews are: ");
        Sleep.pause(500);
        System.out.println("1. " + a.CrewName);
        Sleep.pause(500);
        System.out.println("2. " + b.CrewName);
        Sleep.pause(500);
        System.out.println("3. " + c.CrewName);
        Sleep.pause(500);
        System.out.println("4. " + d.CrewName);
    }
}

class ShowMember {
    public static void showBosses(Boss a) {
        Sleep.pause(1500);
        System.out.println("1. " + a.name);
    }

    public static void returnBosses(Boss a) {
        Sleep.pause(800);
        System.out.println("Full name: " + a.name);
        Sleep.pause(800);
        System.out.println("nickname: " + a.nickName);
        Sleep.pause(800);
        System.out.println("Salary: " + a.salary);
        Sleep.pause(800);
        System.out.println("Description: " + a.description);
        Sleep.pause(800);
    }

    public static void showUnderBosses(UnderBoss a) {
        Sleep.pause(1500);
        System.out.println("1. " + a.name);
    }

    public static void returnUnderBosses(UnderBoss a) {
        Sleep.pause(800);
        System.out.println("Full name: " + a.name);
        Sleep.pause(800);
        System.out.println("nickname: " + a.nickName);
        Sleep.pause(800);
        System.out.println("Salary: " + a.salary);
        Sleep.pause(800);
        System.out.println("Description: " + a.description);
        Sleep.pause(800);
    }

    public static void showConsiglieries(Consigliere a) {
        Sleep.pause(1500);
        System.out.println("1. " + a.name);
    }

    public static void returnConsiglieries(Consigliere a) {
        Sleep.pause(800);
        System.out.println("Full name: " + a.name);
        Sleep.pause(800);
        System.out.println("nickname: " + a.nickName);
        Sleep.pause(800);
        System.out.println("Salary: " + a.salary);
        Sleep.pause(800);
        System.out.println("Description: " + a.description);
        Sleep.pause(800);
    }

    public static void showCapos(Capo a, Capo b, Capo c, Capo d) {
        Sleep.pause(950);
        System.out.println("1. " + a.name);
        Sleep.pause(850);
        System.out.println("2. " + b.name);
        Sleep.pause(850);
        System.out.println("3. " + c.name);
        Sleep.pause(850);
        System.out.println("4. " + d.name);
        Sleep.pause(850);
    }

    public static void returnCapos(Capo a) {
        Sleep.pause(800);
        System.out.println("Full name: " + a.name);
        Sleep.pause(800);
        System.out.println("nickname: " + a.nickName);
        Sleep.pause(800);
        System.out.println("Salary: " + a.salary);
        Sleep.pause(800);
        System.out.println("Description: " + a.description);
        Sleep.pause(800);
    }

    public static void showSoldiers(Soldier a, Soldier b, Soldier c, Soldier d) {
        Sleep.pause(1500);
        System.out.println("1. " + a.name);
        Sleep.pause(850);
        System.out.println("2. " + b.name);
        Sleep.pause(850);
        System.out.println("3. " + c.name);
        Sleep.pause(850);
        System.out.println("4. " + d.name);
        Sleep.pause(850);
    }

    public static void returnSoldiers(Soldier a) {
        Sleep.pause(800);
        System.out.println("Full name: " + a.name);
        Sleep.pause(800);
        System.out.println("nickname: " + a.nickName);
        Sleep.pause(800);
        System.out.println("Salary: " + a.salary);
        Sleep.pause(800);
        System.out.println("Description: " + a.description);
        Sleep.pause(800);
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

class Warningsoff {
    // this are simply methods to turn off the warning "unused variable".
    // they do nothing.

    public static void offCrew(Crew a) {
    }

    public static void offBoss(Boss a) {
    }

    public static void offUnderBoss(UnderBoss a) {
    }

    public static void offConsigliere(Consigliere a) {
    }

    public static void offCapo(Capo a) {
    }

    public static void offSoldier(Soldier a) {
    }
}