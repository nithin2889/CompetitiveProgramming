package cp.recursion;

public class PalindromeString {

  public static void main(String[] args) {
    String s = "NITIN";
    System.out.println("Palindrome? " + isPalindrome(s, 0));
  }

  private static boolean isPalindrome(String s, int i) {
    int n = s.length();
    if (i > n / 2) {
      return true;
    }

    if (s.charAt(i) == s.charAt(n - i - 1)) {
      return isPalindrome(s, i + 1);
    } else {
      return false;
    }
  }
}
