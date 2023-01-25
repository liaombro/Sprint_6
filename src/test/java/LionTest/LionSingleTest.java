package LionTest;

import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(MockitoJUnitRunner.class)
public class LionSingleTest {

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
    public void doesHaveManeThrowsCorrectErrorWhenInvalidSex() throws Exception {
        String sex = "Боевой вертолет";
        Lion lion = new Lion(mockFeline, sex);
        String expected = "Используйте допустимые значения пола животного";
        String reason = String.format("Error message when animal sex is invalid should contain \"%s\"", expected);

        try {
            lion.doesHaveMane();
        } catch (Exception e) {
            String actual = e.getMessage();

            MatcherAssert.assertThat(reason,
                    actual, containsString(expected));
        }
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
    public void getKittensCallsFelineClass() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(mockFeline, sex);

        lion.getKittens();

        Mockito.verify(mockFeline).getKittens();
    }


}
