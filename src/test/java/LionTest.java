import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {
    Feline feline;

    Lion lion;
    @Before
    public void setLion(){
        feline = Mockito.mock(Feline.class);
        try {
            lion = new Lion("Самка", feline);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /* Проверка метода getKittens() */
    @Test
    public void getKittensTest(){
            Mockito.when(feline.getKittens()).thenReturn(1);
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        }

    @Test
    public void getFoodIsPredatorFood(){
            // Задаем ожидаемый результат
            String animalKind = "Хищник";
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

            // Задаем поведение для mock-объекта
            try {
                when(feline.getFood(animalKind)).thenReturn(expectedFood);
                List<String> actualFood = lion.getFood();
                // Проверяем, что метод getFood() был вызван у mock-объекта 1 раз
                verify(feline, Mockito.times(1)).getFood(animalKind);
                // Проверяем, что возвращенный результат соответствует ожидаемому
                assertEquals(expectedFood, actualFood);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


