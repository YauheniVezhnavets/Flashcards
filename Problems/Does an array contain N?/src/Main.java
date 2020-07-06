// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        boolean b = false;
        int number = scanner.nextInt();
        for (int x : mas) {
            if (x == number) {
                b = true;
                break;
            }
        }
        System.out.println(b);
    }
}