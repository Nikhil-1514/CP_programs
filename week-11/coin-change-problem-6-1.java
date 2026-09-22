
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine;
        do {
            firstLine = br.readLine();
        } while (firstLine != null && firstLine.trim().isEmpty());

        if (firstLine == null) return;

        String[] first = firstLine.trim().split("\\s+");

        int V, N;

        // Actual judge format:
        // V N
        if (first.length == 2) {
            V = Integer.parseInt(first[0]);
            N = Integer.parseInt(first[1]);
        } else {
            // In case the judge really uses T, support it as well.
            int T = Integer.parseInt(first[0]);

            StringBuilder ans = new StringBuilder();

            for (int tc = 0; tc < T; tc++) {
                String line;
                do {
                    line = br.readLine();
                } while (line != null && line.trim().isEmpty());

                String[] parts = line.trim().split("\\s+");
                V = Integer.parseInt(parts[0]);
                N = Integer.parseInt(parts[1]);

                int[] coins = readCoins(br, N);
                int result = solve(V, coins);

                ans.append(result).append('\n');
            }

            System.out.print(ans);
            return;
        }

        int[] coins = readCoins(br, N);

        int result = solve(V, coins);
        System.out.println(result);
    }

    private static int[] readCoins(BufferedReader br, int N) throws Exception {
        int[] coins = new int[N];
        int index = 0;

        while (index < N) {
            String line = br.readLine();
            if (line == null) break;

            String[] parts = line.trim().split("\\s+");

            for (String s : parts) {
                if (!s.isEmpty() && index < N) {
                    coins[index++] = Integer.parseInt(s);
                }
            }
        }

        return coins;
    }

    private static int solve(int V, int[] coins) {

        // Remove useless coins (> V), duplicates and zero values.
        boolean[] exists = new boolean[V + 1];

        int count = 0;

        for (int coin : coins) {
            if (coin > 0 && coin <= V && !exists[coin]) {
                exists[coin] = true;
                count++;
            }
        }

        if (count == 0) {
            return -1;
        }

        int[] useful = new int[count];
        int idx = 0;

        for (int i = 1; i <= V; i++) {
            if (exists[i]) {
                useful[idx++] = i;
            }
        }

        /*
         * dp[x] = minimum number of coins required to make x.
         *
         * Since every coin has cost 1, this is a shortest-path problem.
         * BFS guarantees that the first time we reach V we have the
         * minimum number of coins.
         */
        int[] dp = new int[V + 1];
        Arrays.fill(dp, -1);

        int[] queue = new int[V + 1];
        int head = 0;
        int tail = 0;

        queue[tail++] = 0;
        dp[0] = 0;

        while (head < tail) {
            int amount = queue[head++];

            if (amount == V) {
                return dp[amount];
            }

            for (int coin : useful) {
                int next = amount + coin;

                if (next > V) {
                    break;
                }

                if (dp[next] == -1) {
                    dp[next] = dp[amount] + 1;
                    queue[tail++] = next;
                }
            }
        }

        return -1;
    }
}
