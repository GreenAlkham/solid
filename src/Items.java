import java.util.ArrayList;
import java.util.List;

public class Items {

    private final List<Item> items = new ArrayList<Item>();

    public Items() {
        this.itemsList();
    }

    public List<Item> getItems() {
        return items;
    }

    public void itemsList() {
        String[] name = {"Soap", "Pet Food", "Vitamins", "Massager", "Hairbrush"};
        String[] manufacturer = {"Africa Heritage", "Cat-Man-Doo", "NowFoods", "Re-Fa", "Tangle Teezer"};
        Integer[] price = {300, 120, 1800, 3000, 1200};
        //MAGYC - вместо Integer [] id = {1, 2, 3, 4, 5}; id задается в цикле for как i+1:
        for (int i = 0; i < name.length; i++) {
            this.items.add(new Item(i + 1, name[i], manufacturer[i], price[i]));
        }
    }
}