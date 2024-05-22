import java.util.Arrays;

/**
 * Class with static methods that demonstrate various uses of recursion in Java.
 */
public class RecursiveMethods {

    public static String reverseString(String string) {
        if (string == null || string.length() <= 1)
            return string;
        return reverseString(string.substring(1)) +
                string.charAt(0);
    }

    public static void reverseArray(int[] array) {
        if (array != null)
            reverseArray(array, 0, array.length - 1);
    }

    public static void reverseArray(int[] array, int indexLow, int indexHigh) {
        if (indexLow < indexHigh) {
            int temp = array[indexHigh];
            array[indexHigh] = array[indexLow];
            array[indexLow] = temp;
            reverseArray(array, ++indexLow, --indexHigh);
        }
    }

    public static boolean isElementInArray(int element, int[] array) {
        if (array != null)
            if (isElementInArray(element, array, 0))
                return true;
        return false;
    }

    public static boolean isElementInArray(int element, int[] array, int startIndex) {
        if (startIndex < array.length) {
            if (element == array[startIndex])
                return true;
            else {
                if (isElementInArray(element, array, ++startIndex))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    public static int sumArray(int[] array) {
        return sumArray(array, 0);
    }

    public static int sumArray(int[] array, int indexToSum) {
        if (indexToSum < array.length - 1)
            return array[indexToSum] + sumArray(array, ++indexToSum);
        return array[indexToSum];
    }

    public static int getFibonacciNumber(int n) {
        if (n > 2)
            return getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
        if (n > 0)
            return n - 1;
        return -1;
    }

    public static boolean isPalindrome(String string) {
        int length = string.length();
        if (length > 1)
            return string.charAt(0) == string.charAt(length - 1)
                    && isPalindrome(string.substring(1, length - 1));
        return true;
    }

    public static double pow(double base, double exponent) {
        if (exponent > 1)
            return base * pow(base, exponent - 1);
        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;
        return 1 / pow(base, exponent * -1);
    }

    public static int substringOccurrences(String string, String findString) {
        if (string.length() < findString.length())
            return 0;
        if (string.substring(0, findString.length()).equals(findString))
            return 1 + substringOccurrences(string.substring(1), findString);
        return 0 + substringOccurrences(string.substring(1), findString);
    }

    public static int sumDigits(int n) {
        if (n == 0)
            return 0;
        int digit = n % 10;
        System.out.println("n = " + n + ", digit = " + digit);
        return digit + sumDigits(n / 10);
    }

    public static int count7s(int n) {
        if (n == 0)
            return 0;
        int digit = n % 10;
        if (digit == 7)
            return 1 + count7s(n / 10);
        return count7s(n / 10);
    }

    public static void main(String[] args) {
        // 1.
        System.out.println("\n1.");
        String string1 = "1234567abcdefg";
        System.out.println("Input:\t\t" + string1);
        System.out.println("Reversed:\t" + RecursiveMethods.reverseString(string1));

        // 2.
        System.out.println("\n2.");
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("Input:\t\t" + Arrays.toString(array2));
        reverseArray(array2);
        System.out.println("Reversed:\t" + Arrays.toString(array2));

        // 3.
        System.out.println("\n3.");
        int element3 = 9;
        int[] array3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Element:\t" + element3);
        System.out.println("Array:\t\t" + Arrays.toString(array3));
        System.out.println("In Array?:\t" + RecursiveMethods.isElementInArray(element3, array3));

        // 4.
        System.out.println("\n4.");
        int[] array4 = { 1, 2, 3, 4, 5 };
        System.out.println("Array:\t\t" + Arrays.toString(array4));
        System.out.println("Sum:\t\t" + RecursiveMethods.sumArray(array4));

        // 5.
        System.out.println("\n5.");
        int int5 = 8;
        System.out.println("Fibonacci Number " + int5 + " = " + RecursiveMethods.getFibonacciNumber(int5));

        // 6.
        System.out.println("\n6.");
        String string6 = "emaddame";
        System.out.println("String:\t\t" + string6);
        System.out.println("Is Palindrome:\t" + RecursiveMethods.isPalindrome(string6));

        // 7.
        System.out.println("\n7.");
        double base = 10;
        double exponent = 15;
        System.out.println(base + " ^ " + exponent + " = " + RecursiveMethods.pow(base, exponent));

        // 8.
        System.out.println("\n8.");
        // String string8 = "abc_abc_abc_d_abc";
        // String findString8 = "abc";
        String string8 = "he and herself hee heheed";
        String findString8 = "he";
        System.out.println("String:\t\t" + string8);
        System.out.println("Find String:\t" + findString8);
        System.out.println("Occurrences:\t" + RecursiveMethods.substringOccurrences(string8, findString8));

        // 9.
        System.out.println("\n9.");
        int int9 = 5043210;
        System.out.println("Int:\t\t" + int9);
        System.out.println("Sum Digits:\t" + RecursiveMethods.sumDigits(int9));

        // 10.
        System.out.println("\n10.");
        int int10 = 71117770;
        System.out.println("Int:\t\t" + int10);
        System.out.println("Count 7s:\t" + RecursiveMethods.count7s(int10));

    }
}
