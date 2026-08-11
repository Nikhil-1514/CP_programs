import java.io.*;
import java.util.*;

public class find-duplicate-characters-using-bit-manipulation {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int seen = 0;
        int duplicates = 0;
        boolean found = false;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((seen & bit) != 0 && (duplicates & bit) == 0) {
                System.out.print((found ? " " : "") + c);
                duplicates |= bit;
                found = true;
            }

            seen |= bit;
        }

        if (!found)
            System.out.print("No duplicates");
    }
}
