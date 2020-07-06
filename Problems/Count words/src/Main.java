import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;


class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                stringBuilder.append((char) i);
            }
            String str = stringBuilder.toString().trim();
            if (str.isBlank()) {
                System.out.println(0);
            } else {
                String[] str2 = str.split("\\s+");
                System.out.println(str2.length);
            }
        }
    }
}
