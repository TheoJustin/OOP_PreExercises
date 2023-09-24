import java.util.Vector;

public class Department {

	Vector<Employee> employee;
	String name;
	int payroll;
	int sales;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(Vector<Employee> employee, String name, int payroll, int sales) {
		this.name = name;
		this.payroll = payroll;
		this.sales = sales;
		this.employee = employee;
	}

}
