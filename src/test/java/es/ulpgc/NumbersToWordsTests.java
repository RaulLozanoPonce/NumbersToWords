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
                {1, "one"},
                {2, "two"},
                {3, "three"},
                {4, "four"},
                {5, "five"},
                {6, "six"},
                {7, "seven"},
                {8, "eight"},
                {9, "nine"},
                {10, "ten"},
                {11, "eleven"},
                {12, "twelve"},
                {13, "thirteen"},
                {14, "fourteen"},
                {15, "fifteen"},
                {16, "sixteen"},
                {17, "seventeen"},
                {18, "eighteen"},
                {19, "nineteen"},
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
                {1000, "one thousand"},
                {1011, "one thousand eleven"},
                {1021, "one thousand twenty-one"},
                {1100, "one thousand one hundred"},
                {1121, "one thousand one hundred twenty-one"},
                {2000, "two thousand"},
                {20000, "twenty thousand"},
                {20001, "twenty thousand one"},
                {20021, "twenty thousand twenty-one"},
                {20121, "twenty thousand one hundred twenty-one"},
                {25121, "twenty-five thousand one hundred twenty-one"},
                {100000, "one hundred thousand"},
                {1000000, "one million"},
                {100000000, "one hundred million"},
                {1000000000, "one thousand million"},
                {1100000000, "one thousand one hundred million"}

        };
    }

}
