import java.util.ArrayList;
import java.util.List;

//Single-responsibility principle - класс Basket предназначен только для действий над корзиной покупок:
public class Basket {

    List<Item> basket = new ArrayList<Item>();

    private Item getItemByID(int id) {
        Item item = null;
        List<Item> items = new Items().getItems();
        for (Item prod : items) {
            if (prod.getId() == id) {
                item = prod;
                break;
            }
        }
        return item;
    }

    public void addItemByID(int id) {
        Item item = getItemByID(id);
        basket.add(item);
    }

    public void displayBasket() {
        for (Item prod : basket) {
            System.out.println(
                    prod.getId() + ". " +
                            prod.getName() + ", производитель - " +
                            prod.getManufacturer() + ", цена - " +
                            prod.getPrice() + " р."
            );
        }
    }

    public void removeItemByID(int id) {
        Item prod = getItemByID(id);
        basket.remove(prod);
    }

    public void clearBasket() {
        basket.clear();
    }
}
