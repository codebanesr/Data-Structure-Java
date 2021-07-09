package interview.sprint1;

public class IntegerToRoman {
  // I             1            
  // V             5            
  // X             10
  // L             50
  // C             100
  // D             500
  // M             1000  
  static Numeral[] numerals = {
    new Numeral("M", 1000),
    new Numeral("CM", 900),
    new Numeral("D", 500),
    new Numeral("CD", 400),
    new Numeral("C", 100),
    new Numeral("XC", 90),
    new Numeral("L", 50),
    new Numeral("XL", 40),
    new Numeral("X", 10),
    new Numeral("IX", 9),
    new Numeral("V", 5),
    new Numeral("IV", 4),
    new Numeral("I", 1)
  };

  public static void main(String[] args) {
    int num = 19;
    String result = "";
    for(Numeral n: numerals) {
      int itr = num / n.number;
      result += n.roman.repeat(itr);
      num = num % n.number;
    }


    System.out.println(result);
  }
}


class Numeral {
  public String roman;
  public int number;


  Numeral(String roman, int number) {
    this.roman = roman;
    this.number = number;
  }
}
