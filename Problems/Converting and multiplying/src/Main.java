import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = null;
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            if ("0".equals(str)) {
                break;
            }
            list.add(str);

        }
        for (String s : list) {
            checkNumber(s);
        }
    }

    public static void checkNumber(String str) {
        try {
            int n = Integer.parseInt(str) * 10;
            System.out.println(n);
        } catch (Exception e) {
            System.out.println("Invalid user input: " + str);
        }
    }
}