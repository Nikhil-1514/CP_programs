import java.io.*;
import java.util.*;

public class border-of-a-string {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1, len = 0; i < n;) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        System.out.println(s.substring(0, lps[n - 1]));
    }
}
