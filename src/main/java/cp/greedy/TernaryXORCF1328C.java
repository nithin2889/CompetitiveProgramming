package cp.greedy;

public class TernaryXORCF1328C {

  public static void main(String[] args) {
    String c = "2202121021";
    int flag = 0;
    System.out.println("The minimum out of the maximum value of a and b is: ");
    System.out.println(ternaryXOR(c, flag));
  }

  private static String ternaryXOR(String c, int flag) {
    String a = "", b = "";
    // flag = 0
    //   if c = 0, then a = 0 and b = 0
    //   if c = 1, then a = 1 and b = 0, we set flag = 1 as we make a > b once and there after keep a's value as low as possible.
    //   if c = 2, then a = 1 and b = 1

    // flag = 1
    //   if c = 0, then a = 0 and b = 0
    //   if c = 1, then a = 0 and b = 1
    //   if c = 2, then a = 0 and b = 2
    for (int i = 0; i < c.length(); i++) {
      if (flag == 0) {
        if (c.charAt(i) == '2') {
          a = a.concat("1");
          b = b.concat("1");
        } else if (c.charAt(i) == '1') {
          a = a.concat("1");
          b = b.concat("0");
          flag = 1;
        } else {
          a = a.concat("0");
          b = b.concat("0");
        }
      } else {
        a = a.concat("0");
        if (c.charAt(i) == '2') {
          b = b.concat("2");
        } else if (c.charAt(i) == '1') {
          b = b.concat("1");
        } else {
          b = b.concat("0");
        }
      }
    }
    return a + " and " + b;
  }
}
