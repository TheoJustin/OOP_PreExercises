import java.util.Random;

public class HourlyEmployee extends Employee {

	int hourly_wage;
	int total_working_hours;
	
	public HourlyEmployee() {
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(String name, int hourly_wage, int total_working_hours) {
		String id = generateId();
		int salary = findSalary(total_working_hours, hourly_wage);
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.hourly_wage = hourly_wage;
		this.total_working_hours = total_working_hours;
	}
	
	@Override
	public int findSalary(int total_working_hours, int hourly_wage) {
		// TODO Auto-generated method stub
		int salary = total_working_hours + hourly_wage;
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
		id = String.format("HE%d%d%d", x1, x2, x3);
		
		return id;
	}
	

}
