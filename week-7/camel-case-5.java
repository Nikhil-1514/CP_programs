import java.util.*;

public class Main {
    
    static String getAbbreviation(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    static boolean matches(String abbreviation, String pattern) {
        int j = 0;

        for (int i = 0; i < abbreviation.length() && j < pattern.length(); i++) {
            if (abbreviation.charAt(i) == pattern.charAt(j)) {
                j++;
            }
        }

        return j == pattern.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = sc.nextLine().split(",");
        String pattern = sc.nextLine().trim();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = words[i].trim();
            String abbreviation = getAbbreviation(word);

            if (matches(abbreviation, pattern)) {
                result.add(word);
            }
        }

        result.sort((a, b) -> {
            String abbrA = getAbbreviation(a);
            String abbrB = getAbbreviation(b);

            int cmp = abbrA.compareTo(abbrB);

            if (cmp != 0) {
                return cmp;
            }

            return a.compareTo(b);
        });

        if (result.isEmpty()) {
            System.out.println("No match found");
        } else {
            for (String word : result) {
                System.out.println(word);
            }
        }

        sc.close();
    }
}
