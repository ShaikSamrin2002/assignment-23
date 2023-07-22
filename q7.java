import java.util.Scanner;

public class Main {
    // Method to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0; // Starting index of the longest palindromic substring
        int end = 0; // Ending index of the longest palindromic substring

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // For odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // For even-length palindromes
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Method to expand around the center and find the length of a palindromic substring
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        scanner.close();

        String longestPalindromicSubstring = longestPalindrome(inputString);
        System.out.println("Longest palindromic substring: " + longestPalindromicSubstring);
    }
}
