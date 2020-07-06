import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);
        int count = 0;
        int sum = 0;

        do {
            sum += random.nextInt(b - a + 1) + a;
            count++;
        }
        while (count != n);
        System.out.println(sum);
    }
}