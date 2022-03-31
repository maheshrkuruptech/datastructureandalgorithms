package knapsack;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalLearn {

  public static void main(String[] args) {
    BigDecimal m = new BigDecimal("1000.99");
    BigDecimal m1 = new BigDecimal("1001.01");
    System.out.println(m.add(m1));
    System.out.println(m.round(new MathContext(3)));
  }

}
