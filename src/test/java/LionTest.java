import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sprint6.Feline;
import sprint6.Lion;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class LionTest {
    Lion lion;
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }
    private final String checkedSex;
    private final boolean expected;

    private final String animals;

    public LionTest(String checkedSex, boolean expected, String animals) {
        this.checkedSex = checkedSex;
        this.expected = expected;
        this.animals = animals;
    }

    @Parameterized.Parameters
    public static Object[] getSumData()
    {
        return new Object[][]
            {// передали тестовые данные
                {"Самец", true, "Хищник"},
                {"Самка", false, "Хищник"},
            };
    }

    // Проверка на один
    @Test
    public void equalGetKittensTest() throws Exception {
        String sex = checkedSex;
        lion = new Lion(sex, feline);
        int expectedKittensCount = 1;
        int actual = lion.getKittens();
        Assert.assertEquals(expectedKittensCount, actual);
    }

    // Проверка на тип мясной диеты для животного
    @Test
    public void equalEatMeatTest() throws Exception {
        String sex = checkedSex;
        String animal = animals;
        lion = new Lion(sex, feline);
        List<String> expectedFood = feline.getFood(animal);
        List<String> actual = lion.getFood();
        Assert.assertEquals(expectedFood, actual);
    }

    // Проверка животного на пол самец
    @Test
    public void isDoesHaveManeTest() throws Exception {
        String sex = checkedSex;
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    // Проверка на Exception, если указан пол отличный от - самец или самка
    @Test
    public void exceptionTest() throws Exception {
        String sex = "checkedSex";
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> {
            lion = new Lion(sex, feline);
        });
        String actualMessage = exception.getMessage();
        boolean actual = actualMessage.contains(expectedMessage);
        Assert.assertEquals(true, actual);
    }
}
