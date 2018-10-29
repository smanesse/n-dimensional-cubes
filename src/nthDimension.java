import java.util.Scanner;

public class nthDimension {
    static int n, k;
    static int iteration = 0;
    static int[] nums;

    public static void main(String[] args) {
        setVars();
        if (k == 0) {
            System.out.println("Number of n-dimensional square in n-dimensional cuboid: 1");
            return;
        }
        nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        sum(n - 1);
        System.out.println("Number of " + (n - k) + "-dimensional square in " + n + "-dimensional cuboid: " + (int) Math.pow(2, k) * nums[n - k]);
    }

    static void sum(int max) {
        int[] nums2 = nums.clone();
        for (int i = 1; i <= max; i++) {
            int localSum = 0;
            for (int j = 0; j < i; j++) {
                localSum += nums[j];
            }
            nums2[i - 1] = localSum;
        }
        nums = nums2;
        iteration++;
        if (iteration < k - 1) {
            sum(max);
        }
    }

    static void setVars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter n: ");
        n = scanner.nextInt();
        System.out.println("Please enter m: ");
        k = n - scanner.nextInt();
        if (n < k) {
            System.out.println("Please enter n and m such that m<n.");
            setVars();
        }
    }
}
