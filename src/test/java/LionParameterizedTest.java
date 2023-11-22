import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
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

    public LionParameterizedTest(String sex, boolean isCreated, boolean doesHaveMane) {
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

    @Test
    public void doesHaveManeTest(){
        createLion();
        if(IS_CREATED){
           assertEquals(DOES_HAVE_MANE, lion.doesHaveMane());

        }

    }

    /* Вспомогательные методы */
    /* создаем объект класса Lion */
    public void createLion(){
        try {
            lion = new Lion(SEX, feline);
        }catch (Exception e){
            //e.printStackTrace();
        }
    }

}
