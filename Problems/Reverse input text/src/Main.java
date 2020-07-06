import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List <Character> chars = new ArrayList<>();
            int i=0;
            while ((i = reader.read())!= -1) {
                chars.add((char)i);
            }
           Collections.reverse(chars);
            for (char ch: chars) {
                    System.out.print(ch);
            }
        }
    }
}