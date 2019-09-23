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

        return (tens(number)==2 ? "twenty" : "thirty") + ret;
    }

    private int tens(int number) {
        return (number % 100)/10;
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
                {30, "thirty"}
        };
    }

}
