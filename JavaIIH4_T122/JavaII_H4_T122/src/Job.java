import java.util.Random;

public class Job {
    private String title;
    private String company;
    private String location;
    private int salary;
    private String specialization;
    private int deadlineDays;
    private int maxEmployees;
    private int loc;
    private int payment;

    public Job(String title, String company, String location, int salary, String specialization, int deadlineDays) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.salary = salary;
        this.specialization = specialization;
        this.loc = getRandomNumberInRange(1000, 3000);
        this.deadlineDays = calculateDeadlineDays();
        this.maxEmployees = getRandomNumberInRange(1, 5);
        this.payment = calculatePayment();
    }

    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private int calculateDeadlineDays() {
        return (int) ((this.loc / 100) * (1.0 / 3.0));
    }

    private int calculatePayment() {
        return (this.loc * 15) - (this.deadlineDays * 10);
    }

    public void displayDetails() {
        System.out.println("Job Title: " + title);
        System.out.println("Company: " + company);
        System.out.println("Location: " + location);
        System.out.println("Salary: " + salary);
        System.out.println("Specialization: " + specialization);
        System.out.println("Deadline Days: " + deadlineDays);
        System.out.println("Max Employees: " + maxEmployees);
        System.out.println("LOC: " + loc);
        System.out.println("Payment: " + payment);
    }
}
