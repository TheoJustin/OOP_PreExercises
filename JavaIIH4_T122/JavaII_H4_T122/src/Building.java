public class Building {
    private String name;
    private int price;
    private int capacity;
    private double expense;

    public Building(String name, int price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.expense = 0.1 * price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
