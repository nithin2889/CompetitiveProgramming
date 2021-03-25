package cp.bitmanipulation;

public class CountOfSetBits {

  public static void main(String[] args) {
    int num = 112;
    System.out.println("Number of set bits in " + num + " are: " + countSetBits(num));
  }

  private static int countSetBits(int num) {
    int count = 0;
    while (num > 0) {
      count += num & 1;
      num = num >> 1;
    }
    return count;
  }
}
