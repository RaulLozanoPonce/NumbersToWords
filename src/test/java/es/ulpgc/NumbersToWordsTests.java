package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NumbersToWordsTests {

    private int number;
    private String numberWord;
    private Map<Integer, String> ONES;
    private Map<Integer, String> TENS;

    public NumbersToWordsTests(int number, String numberWord) {
        this.number = number;
        this.numberWord = numberWord;
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

    @Test
    public void execute(){
        assertThat(toWord(number)).isEqualTo(this.numberWord);
    }

    private String toWord(int number) {
        String ret = "";
        if(ones(number) != 0){
            ret = "-" + ONES.get(ones(number));
        }
        if(tens(number) != 0){
            ret = TENS.get(tens(number)) + ret;
        }
        if(hundreds(number) != 0){
            ret = "one hundred " + ret;
        }

        if(ret.charAt(0) == ' ') ret = ret.substring(1, ret.length());
        if(ret.charAt(ret.length() - 1) == ' ') ret = ret.substring(0, ret.length() - 1);
        return ret;
    }

    private int hundreds(int number) {
        return (number / 100) % 10;
    }

    private int tens(int number) {
        return (number / 10) % 10;
    }

    private int ones(int number) {
        return number % 10;
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {20, "twenty"},
                {21, "twenty-one"},
                {22, "twenty-two"},
                {23, "twenty-three"},
                {24, "twenty-four"},
                {25, "twenty-five"},
                {26, "twenty-six"},
                {27, "twenty-seven"},
                {28, "twenty-eight"},
                {29, "twenty-nine"},
                {30, "thirty"},
                {40, "forty"},
                {50, "fifty"},
                {60, "sixty"},
                {70, "seventy"},
                {80, "eighty"},
                {90, "ninety"},
                {100, "one hundred"}
        };
    }

}
