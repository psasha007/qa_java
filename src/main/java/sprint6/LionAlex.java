package sprint6;

import java.util.List;

public class LionAlex extends Lion{

    // Конструктор
    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    // Друзья
    public List<String> getFriends()  {
        return List.of("зебра Марти", "бегемотиха Глории", "жираф Мелман");
    }

    // Место жительства
    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }

    // Котят
    @Override
    public int getKittens() {
        return 0;
    }
}
