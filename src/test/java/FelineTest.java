import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }


    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithCount() {
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }
}

