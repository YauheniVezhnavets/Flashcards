import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        System.out.println(str1);
        System.out.println(str2);
        String[] str = str3.split(" ");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}