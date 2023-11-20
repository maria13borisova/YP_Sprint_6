import com.example.Cat;
import com.example.Feline;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline = new Feline();

    private Cat cat;

    @Before
    public void createCat(){
        cat = new Cat(feline);
    }

    @Test
    public void getSoundIsMeow(){
        assertEquals("Мяу", cat.getSound());
    }


    @Test
    public void getFoodIsPredatorFood() throws Exception {
        // Задаем ожидаемый результат
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        // Задаем поведение для mock-объекта
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        // Проверяем, что метод eatMeat() был вызван у mock-объекта
        verify(feline).eatMeat();

        // Проверяем, что возвращенный результат соответствует ожидаемому
        assertEquals(expectedFood, actualFood);
    }



}
