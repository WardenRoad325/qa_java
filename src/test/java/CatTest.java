
import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class CatTest {

    @Mock
    private Predator predator;

    @InjectMocks
    private Cat cat;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);

        List<String> food = cat.getFood();

        assertNotNull(food);
        assertEquals(expectedFood, food);
    }

    @Test(expected = Exception.class)
    public void testGetFood_Exception() throws Exception {
        when(predator.eatMeat()).thenThrow(new Exception("Ошибка при получении еды"));

        cat.getFood();
    }
}


