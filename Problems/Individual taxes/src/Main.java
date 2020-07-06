// Posted from EduTools plugin
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Try again");
        } else {


            double[] mas = new double[n];
            double[] percent = new double[n];
            double[] taxes = new double[n];


            for (int i = 0; i < mas.length; i++) {
                mas[i] = scanner.nextInt();
            }
            for (int i = 0; i < percent.length; i++) {
                percent[i] = scanner.nextInt();
            }
            for (int i = 0; i < taxes.length; i++) {
                taxes[i] = (mas[i] * percent[i]) / 100;
            }
            double max = taxes[0];
            int number = 0;
            for (int i = 1; i < taxes.length; i++) {
                if (max < taxes[i]) {
                    max = taxes[i];
                    number = i;
                }
            }
            System.out.println(number + 1);
        }
    }
}