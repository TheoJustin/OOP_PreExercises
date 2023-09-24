import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	int inv = 0;
	
	Vector<Department> department = new Vector<Department>();
	private HourlyEmployee Employee;
	
	public Main() {
		int inp = -1;
		do {
			System.out.println("Staff Management - Bluejack Company");
			System.out.println("===================================");
			System.out.println("1. View Company");
			System.out.println("2. Manage Department");
			System.out.println("3. Manage Employee");
			System.out.print(">> ");
			
			inp = scan.nextInt(); scan.nextLine();
					
			switch(inp) {
			case 1:
				view();
				break;
			case 2:
				insert_department();
				break;
			case 3:
				insert_employee();
				break;
			}
			
		}while(inp != 4);
		
		System.out.println("Thank you for using the program...");
	}
	
	private void insert_employee2(String name) {
		
		System.out.println(name);
		for (Department d : department) {
			if(d.name.contains(name)) {
				System.out.println("=========================================\r\n"
						+ "              Employee List\r\n"
						+ "=========================================");
				System.out.println("Total payroll = " + d.payroll);
				if(d.employee == null) {
					System.out.println("=========================================\r\n"
							+ "There are no employee at this department\r\n"
							+ "=========================================\r\n"
							+ "\r\n"
							+ "Add employee!\r\n"
							+ "Press enter to continue...");
					scan.nextLine();
				}else {
					System.out.println("=========================================\r\n"
							+ "  ID  |      Name     |   Total Salary  |\r\n"
							+ "=========================================\r\n");
					for (int i = 0; i < d.employee.size(); i++) {
						System.out.println(d.employee.get(i).id + "  " + d.employee.get(i).name + "  " + d.employee.get(i).salary);
					}
					System.out.println("=========================================");
				}
				break;
			}
		}
		
		int inp = -1;
		do {
			System.out.println("Employee category\r\n"
					+ "=================\r\n"
					+ "1. Hourly employee\r\n"
					+ "2. Commissioned employee\r\n"
					+ "3. Staff\r\n"
					+ "4. Manager\r\n"
					+ "5. Exit\r\n"
					+ ">>");
			
			inp = scan.nextInt(); scan.nextLine();
			switch(inp) {
			case 1:
				create_hourly(name);
				break;
			case 2:
				create_comissioned(name);
				break;
			case 3:
				create_staff(name);
				break;
			case 4:
				create_manager(name);
				break;
			}
		}while(inp != 5);
	}
	
	private void insert_employee() {
		// TODO Auto-generated method stub
		String name;
		view();
		System.out.println("Choose department to manage the employees\r\n"
				+ "Input department name:");
		name = scan.nextLine();
		insert_employee2(name);						
//		for (Department d : department) {
//			if(d.name.contains(name)) {
//				int inp = -1;
//				do{
//					System.out.println("Staff Management - Bluejack Company\r\n"
//							+ "===================================\r\n"
//							+ "1. View Company\r\n"
//							+ "2. Manage Department\r\n"
//							+ "3. Manage Employee\r\n"
//							+ "4. Exit\r\n"
//							+ ">>");
//					
//					inp = scan.nextInt(); scan.nextLine();
//					switch(inp) {
//					case 1:
//						break;
//					case 2:
////						delete_employee(name);
//						break;
//					case 3:
//					
//						break;
//					}
//					
//				}while(inp != 4);
//				break;
//			}
//		}
	}

