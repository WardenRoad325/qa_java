import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

 public class LionTest {


     private Lion lion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }




    @Test
    public void testGetKittens() {
        // Мокируем метод getKittens() в объекте felineMock
        when(felineMock.getKittens()).thenReturn(2);

        int kittens = lion.getKittens();
        assertEquals(2, kittens);
    }

    @Test
    public void testDoesHaveMane() {
        boolean hasMane = lion.doesHaveMane();
        assertTrue(hasMane);
    }

    @Test
    public void testDoesNotHaveMane() throws Exception {
        Lion lionWithoutMane = new Lion("Самка", felineMock);
        boolean hasMane = lionWithoutMane.doesHaveMane();
        assertFalse(hasMane);
    }

    @Test
    public void testGetFood() throws Exception {
        // Мокируем метод getFood("Хищник") в объекте felineMock
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> food = lion.getFood();

        assertNotNull(food);
        assertEquals(expectedFood, food);
    }

     @Test(expected = Exception.class)
     public void testInvalidSex() throws Exception {
         Lion lionWithInvalidSex = new Lion("Некорректный пол", felineMock);
     }

 }








