import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        scanner.nextLine();
        Set<String> knownWords = new HashSet<>();
        for (int i = 0; i < d; i++) {
            knownWords.add(scanner.next().toLowerCase());
        }
        int l = scanner.nextInt();
        scanner.nextLine();
        Set<String> text = new HashSet<>();

        for (int i = 0; i < l; i++) {
            text.addAll(List.of(scanner.nextLine().toLowerCase().split("\\s+")));
        }
        for (String s : text) {
           if (!knownWords.contains(s)) {
               System.out.println(s);
           }
        }
    }
}