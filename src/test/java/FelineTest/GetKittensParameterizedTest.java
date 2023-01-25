package FelineTest;

import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class GetKittensParameterizedTest {

    private int kittensCount;
    private int expected;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {100, 100},
                {1, 1},
                {0, 0},
                {-1, -1}
        };
    }

    public GetKittensParameterizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        MatcherAssert.assertThat("getKittens should return value equal to parameter",
                actual, is(expected));
    }

}
