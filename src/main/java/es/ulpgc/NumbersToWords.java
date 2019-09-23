package es.ulpgc;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWords {
    private static Map<Integer, String> ONES;
    private static Map<Integer, String> TENS;
    private static Map<Integer, String> SPECIAL;

    static {
        ONES = new HashMap<Integer, String>();
        ONES.put(0, "");
        ONES.put(1, "one");
        ONES.put(2, "two");
        ONES.put(3, "three");
        ONES.put(4, "four");
        ONES.put(5, "five");
        ONES.put(6, "six");
        ONES.put(7, "seven");
        ONES.put(8, "eight");
        ONES.put(9, "nine");
        SPECIAL = new HashMap<Integer, String>();
        SPECIAL.put(10, "ten");
        SPECIAL.put(11, "eleven");
        SPECIAL.put(12, "twelve");
        SPECIAL.put(13, "thirteen");
        SPECIAL.put(14, "fourteen");
        SPECIAL.put(15, "fifteen");
        SPECIAL.put(16, "sixteen");
        SPECIAL.put(17, "seventeen");
        SPECIAL.put(18, "eighteen");
        SPECIAL.put(19, "nineteen");
        TENS = new HashMap<Integer, String>();
        TENS.put(2, "twenty");
        TENS.put(3, "thirty");
        TENS.put(4, "forty");
        TENS.put(5, "fifty");
        TENS.put(6, "sixty");
        TENS.put(7, "seventy");
        TENS.put(8, "eighty");
        TENS.put(9, "ninety");
    }

    public static String toWord(int number) {
        String ret = "";
        int level = 0;
        while (level < 3) {
            if(level == 0) {
                ret = threeNumbersToWord(number%1000) + ret;
            }else if(level == 1 && (number%1000000)/1000 != 0){
                ret = threeNumbersToWord((number%1000000)/1000) + " thousand " + ret;
            }else if(level == 2 && number/1000000 != 0){
                ret = toWord(number/1000000) + " million " + ret;
            }
            level++;
        }
        return cleanNumber(ret);
    }

    public static String threeNumbersToWord(int number) {
        if(number == 0) return "";
        String ret = "";
        if (ones(number) != 0 && tens(number) != 1) {
            ret = "-" + ONES.get(ones(number));
        }
        if (tens(number) != 0) {
            ret = (tens(number) == 1 ? SPECIAL.get(number) : TENS.get(tens(number))) + ret;
        }
        if (hundreds(number) != 0) {
            ret = ONES.get(hundreds(number)) + " hundred " + ret;
        }
        return cleanNumber(ret);
    }

    private static String cleanNumber(String number){
        if(number.charAt(0) == ' ' || number.charAt(0) == '-') number = number.substring(1, number.length());
        if(number.charAt(number.length() - 1) == ' ' || number.charAt(number.length() - 1) == '-') number = number.substring(0, number.length() - 1);
        return number;
    }

    private static int hundreds(int number) {
        return (number / 100) % 10;
    }

    private static int tens(int number) {
        return (number / 10) % 10;
    }

    private static int ones(int number) {
        return number % 10;
    }
}