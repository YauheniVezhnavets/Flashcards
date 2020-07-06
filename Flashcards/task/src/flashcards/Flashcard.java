package flashcards;

import java.io.*;
import java.util.*;


class Flashcard {
    
    private static Map<String, String> flashcard = new HashMap<>();
    private static TreeMap<String, Integer> errors = new TreeMap<>();
    private static ArrayList<String> errorKeys = new ArrayList<>();
    private static ArrayList<String> logs = new ArrayList<>();


    public static void start(String [] strings) {
        boolean b = true;
        while (b) {
            showOutput("\nInput the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String choice = getInput();
            switch (choice) {
                case "add":
                    addCard();
                    break;
                case "remove":
                    removeCard();
                    break;
                case "import":
                    for(int i=0;i<strings.length;i++) {
                        if (strings[i].equals("-import".toLowerCase())) {
                            importCardFromFile(strings[i+1]);
                        }
                    }
                    break;
                case "export":
                    for(int i=0;i<strings.length;i++) {
                        if (strings[i].equals("-import".toLowerCase())) {
                            exportCardToFile(strings[i+1]);
                        }
                    }
                    break;
                case "ask":
                    askQuestion();
                    break;
                case "exit":
                    exit();
                    b = false;
                    break;
                case "log":
                    log();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
            }
        }
    }

    private static void addCard() {
        showOutput("The card:");
        String cardTerm = getInput();
        if (flashcard.containsKey(cardTerm)) {
            showOutput("The card \"" + cardTerm + "\" already exists.");
        } else {
            showOutput("The definition of the card:");
            String cardDefinition = getInput();
            if (flashcard.containsValue(cardDefinition)) {
                showOutput("The definition \"" + cardDefinition + "\" already exists.");
            } else {
                flashcard.put(cardTerm, cardDefinition);
                showOutput("The pair (\"" + cardTerm + "\":\"" + cardDefinition + "\") has been added.");
            }
        }
    }

    private static void removeCard() {
        showOutput("The card:");
        String cardTerm = getInput();
        if (flashcard.containsKey(cardTerm)) {
            flashcard.remove(cardTerm);
            errors.remove(cardTerm);
            showOutput("The card has been removed.");
        } else {
            showOutput("Can't remove \"" + cardTerm + "\": there is no such card.");
        }


    }

    private static void importCardFromFile(String string) {
        int count = 0;
        showOutput(string);
      //  String fileName = getInput();
        File file = new File(string);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String cardTerm = scan.nextLine();
                String cardDefinition = scan.nextLine();
                flashcard.put(cardTerm, cardDefinition);
                count++;
            }
            showOutput(count + " cards have been loaded.");
        } catch (Exception e) {
            showOutput("File not found.");
        }

        File errorfile = new File("errors.txt");
        try (Scanner scan = new Scanner(errorfile)) {
            while (scan.hasNextLine()) {
                String cardTerm = scan.nextLine();
                int numberOfErrors = Integer.parseInt(scan.nextLine());
                errors.put(cardTerm, numberOfErrors);
            }
        } catch (Exception e) {

        }


    }

    private static void exportCardToFile(String string) {
        int count = 0;
        showOutput(string);
     //   String fileName = getInput();
        File file = new File(string);
        try (FileWriter fw = new FileWriter(file)) {
            for (var v : flashcard.entrySet()) {
                fw.write(v.getKey() + "\n" + v.getValue() + "\n");
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File errorfile = new File("errors.txt");
        try (FileWriter errorfw = new FileWriter(errorfile)) {
            for (var v : errors.entrySet()) {
                errorfw.write(v.getKey() + "\n" + v.getValue() + "\n");
            }
        } catch (Exception e) {

        }

        showOutput(count + " cards have been saved.");

    }

    private static void askQuestion() {
        showOutput("How many times to ask?");
        int askNumber = Integer.parseInt(getInput());
        int i = 0;
        Random random = new Random();
        String[] randomCard = new String[flashcard.size()];

        for (var v : flashcard.entrySet()) {
            randomCard[i] = v.getKey();
            i++;
        }

        for (int j = 0; j < askNumber; j++) {
            int keyIndex = random.nextInt(randomCard.length);
            String key = randomCard[keyIndex];
            showOutput("Print the definition of \"" + key + "\":");
            String userAnswer = getInput();
            if (flashcard.get(key).equals(userAnswer)) {
                showOutput("Correct answer");
            } else {
                newerror(key);
                if (flashcard.containsValue(userAnswer)) {
                    for (var value : flashcard.entrySet()) {
                        String keys = value.getKey();
                        if (flashcard.get(keys).equals(userAnswer)) {
                            showOutput("Wrong answer. The correct one is \"" + flashcard.get(key) + "\", you've just written the definition of \"" + keys + "\".");
                        }
                    }
                } else {
                    showOutput("Wrong answer. The correct one is \"" + flashcard.get(key) + "\".");

                }
            }
        }
    }

    private static void exit() {
        showOutput("Bye bye!");
    }


    private static void log() {
        showOutput("File name:");
        String logFileName = getInput();
        try (FileWriter fw = new FileWriter(logFileName)) {
            for (String s : logs) {
                fw.write(s + "\n");
            }
            showOutput("The log has been saved.");
        } catch (Exception e) {
            showOutput("File not Found");
        }

    }


    private static void hardestCard() {
        if (errors.isEmpty()) {
            showOutput("There are no cards with errors.");
        } else {
            int initialValue = 0;
            for (var v : errors.entrySet()) {
                String key = v.getKey();
                if (errors.get(key) > initialValue) {
                    errorKeys.clear();
                    initialValue = errors.get(key);
                    errorKeys.add(key);
                } else if (errors.get(key) == initialValue) {
                    errorKeys.add(key);
                }
            }
            if (errorKeys.size() == 1) {
                showOutput("The hardest card is \"" + errorKeys.get(0) + "\". You have " + errors.get(errorKeys.get(0)) + " errors answering it.");
            } else {
                showOneLineOutput("The hardest cards are ");
                for (int i = 0; i < errorKeys.size(); i++) {
                    if (i == errorKeys.size() - 1) {
                        showOneLineOutput("\"" + errorKeys.get(i) + "\".");
                    } else {
                        showOneLineOutput("\"" + errorKeys.get(i) + "\", ");
                    }

                }
                showOneLineOutput("You have " + errors.get(errorKeys.get(0)) + " errors answering them.");

            }
        }

    }

    private static void resetStats() {
        errors.clear();
        showOutput("Card statistics has been reset.");
    }

    private static void newerror(String key) {
        if (errors.containsKey(key)) {
            errors.put(key, errors.get(key) + 1);
        } else {
            errors.put(key, 1);
        }
    }

    private static void showOutput(String output) {
        logs.add(output);
        System.out.println(output);
    }

    private static void showOneLineOutput(String s) {
        logs.add(s);
        System.out.print(s);
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        logs.add(s);
        return s;
    }

}
