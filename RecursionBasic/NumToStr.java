package RecursionBasic;

public class NumToStr {
    static String digit[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void printDigits(int n) {
        // Base Case
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        printDigits(n / 10);
        System.out.print(digit[lastDigit] + " ");
    }

    public static void main(String[] args) {
        printDigits(1947);

    }
}
