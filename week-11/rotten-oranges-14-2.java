import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if (a[i][j] == 2)
                    q.add(new int[]{i, j});
                else if (a[i][j] == 1)
                    fresh++;
            }
        }

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            while (size-- > 0) {
                int[] p = q.poll();

                for (int[] d : dir) {
                    int r = p[0] + d[0];
                    int c = p[1] + d[1];

                    if (r >= 0 && r < n && c >= 0 && c < m && a[r][c] == 1) {
                        a[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }

        System.out.println(fresh == 0 ? time : -1);
    }
}
