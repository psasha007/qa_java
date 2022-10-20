import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import sprint6.Feline;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
        MockitoAnnotations.initMocks(this);
    }

    // Семья кошачьих, stab
    @Test
    public void equalGetFamilyStabTest() throws Exception {
        Feline feline2 = new Feline();
        String expected = feline2.getFamily();
        Mockito.when(feline.getFamily()).thenReturn( "Кошачьи");
        Assert.assertEquals(expected, feline.getFamily());
    }

    // меню Хищников
    @Test
    public void equalEatMeatTest() throws Exception {
        List<String> expected = feline.eatMeat();
        List<String> actual = feline.getFood("Хищник");
        Assert.assertEquals(expected, actual);
    }

    // проверяем вызов метода getKittens() с аргументом 10
    @Test
    public void getKittensArgumentMockTest() throws Exception {
        feline.getKittens(10);
        Mockito.verify(feline).getKittens(10);
    }

    // сколько раз вызвали метод getKittens
    @Test
    public void getKittensHowManyTimesMockTest() throws Exception {
        feline.getKittens(10);
        feline.getKittens(10);
        feline.getKittens(10);
        Mockito.verify(feline, Mockito.times(3)).getKittens(10);
    }

    // проверяем вызов метода getKittens() без аргумента, используем stub
    @Test
    public void getKittensStubTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(100);
        Assert.assertEquals(100, feline.getKittens());
    }
}
