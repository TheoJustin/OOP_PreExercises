public class User {
    private int health;
    private int hunger;
    private int thirst;
    private int shelter;
    private int wood;
    private int food;
    private int water;
    private int herb;

    public User(int health, int hunger, int thirst, int shelter, int wood, int food, int water, int herb) {
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.shelter = shelter;
        this.wood = wood;
        this.food = food;
        this.water = water;
        this.herb = herb;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getShelter() {
        return shelter;
    }

    public int getWood() {
        return wood;
    }

    public int getFood() {
        return food;
    }

    public int getWater() {
        return water;
    }

    public int getHerb() {
        return herb;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setShelter(int shelter) {
        this.shelter = shelter;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setHerb(int herb) {
        this.herb = herb;
    }
}
