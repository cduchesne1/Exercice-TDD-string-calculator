package com.github.glo2003;

public class Calculator {
  public int add(String numbers) {
    if (numbers.isEmpty()) {
      return 0;
    }

    String[] split = numbers.split(",");
    int sum = 0;

    try {
      for (String number : split) {
        sum += Integer.parseInt(number);
      }
    } catch (NumberFormatException e) {
      throw new InvalidNumberFormatException();
    }
    return sum;
  }
}
