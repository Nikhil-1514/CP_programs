import java.io.*;

public class Main {
    static boolean match(String s, String p) {
        int i = 0, j = 0, star = -1, k = 0;

        while (i < s.length()) {
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                k = i;
            } else if (star != -1) {
                j = star + 1;
                i = ++k;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;

        return j == p.length();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String p = br.readLine().trim();

        System.out.println(match(s, p) ? 1 : 0);
    }
}
