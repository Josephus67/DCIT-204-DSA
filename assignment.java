import java.util.Scanner;

public class assignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome,Josephus, to the Algorithm Chooser!");

            System.out.println("Please select an option:");

            System.out.println("1. Brute Force Search");
            System.out.println("2. Exhaustive Search for Maximum Subarray Sum");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You chose Brute Force Search!");
                    performBruteForceSearch(scanner);
                    break;
                case 2:
                    System.out.println("You chose Exhaustive Search for Maximum Subarray Sum!");
                    performExhaustiveSearch(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void performBruteForceSearch(Scanner scanner) {
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter the target value to search for:");
        int target = scanner.nextInt();

        long startTime = System.nanoTime();
        int index = bruteForceSearch(array, target);
        long endTime = System.nanoTime();

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
        System.out.println("Running time (in nanoseconds): " + (endTime - startTime));

        System.out.println("Would you like to search again? (yes/no)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            performBruteForceSearch(scanner);
        }
    }

    public static void performExhaustiveSearch(Scanner scanner) {
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        long startTime = System.nanoTime();
        int maxSum = exhaustiveMaxSubarraySum(array);
        long endTime = System.nanoTime();

        System.out.println("Maximum subarray sum is: " + maxSum);
        System.out.println("Running time (in nanoseconds): " + (endTime - startTime));

        System.out.println("Would you like to search again? (y/n)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("y")) {
            performExhaustiveSearch(scanner);
        }
    }

    public static int bruteForceSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int exhaustiveMaxSubarraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}