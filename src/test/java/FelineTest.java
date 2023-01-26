import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Enclosed.class)
public class FelineTest {
    @RunWith(MockitoJUnitRunner.class)
    public static class FelineSingleTest {

        @Spy
        Feline spyFeline = new Feline();


        @Test
        public void getFamilyReturnsCorrectValue() {
            Feline feline = new Feline();
            String expected = "Кошачьи";

            String actual = feline.getFamily();

            MatcherAssert.assertThat(actual, is(expected));
        }

        @Test
        public void eatMeatMethodCallsPredatorInterface() throws Exception {
            String expectedArgument = "Хищник";

            spyFeline.eatMeat();

            Mockito.verify(spyFeline).getFood(expectedArgument);
        }

        @Test
        public void getKittensReturnsCorrectValueWhenNoArguments() {
            Feline feline = new Feline();
            int expected = 1;

            int actual = feline.getKittens();

            MatcherAssert.assertThat("getKittens default value is 1",
                    actual, is(expected));
        }

    }

    @RunWith(Parameterized.class)
    public static class GetKittensParameterizedTest {

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
}