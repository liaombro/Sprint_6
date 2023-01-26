package AlexTheLionTest;

import com.example.AlexTheLion;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

public class AlexTheLionSingleTest {


    @Mock
    Feline mockFeline;

    @Spy
    Feline spyFeline = new Feline();

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        AlexTheLion alex = new AlexTheLion(spyFeline);
        int expected = 0;

        int actual = alex.getKittens();

        MatcherAssert.assertThat("Alex has no kittens",
                actual, is(expected));
    }

    @Test
    public void getPlaceOfLivingReturnsCorrectValue() throws Exception {
        AlexTheLion alex = new AlexTheLion(mockFeline);
        String expected = "Нью-Йоркский зоопарк";

        String actual = alex.getPlaceOfLiving();
        MatcherAssert.assertThat("Alex lives in New York zoo",
                actual, is(expected));
    }


    @Test
    public void getFriendsReturnsCorrectNumberOfValues() throws Exception {
        AlexTheLion alex = new AlexTheLion(mockFeline);
        int expected = 3;

        int actual = alex.getFriends().size();

        MatcherAssert.assertThat("Alex has 3 friends", actual, is(expected));
    }

    @Test
    public void getFriendsReturnsCorrectValues() throws Exception {
        AlexTheLion alex = new AlexTheLion(mockFeline);
        String[] expected = {"Марти", "Глория", "Мелман"};

        List<String> actual = alex.getFriends();

        MatcherAssert.assertThat("Friends of Alex are Marty, Gloria and Melman", actual, hasItems(expected));
    }

}
