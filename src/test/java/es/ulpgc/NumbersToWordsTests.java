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

        return "twenty" + ret;
    }

    private int ones(int number) {
        return number % 10;
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {20, "twenty"},
                {21, "twenty-one"},
                {22, "twenty-two"}
        };
    }

}
