import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    Feline feline;

    Lion lion;

    // создаем объект Feline перед запуском каждого теста
    @Before
    public void beforeTest(){
        feline = Mockito.mock(Feline.class);
    }

    private final String SEX;
    private final boolean IS_CREATED;
    private final boolean DOES_HAVE_MANE;


    public LionTest(String sex, boolean isCreated, boolean doesHaveMane) {
        this.SEX = sex;
        this.IS_CREATED = isCreated;
        this.DOES_HAVE_MANE = doesHaveMane;
    }


    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][] {
                /* пол,    создан, есть грива */
                {"Самка",  true,   false},
                {"Самец",  true,   true},
                {"Другое", false,  false},
        };


    }


    /*  Проверка создания объектов Lion */
    @Test
    public void createLionTest(){
        createLion();
        if(IS_CREATED){
            assertNotNull(lion);
        }else{
            assertNull(lion);
        }
    }

    /* Проверка метода getKittens() */
    @Test
    public void getKittensTest(){
        createLion();
        /* проверяем метод getKittens() у созданных Lion */
        if(IS_CREATED){
            Mockito.when(feline.getKittens()).thenReturn(1);
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        }

    }

    @Test
    public void doesHaveManeTest(){
        createLion();
        if(IS_CREATED){
           assertEquals(DOES_HAVE_MANE, lion.doesHaveMane());

        }

    }

    @Test
    public void getFoodIsPredatorFood() throws Exception {
        createLion();
        if(IS_CREATED) {
            // Задаем ожидаемый результат
            String animalKind = "Хищник";
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

            // Задаем поведение для mock-объекта
            when(feline.getFood(animalKind)).thenReturn(expectedFood);

            List<String> actualFood = lion.getFood();

            // Проверяем, что метод getFood() был вызван у mock-объекта 1 раз
            verify(feline, Mockito.times(1)).getFood(animalKind);

            // Проверяем, что возвращенный результат соответствует ожидаемому
            assertEquals(expectedFood, actualFood);

        }
    }


    /* Вспомогательные методы */
    /* создаем объект класса Lion */
    public void createLion(){
        try {
            lion = new Lion(SEX, feline);
            //System.out.println("Создан объект класса Lion");
        }catch (Exception e){
            //e.printStackTrace();
            //System.out.println("Лев не создан.");
        }
    }

}
