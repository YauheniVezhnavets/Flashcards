// Posted from EduTools plugin
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int[] mas = new int[n];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        Arrays.sort(mas);

        System.out.println(mas[mas.length - 1] * mas[mas.length - 2]);
    }
}