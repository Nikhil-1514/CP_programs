import java.util.*;

public class Main {
    static int V;
    static int[][] capacity;
    static boolean[] visited;

    static int dfs(int u, int t, int flow) {
        if (u == t) return flow;

        visited[u] = true;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && capacity[u][v] > 0) {
                int newFlow = dfs(v, t, Math.min(flow, capacity[u][v]));

                if (newFlow > 0) {
                    capacity[u][v] -= newFlow;
                    capacity[v][u] += newFlow;
                    return newFlow;
                }
            }
        }

        return 0;
    }

    static int fordFulkerson(int source, int sink) {
        int maxFlow = 0;
        int flow;

        while (true) {
            visited = new boolean[V];
            flow = dfs(source, sink, Integer.MAX_VALUE);

            if (flow == 0) break;

            maxFlow += flow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        capacity = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            capacity[u][v] += c;
        }

        System.out.println(fordFulkerson(0, V - 1));
    }
}
