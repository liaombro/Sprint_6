package CatTest;

import com.example.Cat;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class CatSingleTest {

    @Mock
    Feline mockFeline;


    @Test
    public void getSoundReturnsCorrectValue() {
        Cat cat = new Cat(mockFeline);
        String expected = "Мяу";

        String actual = cat.getSound();

        MatcherAssert.assertThat("Cat meows like this: \"Мяу\"",
                actual, is(expected));
    }


   @Test
   public void getFoodMethodCallsPredatorInterface() throws Exception {
        Cat cat = new Cat(mockFeline);

        cat.getFood();

        Mockito.verify(mockFeline).eatMeat();
   }

}
