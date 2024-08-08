public class NonPerishable implements BestBy {

    @Override
    public void bestBy() {
        String message = "Срок годности не ограничен";
        System.out.println(message);
    }
}
