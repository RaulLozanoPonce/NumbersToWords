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
        assertThat(NumbersToWords.toWord(number)).isEqualTo(this.numberWord);
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
                {100, "one hundred"},
                {125, "one hundred twenty-five"},
                {130, "one hundred thirty"},
                {178, "one hundred seventy-eight"},
                {181, "one hundred eighty-one"},
                {200, "two hundred"},
                {300, "three hundred"},
                {400, "four hundred"},
                {500, "five hundred"},
                {600, "six hundred"},
                {700, "seven hundred"},
                {800, "eight hundred"},
                {900, "nine hundred"},
                {1000, "one thousand"}
        };
    }

}
