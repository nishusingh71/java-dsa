package Arrays;

public class Pairs {
    public static void printPairs(int nums[]) {
        int tp = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print("(" + curr + "," + nums[j] + ")");
                tp++;
            }
            System.out.println();
            System.out.print("total pairs: " + tp);
        }

    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        printPairs(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
