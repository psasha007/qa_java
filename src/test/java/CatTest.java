import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import sprint6.Cat;
import sprint6.Feline;

import java.util.List;

public class CatTest {

    Cat cat;
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    // Коты и кошки едят Животных
    @Test
    public void getFoodAnimalTest() throws Exception {
        List<String> food = cat.getFood();
        String expected = "Животные";
        String actual = food.get(0);
        Assert.assertEquals(expected, actual);
    }

    // Коты и кошки едят Птиц
    @Test
    public void getFoodBirdTest() throws Exception {
        List<String> food = cat.getFood();
        String expected = "Птицы";
        String actual = food.get(1);
        Assert.assertEquals(expected, actual);
    }

    // Коты и кошки едят Рыб
    @Test
    public void getFoodFishTest() throws Exception {
        List<String> food = cat.getFood();
        String expected = "Рыба";
        String actual = food.get(2);
        Assert.assertEquals(expected, actual);
    }

    // Коты и кошки говорят Мяу
    @Test
    public void equalSoundTest() throws Exception {
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals(expected, actual);
    }
}