//	private void delete_employee(String name) {
//		// TODO Auto-generated method stub
//		for (Department d : department) {
//	        if (d.name.contains(name)) {
//	            if (d.employee == null || d.employee.isEmpty()) {
//	                System.out.println("There are no employees in this department.");
//	            } else {
//	                System.out.println("Employee List");
//	                System.out.println("=========================================");
//	                System.out.println("ID | Name");
//	                for (int i = 0; i < d.employee.size(); i++) {
//	                    System.out.println(d.employee.get(i).name);
//	                }
//	                System.out.println("=========================================");
//	                System.out.println("Input employee ID: ");
//	                int id = scan.nextInt(); scan.nextLine();
//	                if (id > 0 && id <= d.employee.size()) {
//	                    d.employee.remove(id - 1);
//	                    System.out.println("Employee successfully deleted.");
//	                } else if (id != 0) {
//	                    System.out.println("Invalid ID. No employee deleted.");
//	                }
//	            }
//	            break;
//	        }
//	    }
//	    System.out.println("Press enter to continue...");
//	    scan.nextLine();
//	}

	private void create_manager(String name) {
		// TODO Auto-generated method stub
		String employee;
		int salary;
		int bonus;
		view();
		System.out.println("Input employee name: ");
		employee = scan.nextLine();
		
		System.out.println("Input employee base salary (<= 1000000): ");
		salary = scan.nextInt(); scan.nextLine();
		
		System.out.println("Input bonus (<= 1000000):");
		bonus = scan.nextInt(); scan.nextLine();
		
		for(int i = 0; i < department.size(); i++){
			if(department.get(i).name.contains(name)){
				department.get(i).employee.add(new Manager(employee, salary, bonus));
				break;
			}
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	private void create_staff(String name) {
		// TODO Auto-generated method stub
		String employee;
		System.out.println("Input staff name:");
		employee = scan.nextLine();
		
		int salary;
		System.out.println("Input staff salary (<= 5000000):");
		salary = scan.nextInt(); scan.nextLine();
		
		int overtime;
		System.out.println("Input overtime duration (<= 10 hours):");
		overtime = scan.nextInt(); scan.nextLine();
		
		int fee;
		System.out.println("Input overtime fee (<= 50000):");
		fee = scan.nextInt(); scan.nextLine();
		
		for(int i = 0; i < department.size(); i++){
			if(department.get(i).name.contains(name)){
				department.get(i).employee.add(new Staff(employee, overtime, fee, salary));
				break;
			}
		}
	}

	private void create_comissioned(String name) {
		// TODO Auto-generated method stub
		String employee;
		System.out.println("Input employee name:");
		employee = scan.nextLine();
		
		int salary;
		System.out.println("Input employee base salary (<= 1000000):");
		salary = scan.nextInt(); scan.nextLine();
		
		int level;
		System.out.println("Input employee commission level (<= 25000):");
		level = scan.nextInt(); scan.nextLine();
		
		int sales;
		System.out.println("Input employee total total sales (>= 10):");
		sales = scan.nextInt(); scan.nextLine();
		
		for(int i = 0; i < department.size(); i++){
			if(department.get(i).name.contains(name)){
				department.get(i).employee.add(new CommissionedEmployee(employee, level, sales, salary));
				break;
			}
		}
		
	}

	private void create_hourly(String name) {
		// TODO Auto-generated method stub
		String employee;
		System.out.println("Input employee name:");
		employee = scan.nextLine();

		int wage;
		System.out.println("Input employee hourly wage (>= 50000):");
		wage = scan.nextInt(); scan.nextLine();
		
		int working_hours;
		System.out.println("Input employee total working hour (<= 10 hours):");
		working_hours = scan.nextInt(); scan.nextLine();
		
		
		for(int i = 0; i < department.size(); i++){
	        if(department.get(i).name.contains(name)){
	            department.get(i).employee.add(new HourlyEmployee(employee, wage, working_hours));
	            break;
	        }
	    }
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
	}

	private void insert_department() {
		// TODO Auto-generated method stub
		if(inv == 0) {
			System.out.println("There is no Department\r\n"
					+ "=============================================\r\n"
					+ "Add Department!\r\n"
					+ "Press enter to continue...");
			scan.nextLine();
			input_department();
		}else {
			view();
			
			int inp = -1;
			do {
				System.out.println("1. Add Department");
				System.out.println("2. Delete Department");
				System.out.println("3. Back");
				System.out.print(">> ");
				
				inp = scan.nextInt(); scan.nextLine();
						
				switch(inp) {
				case 1:
					input_department();
					break;
				case 2:
					delete_department();
					break;
				}
				
			}while(inp != 3);
		}
	}
	
	private void delete_department() {
		// TODO Auto-generated method stub
		String name;
		if(inv == 0) {
			
		}else {
			view();
			System.out.println("Input department name:");
			name = scan.nextLine();
			for(int i = 0; i < department.size(); i++){
		        if(department.get(i).name.contains(name)){
		            department.remove(i);
		            break;
		        }
		    }
			inv--;
		}
	}

	private void input_department() {
		String name;
		System.out.println("Input department name:");
		name = scan.nextLine();
		Vector<Employee> employee = new Vector<>();
		department.add(new Department(employee, name, 0, 0));
		inv++;
	}

	private void view() {
		// TODO Auto-generated method stub
		System.out.println("Department List\r\n"
			+ "=============================================\r\n"
			+ "No|                Department");
		
		int count = 0;
		for (Department d : department) {
			count++;
			System.out.println(count + " | " + d.name + " (total sales : " + d.sales + ", payroll : " + d.payroll + ")");
		}
		
		
		System.out.println("=============================================");
	}

	public static void main(String[] args) {
		new Main();
	}

}
