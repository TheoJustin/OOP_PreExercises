public class User {
    private int cash;
    private String building;
    private String company;

    public User(int cash, String building, String company) {
        this.cash = cash;
        this.building = building;
        this.company = company;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
