import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionManeTest {

    private final String sex;
    private final boolean expectedHasMane;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionManeTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Test
    public void testDoesHaveOrNotHaveMane() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        boolean hasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, hasMane);
    }
}

