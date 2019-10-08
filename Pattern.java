import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pattern {
    public static void main(String[] args) throws Exception {
        BufferedReader dd = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(dd.readLine());
        for (int i = 1; i <= input; i++) {
            for (int k = input; k >= i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = input-1; i >= 1; i--) {
            for (int k = i; k <= input; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
