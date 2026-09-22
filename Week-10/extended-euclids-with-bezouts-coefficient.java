import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        if (b == 0) return a;

        long[] r = gcdExtended(b, a % b);
        return r[0];
    }

    // returns {gcd, x, y} such that ax + by = gcd
    static long[] gcdExtended(long a, long b) {
        if (b == 0)
            return new long[]{a, 1, 0};

        long[] r = gcdExtended(b, a % b);

        long g = r[0];
        long x = r[2];
        long y = r[1] - (a / b) * r[2];

        return new long[]{g, x, y};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] r = gcdExtended(A, B);

        long D = r[0];
        long x0 = r[1];
        long y0 = r[2];

        // x = x0 + k * (B/D)
        // y = y0 - k * (A/D)

        long p = B / D;
        long q = A / D;

        // Find k near the point that minimizes |x| + |y|
        long k = Math.round((double) (q * y0 - p * x0) / (p * p + q * q));

        long bestX = x0;
        long bestY = y0;
        long bestSum = Math.abs(x0) + Math.abs(y0);

        for (long i = k - 2; i <= k + 2; i++) {
            long x = x0 + i * p;
            long y = y0 - i * q;

            long sum = Math.abs(x) + Math.abs(y);

            if (sum < bestSum || (sum == bestSum && x <= y)) {
                bestX = x;
                bestY = y;
                bestSum = sum;
            }
        }

        System.out.println(bestX + " " + bestY + " " + D);
    }
}
