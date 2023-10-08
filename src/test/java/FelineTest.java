import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertNotNull(food);
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
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

