public class DevelopmentTool {
    private String name;
    private int price;
    private double bonus;
    private String specialization;

    public DevelopmentTool(String name, int price, double bonus, String specialization) {
        this.name = name;
        this.price = price;
        this.bonus = bonus;
        this.specialization = specialization;
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
