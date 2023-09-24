import java.util.Random;

public class Employee {
    private String name;
    private int level;
    private double wage;
    private String specialization;
    private String status;
    private int exp;

    public Employee(String name, int level, String specialization, String status, int jobMaxEmployee) {
        this.name = name;
        this.level = level;
        this.specialization = specialization;
        this.status = status;
        this.wage = calculateWage(level);
        this.exp = calculateExp(jobMaxEmployee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        this.wage = calculateWage(level);
    }

    public double getWage() {
        return wage;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    private double calculateWage(int level) {
        Random random = new Random();
        int randomValue = random.nextInt(51) + 100; // Generates a random number between 100 and 150
        return randomValue + (level * 100);
    }

    private int calculateExp(int jobMaxEmployee) {
        Random random = new Random();
        int jobLOC = random.nextInt(2001) + 1000; // Generates a random number between 1000 and 3000
        return 500 + (jobLOC / jobMaxEmployee);
    }
}
