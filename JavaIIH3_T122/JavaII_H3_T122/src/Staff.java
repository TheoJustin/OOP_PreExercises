import java.util.Random;

public class Staff extends Employee {

	int overtimeDuration;
	int overtimeFee;
	
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	
	public Staff(String name, int overtimeDuration, int overtimeFee, int salary) {
		String id = generateId();
		this.salary = salary;
		this.name = name;
		this.id = id;
		this.overtimeDuration = overtimeDuration;
		this.overtimeFee = overtimeFee;
		salary = findSalary(overtimeDuration, overtimeFee);
		this.salary = salary;
	}

	@Override
	public int findSalary(int overtimeDuration, int overtimeFee) {
		// TODO Auto-generated method stub
		int salary = getSalary();
		salary += (overtimeDuration*overtimeFee);
		return salary;
	}

	@Override
	public String generateId() {
		// TODO Auto-generated method stub
		
		String id;
		Random random = new Random();
        int x1 = random.nextInt(10);
        int x2 = random.nextInt(10);
        int x3 = random.nextInt(10);
		id = String.format("ST%d%d%d", x1, x2, x3);
		
		return id;

	}
	
	public void updateSalary() {
		// TODO Auto-generated method stub

	}

}
