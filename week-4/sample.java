public class CollatzConjecture {

    public static void printCollatzSequence(long n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        System.out.print("Sequence for " + n + ": ");
        int steps = 0;

        while (n != 1) {
            System.out.print(n + " -> ");
            if (n % 2 == 0) {
                n = n / 2; // Even step
            } else {
                n = 3 * n + 1; // Odd step
            }
            steps++;
        }

        // Print the final 1
        System.out.println("1");
        System.out.println("Total steps to reach 1: " + steps);
    }

    public static void main(String[] args) {
        long startingNumber = 27; // Takes 111 steps to reach 1
        printCollatzSequence(startingNumber);
    }
}
