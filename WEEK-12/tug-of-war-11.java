import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static long total;
    static long ans = Long.MAX_VALUE;

    static void generate(int index, int end, int count, long sum,
                         ArrayList<Long>[] sums) {

        if (index == end) {
            sums[count].add(sum);
            return;
        }

        // Don't select arr[index]
        generate(index + 1, end, count, sum, sums);

        // Select arr[index]
        generate(index + 1, end, count + 1,
                 sum + arr[index], sums);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        int mid = n / 2;

        ArrayList<Long>[] left = new ArrayList[mid + 1];
        ArrayList<Long>[] right = new ArrayList[n - mid + 1];

        for (int i = 0; i <= mid; i++)
            left[i] = new ArrayList<>();

        for (int i = 0; i <= n - mid; i++)
            right[i] = new ArrayList<>();

        generate(0, mid, 0, 0, left);
        generate(mid, n, 0, 0, right);

        for (int i = 0; i <= mid; i++)
            Collections.sort(right[i]);

        /*
         * We choose one group.
         *
         * For even n:
         *     group size = n / 2
         *
         * For odd n:
         *     group size can be n/2 or n/2 + 1
         */
        int[] targetSizes;

        if (n % 2 == 0) {
            targetSizes = new int[]{n / 2};
        } else {
            targetSizes = new int[]{n / 2, n / 2 + 1};
        }

        for (int target : targetSizes) {

            for (int leftCount = 0;
                 leftCount <= mid;
                 leftCount++) {

                int rightCount = target - leftCount;

                if (rightCount < 0 ||
                    rightCount > n - mid)
                    continue;

                for (long leftSum : left[leftCount]) {

                    /*
                     * We want:
                     *
                     * difference =
                     * |total - 2 * selectedSum|
                     *
                     * Therefore selectedSum should be
                     * as close as possible to total / 2.
                     */

                    long required = total / 2 - leftSum;

                    ArrayList<Long> list = right[rightCount];

                    int pos = Collections.binarySearch(list, required);

                    if (pos < 0) {
                        pos = -pos - 1;
                    }

                    // Candidate at pos
                    if (pos < list.size()) {
                        long selectedSum = leftSum + list.get(pos);
                        ans = Math.min(ans,
                                Math.abs(total - 2 * selectedSum));
                    }

                    // Candidate just before pos
                    if (pos > 0) {
                        long selectedSum =
                                leftSum + list.get(pos - 1);

                        ans = Math.min(ans,
                                Math.abs(total - 2 * selectedSum));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

