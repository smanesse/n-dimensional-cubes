import java.util.Scanner;

public class nthDimension {

    public static void main(String[] args) {
        int k, n;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of dimensions of the parent object (n): ");
            n = scanner.nextInt();

            System.out.print("\nEnter the number of dimensions of the child object (m): ");
            k = n - scanner.nextInt();
            System.out.println();

            if (n < 0 && k < 0) { //input validation
                System.out.println("Please enter positive values.");
            } else if (n < k) {
                System.out.println("Please enter n and m such that m<n.");
            } else if (n > 30) {
                System.out.println("Your numbers were too large.");
            } else {
                break;
            }
        }

        long result;
        if (k == 0) {
            result = 1; //edge case
        } else {
            //create array of integers 1 through k.
            long[] nums = new long[n - k + 1];
            for (int i = 1; i <= nums.length; i++) {
                nums[i - 1] = i;
            }

            /*Recursively generates a set of numbers of a specific order. The difference between each number
             *in the set is given by the number in the previous order set.
             *The first few sets are listed here:
             * 1   2   3   4   5   6
             * 1   3   6  10  15  21
             * 1   4  10  20  35  56
             * 1   5  15  35  50 106
             */
            /* This is my O(n^2) algorithm.
            int iteration = 0;
            do {
                long[] nums2 = nums.clone();
                for (int i = 0, localSum = 0; i <= n-k; i++) {
                    localSum += nums[i];
                    nums2[i] = localSum;
                }
                nums = nums2;
                iteration++;
            } while (iteration < k - 1);

            result = (long) Math.pow(2, k) * nums[n - k]; //multiply the mth term of the k order set by 2^k
            */

            //Then I looked up the actual solution, which was O(n), so I decided I should probably use that instead.
            result = (long) Math.pow(2, k) * factorial(n)/(factorial(n-k)*factorial(k));
        }
        System.out.printf("Number of %d-dimensional squares in %d-dimensional cuboid: %d", (n - k), n, result);
    }

    static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = n; i>1; i--) {
            result *=i;
        }
        return result;
    }


}
