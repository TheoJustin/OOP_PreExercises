import java.util.Random;

public class CommissionedEmployee extends Employee {

	int commissionLevel;
	int totalSales;
	
	public CommissionedEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	public CommissionedEmployee(String name, int commissionLevel, int totalSales, int salary) {
		String id = generateId();
		this.salary = salary;
		salary = findSalary(commissionLevel, totalSales);
		this.name = name;
		this.id = id;
		this.commissionLevel = commissionLevel;
		this.totalSales = totalSales;
		this.salary = salary;
		this.salary = salary;
	}

	@Override
	public int findSalary(int commissionLevel, int totalSales) {
		// TODO Auto-generated method stub
		int salary = getSalary();
		salary += (commissionLevel * totalSales);
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
		id = String.format("CE%d%d%d", x1, x2, x3);
		
		return id;

	}

}
