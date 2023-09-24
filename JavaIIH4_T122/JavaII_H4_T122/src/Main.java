import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Employee> employeeList = new Vector<>();
	Vector<Employee> ownedEmployeeList = new Vector<>();
	DateUpdater dateUpdater;
	Vector<Building> buildingList = new Vector<>();
	Vector<Building> ownedBuildingList = new Vector<>();
	Vector<DevelopmentTool> developmentTools = new Vector<>();
	Vector<DevelopmentTool> ownedDevelopmentTools = new Vector<>();
	Vector<Job> jobList = new Vector<>();
	Vector<Job> ownedJobList = new Vector<>();
	
	

	public Main() {
		// TODO Auto-generated constructor stub

		menu1();
	}

	private void menu1() {
		// TODO Auto-generated method stub
		int inp = -1;
		do {
			System.out.println("IT SOLUTION TYCOON");
			System.out.println("Menu");
			System.out.println("1. Play game\n2. View Highscore\n3. Exit Game");
			inp = scan.nextInt();
			scan.nextLine();

			switch (inp) {
			case 1:
				playGame();
				break;
			case 2:
				highScore();
				break;
			}
		} while (inp != 3);
	}

	private void highScore() {
		// TODO Auto-generated method stub

	}

	private void playGame() {
		// TODO Auto-generated method stub
		int cash;
		System.out.println("Input your starting cash [100-500] : ");
		cash = scan.nextInt(); scan.nextLine();
		
		int emp;
		System.out.println("Input your starting employee [1-3] : ");
		emp = scan.nextInt(); scan.nextLine();
		
		System.out.println("No, Employee name, Level, Wage, Specialization, Status");
		
		if(emp == 1) {
			Employee employee1 = new Employee("Asep", 2, "UX", "Active", 1);
			employeeList.add(employee1);	
		}else if(emp == 2) {
			Employee employee1 = new Employee("Asep", 2, "UX", "Active", 2);
			Employee employee2 = new Employee("Budi", 3, "Security", "Idle", 2);
			employeeList.add(employee1);
			employeeList.add(employee2);			
		}else {
			Employee employee1 = new Employee("Asep", 2, "UX", "Active", 3);
			Employee employee2 = new Employee("Budi", 3, "Security", "Idle", 3);
			Employee employee3 = new Employee("Cecep", 1, "Database", "Active", 3);
			
			employeeList.add(employee1);
			employeeList.add(employee2);
			employeeList.add(employee3);			
		}

        for (Employee employee : employeeList) {
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Level: " + employee.getLevel());
            System.out.println("Employee Wage: " + employee.getWage());
            System.out.println("Employee Specialization: " + employee.getSpecialization());
            System.out.println("Employee Status: " + employee.getStatus());
            System.out.println();
        }
		
		String cont;
		System.out.println("Are you sure to continue? [Y/N]");
		cont = scan.nextLine();
		if (cont.contains("Y")) {
	        String building;
	        System.out.println("Input starting building [Garage | Apartment | Office]");
	        building = getNextLineWithDefault(); // Use custom method to handle empty input

	        User user = new User(cash, building, null);
	        start_building(user);
	        runGame(user);

	        return;
	    } else {
	        employeeList.clear();
	        playGame();
	    }
	}


	private void start_building(User user) {
		// TODO Auto-generated method stub
		System.out.println("Company Information");
		System.out.println("Cash : " + user.getCash());
		System.out.println("Building : " + user.getBuilding());
		System.out.println("[Employee]");
		System.out.println("No, Employee name, Level, Wage, Specialization, Status");
		
		for (Employee employee : employeeList) {
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Level: " + employee.getLevel());
            System.out.println("Employee Wage: " + employee.getWage());
            System.out.println("Employee Specialization: " + employee.getSpecialization());
            System.out.println("Employee Status: " + employee.getStatus());
            System.out.println();
        }
		
		buildingList.add(new Building("Garage", 2000, 10));
		buildingList.add(new Building("Apartment", 4000, 20));
		buildingList.add(new Building("Office", 8000, 30));

		developmentTools.add(new DevelopmentTool("Arcgeese", 30000, 0.5, "Data Base"));
		developmentTools.add(new DevelopmentTool("Are Studio", 20000, 0.2, "Data Mining"));
		developmentTools.add(new DevelopmentTool("Cheeseco", 25000, 0.3, "Security"));
		developmentTools.add(new DevelopmentTool("Amaze-on", 10000, 0.1, "UX"));
		
		String company;
		System.out.println("Please give your company a name : ");
		company = scan.nextLine();
		
		user.setCompany(company);
		
		int date_day = 5;
        int date_month = 9;
        int date_year = 2012;

        dateUpdater = new DateUpdater("DateUpdater", date_day, date_month, date_year);
        dateUpdater.start();
		
		runGame(user);
	}

	private void runGame(User user) {
	    boolean isPaused = false;
	    String inp;

	    do {
	        int date_day = dateUpdater.getDay();
	        int date_month = dateUpdater.getMonth();
	        int date_year = dateUpdater.getYear();

	        System.out.println("Game is running\nJevon Company\nCash: " + user.getCash()
	                + "\nDate: " + date_day + "-" + date_month + "-" + date_year + "\nCapacity:\nMain Menu");

	        getChar();

	        System.out.println("E exit\nP pause\nH Hire Employee\nB Buy Building\n"
	                + "D buy dev tools\nJ Joblist\nO Show Employee");
	        inp = scan.nextLine().trim();

	        if (inp.isEmpty()) {
	            continue;
	        }

	        switch (inp) {
	            case "P":
	                if (isPaused) {
	                    isPaused = false;
	                    if (dateUpdater != null) {
	                        dateUpdater.pause();
	                    }
	                } else {
	                    isPaused = true;
	                    if (dateUpdater != null) {
	                        dateUpdater.pause();
	                    }
	                }
	                break;
	            case "H":
	                hireEmployee(user);
	                break;
	            case "B":
	            	hireBuilding(user);
	            	break;
	            case "D":
	            	hireDevelopmentTools(user);
	            	break;
	            case "J":
	            	if(!isPaused) {
	                    isPaused = true;
	                    if (dateUpdater != null) {
	                        dateUpdater.pause();
	                    }
	                }
	            	jobList(user);
	                break;
	            case "O":
	            	showEmployee(user);
	            	break;
	            default:
	                System.out.println("Invalid input. Please try again.");
	                break;
	        }
	    } while (!inp.equals("E"));

	    if (dateUpdater != null) {
	        dateUpdater.stop();
	    }
	}


	private void jobList(User user) {
		// TODO Auto-generated method stub
		
	}

	private void showEmployee(User user) {
		// TODO Auto-generated method stub
		for (Employee employee : ownedEmployeeList) {
			System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Level: " + employee.getLevel());
            System.out.println("Employee Wage: " + employee.getWage());
            System.out.println("Employee Specialization: " + employee.getSpecialization());
            System.out.println("Employee Status: " + employee.getStatus());
            System.out.println();
		}
	}

	private void hireDevelopmentTools(User user) {
		// TODO Auto-generated method stub
		System.out.println("no | tool name | tool price | bonus");
		int count = 0;
		for (Building building : buildingList) {
			count++;
			System.out.println(count + " " + building.getName() + " " + building.getPrice() + building.getCapacity());
		}
		System.out.println("Choose tool to purchase [1..4]");
		int inp = scan.nextInt(); scan.nextLine();
		
		ownedDevelopmentTools.add(developmentTools.get(inp-1));
		System.out.println("Successfully bought......");
	}

	private void hireBuilding(User user) {
		// TODO Auto-generated method stub
		System.out.println("no | building type | building price | building capacity");
		int count = 0;
		for (Building building : buildingList) {
			count++;
			System.out.println(count + " " + building.getName() + " " + building.getPrice() + building.getCapacity());
		}
		System.out.printf("Enter the building that you want to buy [1..%d]", count);
		int idx = scan.nextInt(); scan.nextLine();
		
		System.out.printf("Are you sure you want to buy %s? [Y/N]", buildingList.get(idx-1).getName());
		String inp = scan.nextLine();
		
		
		user.setCash(user.getCash()-buildingList.get(idx-1).getPrice());
		System.out.printf("You have successfully bought an %s", buildingList.get(idx-1).getName());
	}

	private void hireEmployee(User user) {
		// TODO Auto-generated method stub
		for (Employee employee : employeeList) {
			System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Level: " + employee.getLevel());
            System.out.println("Employee Wage: " + employee.getWage());
            System.out.println("Employee Specialization: " + employee.getSpecialization());
            System.out.println("Employee Status: " + employee.getStatus());
            System.out.println();
		}
		
		System.out.println("Select employee that you want to hire [1-3]");
		int idx;
		idx = scan.nextInt(); scan.nextLine();
		
		ownedEmployeeList.add(employeeList.get(idx-1));
		user.setCash(user.getCash()-(int)employeeList.get(idx-1).getWage());
		
		System.out.println("Successfully hired " + employeeList.get(idx-1).getName());
		System.out.println("enter to continue");
		scan.nextLine();
	}

	private String getNextLineWithDefault() {
	    String line = scan.nextLine().trim();
	    if (line.isEmpty()) {
	        line = "";
	    }
	    return line;
	}


	private void getChar() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
