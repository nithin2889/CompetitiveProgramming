package cp.binaryexponentiation;

public class PowerGeneration {

  public static void main(String[] args) {
    long base = 3, power = 1000;
    System.out.println("Power(" + base + '^' + power + ") is: " + power(base, power));

    double b = 3, pow = 1000;
    System.out.println("ModPower(" + base + '^' + power + ") is: " + modPower(b, pow, 1e9 + 7));
  }

  private static long power(long base, long power) {
    long ans = 1;

    while (power > 0) {
      if (power % 2 == 0) {
        base = base * base;
        power /= 2;
      } else {
        ans = ans * base;
        power = power - 1;
      }
    }
    return ans;
  }

  private static double modPower(double base, double power, double mod) {
    double ans = 1.0;

    while (power > 0) {
      if (power % 2 == 0) {
        base = (base * base) % mod;
        power /= 2;
      } else {
        ans = (ans * base) % mod;
        power = power - 1;
      }
    }
    return ans;
  }
}
