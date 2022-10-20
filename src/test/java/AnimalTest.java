import org.junit.Assert;
import org.junit.Test;
import sprint6.Animal;

import java.util.List;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    Animal animal = new Animal();

    // Семья
    @Test
    public void equalGetFamilyTest() throws Exception {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected, actual);
    }

    // Хищники едят
    @Test
    public void equalEatMeatTest() throws Exception {
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, actual);
    }

    // Травоядные едят
    @Test
    public void equalNotEatMeatTest() throws Exception {
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        Assert.assertEquals(expected, actual);
    }

    // Неизвестный вид животного
    @Test
    public void exceptionTest() {
        String animalKind = "Оно";
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood(animalKind);
        });
        String actualMessage = exception.getMessage();
        boolean actual = actualMessage.contains(expectedMessage);
        Assert.assertEquals(true, actual);
    }
}
