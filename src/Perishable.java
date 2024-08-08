import java.util.Date;

public class Perishable implements BestBy, ManufDate {
    //Interface Segregation Principle - реализованы два отдельных интерфейса вместо одного большого
    @Override
    public void bestBy() {
        String message = "Срок годности - 1 год.";
        System.out.println(message);
    }

    @Override
    public void manufDate() {
        Date manufDate = new Date(124, 6, 16);
        System.out.printf("%1$s %2$td %2$tB %2$tY", "Дата производства - ", manufDate);
        System.out.println();
    }
}
