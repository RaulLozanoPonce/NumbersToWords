package es.ulpgc;

import java.util.HashMap;
import java.util.Map;

public class NumbersToWords {
    private static Map<Integer, String> ONES;
    private static Map<Integer, String> TENS;

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
        if(ones(number) != 0){
            ret = "-" + ONES.get(ones(number));
        }
        if(tens(number) != 0){
            ret = TENS.get(tens(number)) + ret;
        }
        if(hundreds(number) != 0){
            ret = ONES.get(hundreds(number)) + " hundred " + ret;
        }
        if(thousands(number) != 0){
            ret = ONES.get(thousands(number)) + " thousand " + ret;
        }

        if(ret.charAt(0) == ' ') ret = ret.substring(1, ret.length());
        if(ret.charAt(ret.length() - 1) == ' ') ret = ret.substring(0, ret.length() - 1);
        return ret;
    }

    private static int thousands(int number) {
        return (number / 1000) % 10;
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
