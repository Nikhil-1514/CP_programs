import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] grid = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextLong();
            }
        }

        long[][] dp = new long[n][m];

        // Starting cell MUST be included
        dp[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0)
                    continue;

                long best = Long.MAX_VALUE;

                // From above
                if (i > 0)
                    best = Math.min(best, dp[i - 1][j]);

                // From left
                if (j > 0)
                    best = Math.min(best, dp[i][j - 1]);

                // From diagonal
                if (i > 0 && j > 0)
                    best = Math.min(best, dp[i - 1][j - 1]);

                dp[i][j] = grid[i][j] + best;
            }
        }

        System.out.println(dp[n - 1][m - 1]);

        sc.close();
    }
}
