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
    public void eatMeatIsPredatorFood(){
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        try {
            List<String> actualFood = feline.eatMeat();
            assertEquals(expectedFood, actualFood);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    public void getKittensIs1(){
        try {
            int actualKittensCount = feline.getKittens();
            assertEquals(1, actualKittensCount);
        } catch (Exception e){
        e.printStackTrace();
    }

}

    @Test
    public void getFamilyisFeline(){
        String expectedFamily = "Кошачьи";
        try{
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
        } catch (Exception e){
            e.printStackTrace();
    }

}


}
