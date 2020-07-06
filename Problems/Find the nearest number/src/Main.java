import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOutput = new ArrayList<>();
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int min = 1000;

        int number = scanner.nextInt();

        for (int i = 0; i < ints.length; i++) {
            int difference = Math.abs(number - ints[i]);
            if (difference < min) {
                min = difference;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (Math.abs(number - ints[i]) == min) {
                listOutput.add(ints[i]);
            }
        }
        Collections.sort(listOutput);
        for (int i : listOutput) {
            System.out.print(i + " ");
        }
    }
}