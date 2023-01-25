package FelineTest;

import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class FelineSingleTest {

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
    public void getKittensWithoutParametersReturnsCorrectValue() {
        Feline feline = new Feline();
        int expected = 1;

        int actual = feline.getKittens();

        MatcherAssert.assertThat("getKittens default value is 1",
                actual, is(expected));
    }

}
