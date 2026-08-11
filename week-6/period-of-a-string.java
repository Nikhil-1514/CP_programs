import java.io.*;
import java.util.*;

public class Solution {

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
                i++;
            }
        }
        int p = n - lps[n - 1];
        if (n % p == 0)
            System.out.println(p);
        else
            System.out.println(n);
    }
}
