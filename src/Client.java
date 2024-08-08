import java.util.List;
import java.util.Scanner;

public class Client {

    public Client() {
        startMenu();
    }

    Basket basket = new Basket();
    Perishable perishable = new Perishable();
    NonPerishable nonPerishable = new NonPerishable();

    int input = 0;

    private int userInput() {
        Scanner in = new Scanner(System.in);
        input = Integer.parseInt(in.nextLine());
        return input;
    }

    public void startMenu() {
        System.out.println("Добрый день!");
        do {
            System.out.println("Введите номер пункта меню для продолжения:");
            System.out.println("1. Показать доступные к покупке товары");
            System.out.println("2. Показать корзину и действия над корзиной");
            System.out.println("0. Выход");
            userInput(); //DRY - повторяющийся код выведен отдельным методом
            switch (input) {
                case 1:
                    displayItems();
                    addBasket();
                    break;
                case 2:
                    basketMenu();
                    break;
                case 0:
                    System.out.println("До новых встреч!");
                    break;
            }
        } while (input != 0);
    }

    public void basketMenu() {
        showBasket();//DRY - повторяющийся код выведен отдельным методом
        System.out.println("Введите номер пункта меню для продолжения:");
        System.out.println("1. Удалить товар из корзины");
        System.out.println("2. Заказать товары");
        System.out.println("0. Возврат в главное меню");
        userInput();//DRY - повторяющийся код выведен отдельным методом
        switch (input) {
            case 1:
                showBasket();//DRY - повторяющийся код выведен отдельным методом
                editBasket();
                break;
            case 2:
                order();
                break;
            case 0:
                startMenu();
                break;
        }
    }

    public void addBasket() {
        System.out.println("Введите id товара для добавлению в корзину или введите 0 для возврата в главное меню:");
        userInput();//DRY - повторяющийся код выведен отдельным методом
        if (input > 0 && input < 6) {
            int id = input;
            basket.addItemByID(id);
            showBasket();//DRY - повторяющийся код выведен отдельным методом
        } else {
            startMenu();
        }
    }

    public void removeItem() {
        int id = input;
        basket.removeItemByID(id);
    }

    public void editBasket() {
        System.out.println("Введите id товара из корзины для удаления или введите 0 для возврата в главное меню:");
        userInput();//DRY - повторяющийся код выведен отдельным методом
        if (input > 0 && input < 6) {
            removeItem();
            showBasket();//DRY - повторяющийся код выведен отдельным методом
        } else {
            startMenu();
        }
    }

    public void order() {
        basket.clearBasket();
        System.out.println("Заказ успешно оформлен!");
    }

    private void displayItems() {
        List<Item> products = new Items().getItems();
        for (Item prod : products) {
            System.out.println(
                    prod.getId() + ". " +
                            prod.getName() + ", производитель - " +
                            prod.getManufacturer() + ", цена - " +
                            prod.getPrice() + " р."
            );
            //Dependency inversion principle - вывод сообщения будет зависеть от реализации классов
            // perishable и nonPerishable:
            if (prod.getName().contains("Massager") || prod.getName().contains("Hairbrush")) {
                nonPerishable.bestBy();
            } else {
                perishable.bestBy();
                perishable.manufDate();
            }
        }
    }

    private void showBasket() {
        System.out.println("Ваша корзина:");
        basket.displayBasket();
    }
}
