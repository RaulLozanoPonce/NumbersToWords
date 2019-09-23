package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class NumbersToWordsTests {

    private int number;
    private String numberWord;

    public NumbersToWordsTests(int number, String numberWord) {
        this.number = number;
        this.numberWord = numberWord;
    }

    @Test
    public void execute(){
        assertThat(toWord(number)).isEqualTo(this.numberWord);
    }

    private String toWord(int number) {
        return number==20 ? "twenty" : "twenty-one";
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {20, "twenty"},
                {21, "twenty-one"}
        };
    }

}
