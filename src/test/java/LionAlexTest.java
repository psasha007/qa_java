import org.junit.Assert;
import org.junit.Test;
import sprint6.Feline;
import sprint6.LionAlex;

import java.util.List;

public class LionAlexTest {

    Feline feline = new Feline();
    LionAlex alex;

    // У Алекса нет котят
    @Test
    public void equalGetKittensTest() throws Exception {
        alex = new LionAlex(feline);
        int expectedKittensCount = 0;
        int actual = alex.getKittens();
        Assert.assertEquals(expectedKittensCount, actual);
    }

    // Алекс живет в Нью-Йоркском зоопарке
    @Test
    public void equalGetPlaceOfLivingTest() throws Exception {
        alex = new LionAlex(feline);
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        Assert.assertEquals(expected, actual);
    }

    // У Алекса есть друзья
    @Test
    public void equalGetFriendsTest() throws Exception {
        alex = new LionAlex(feline);
        List<String> expected = List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман");
        List<String> actual = alex.getFriends();
        Assert.assertEquals(expected, actual);
    }
}
