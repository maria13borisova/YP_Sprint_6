import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FelineTest {
    Feline feline;

    @Before
    public void createFeline(){
        feline = new Feline();
    }


    @Test
    public void eatMeatIsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);

    }

    @Test
    public void getKittensIs1() throws Exception {
        int actualKittensCount = feline.getKittens();
        assertEquals(1, actualKittensCount);
    }

    @Test
    public void getFamilyisFeline() throws Exception {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }


}
