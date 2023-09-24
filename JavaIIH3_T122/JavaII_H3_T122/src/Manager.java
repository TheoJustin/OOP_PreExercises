import java.util.Random;

public class Manager extends Employee {

	int bonus;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String name, int salary, int bonus) {
		String id = generateId();
		salary = findSalary(salary, bonus);
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.bonus = bonus;
	}

	@Override
	public int findSalary(int salary, int bonus) {
		// TODO Auto-generated method stub
		salary += (bonus);
		
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
		id = String.format("MN%d%d%d", x1, x2, x3);
		
		return id;
	}

	public void updateSalary() {
		// TODO Auto-generated method stub

	}
}
