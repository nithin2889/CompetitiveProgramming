package cp.euclidsalgorithm;

public class EuclideanAlgorithm {

  public static void main(String[] args) {
    int a = 10, b = 14;
    System.out.println("GCD of " + a + " and " + b + " is: " + gcd(10, 14));
    System.out.println("LCM of " + a + " and " + b + " is: " + lcm(10, 14));
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  private static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }
}
