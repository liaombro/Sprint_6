import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline mockFeline;


    @Test
    public void doesHaveManeIsTrueWhenMale() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(mockFeline, sex);
        boolean expected = true;

        boolean actual = lion.doesHaveMane();
        MatcherAssert.assertThat("Male lions should have manes",
                actual, is(expected));
    }

    @Test
    public void doesHaveManeIsFalseWhenFemale() throws Exception {
        String sex = "Самка";
        Lion lion = new Lion(mockFeline, sex);
        boolean expected = false;

        boolean actual = lion.doesHaveMane();
        MatcherAssert.assertThat("Female lions should not have manes",
                actual, is(expected));
    }


    @Test
    public void constructorThrowsCorrectErrorWhenInvalidSex() throws Exception {
        String sex = "Боевой вертолет";
        String expected = "Используйте допустимые значения пола животного";
        String reason = String.format("Error message when animal sex is invalid should contain \"%s\"", expected);

        Exception exception = Assert.assertThrows(
                "Exception should be thrown if lion sex is incorrect",
                Exception.class, () -> new Lion(mockFeline, sex));
        String actual = exception.getMessage();
        MatcherAssert.assertThat(reason, actual, containsString(expected));

    }

    @Test
    public void getFoodCallsPredatorInterface() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(mockFeline, sex);
        String expectedArgument = "Хищник";

        lion.getFood();

        Mockito.verify(mockFeline).getFood(expectedArgument);
    }

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(mockFeline, sex);
        Mockito.when(mockFeline.getKittens()).thenReturn(12345);
        int expected = 12345;

        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }


}
