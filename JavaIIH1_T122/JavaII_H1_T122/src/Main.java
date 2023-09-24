import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.Hero;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	Vector<Hero> heros = new Vector<Hero>();
	
	public int inv = 0;
	
	public void insert() {
		String name;
		int age;
		String gender;
		String type;
		
		int length = -1;
		int weight = -1;
		
		String quality = "NULL";
		int quantity = -1;
		
		
		do{
			System.out.println("Enter name [Name Length >= 5]: ");
		    name = scan.nextLine();
		}while(name.length() < 5);

		
		do{
			System.out.println("Enter age [Age >= 18]: ");
		    age = scan.nextInt();
		    scan.nextLine();
		}while(age < 18);

		
		do{
			System.out.println("Enter gender [Male | Female] (Case Sensitive): ");
		    gender = scan.nextLine();
		}while(!gender.equals("Male") && !gender.equals("Female"));

		
		do{
			System.out.println("Enter type [Melee | Ranged] (Case Sensitive): ");
		    type = scan.nextLine();
		}while(!type.equals("Melee") && !type.equals("Ranged"));
		
		
		if(type.equals("Ranged")) {
			System.out.println("Enter bow quality [Bad | Normal | Good]: ");
			quality = scan.nextLine();
			
			System.out.println("Enter arrow quantity [must be greater than 0]: ");
			quantity = scan.nextInt(); scan.nextLine();
		}else if(type.equals("Melee")) {
			System.out.println("Enter sword length [must be greater than 0]: ");
			length = scan.nextInt(); scan.nextLine();
			
			System.out.println("Enter shield weight [must be greater than 0]: ");
			weight = scan.nextInt(); scan.nextLine();
		}
		
		String id;
		Random random = new Random();
        int x1 = random.nextInt(10);
        int x2 = random.nextInt(10);
        int x3 = random.nextInt(10);
		if(type.equals("Melee")) {
			id = String.format("ML%d%d%d", x1, x2, x3);
		}else {
			id = String.format("RG%d%d%d", x1, x2, x3);
		}
		
		
		heros.add(new Hero(id, name, age, gender, type, length, weight, quality, quantity));
		
		System.out.println("Hero successfully been added\n" + "Press enter to continue");
		scan.nextLine();
		
		inv++;
	}
	
	public void view() {
		if(inv == 0) {
			System.out.println("There are no heroes, please add some heroes to view the heroes\nPress enter to continue");
			scan.nextLine();
		}else {
			int count = 0;
			System.out.println("| No. | Class  | ID    | Name                              | Age | Gender | Sword Length | Shield Weight | Bow Quality | Arrow Quantity |");
			for (Hero h : heros) {
				count++;
				if(h.type.equals("Melee")) {
					System.out.println(count + "  " + h.id + "  " + h.type + "  " + h.name + "  " + h.age + "  " + h.gender + "  " + h.length + "  " + h.weight + " - " + " - ");
				}else {
					System.out.println(count + "  " + h.id + "  " + h.type + "  " + h.name + "  " + h.age + "  " + h.gender + "  " + " - " + " - " + "  " + h.quality + "  " + h.quantity);
				}
			}
		}
	}
	
	public Main() {
		int inp = -1;
		do {
			System.out.println("Zen Hero Academy");
			System.out.println("1. Add hero");
			System.out.println("2. View hero");
			System.out.println("3. Remove hero");
			System.out.println("4. Update hero");
			System.out.println("5. Exit");
			System.out.print(">> ");
			
			inp = scan.nextInt(); scan.nextLine();
					
			switch(inp) {
			case 1:
				insert();
				break;
			case 2:
				view();
				break;
			case 3:
				delete();
				break;
			case 4:
				update();
				break;
			}
			
		}while(inp != 5);
	}
	
	private void delete() {
		int idx = -1;
		view();
		System.out.printf("Input number that you want to delete [0 - %d, 0 to return]: ", inv);
		idx = scan.nextInt(); scan.nextLine();
		
		if(idx != 0) {
			heros.remove(idx-1);
			System.out.println("Hero successfully removed");
		}
		
		System.out.println("Press enter to continue");
		scan.nextLine();
	}
	
	private void update() {
		int idx = -1;
		view();
		System.out.printf("Input number that you want to update [0 - %d, 0 to return]: ", inv);
		idx = scan.nextInt(); scan.nextLine();
		
		String quality = "Null";
		int quantity = -1;
		int weight = -1;
		int length = -1;
		
		Hero selectedHero = heros.get(idx - 1);
        String type = selectedHero.getType();
        
		if(type.equals("Melee")) {
			selectedHero.setType("Ranged");
			
			System.out.println("Enter bow quality [Bad | Normal | Good]: ");
			quality = scan.nextLine();
			
			System.out.println("Enter arrow quantity [must be greater than 0]: ");
			quantity = scan.nextInt(); scan.nextLine();
			
			selectedHero.setQuality(quality);
			selectedHero.setQuantity(quantity);
			selectedHero.setLength(length);
            selectedHero.setWeight(weight);
        }else if (type.equals("Ranged")) {
        	selectedHero.setType("Melee");
        	
        	System.out.println("Enter sword length [must be greater than 0]: ");
			length = scan.nextInt(); scan.nextLine();
			
			System.out.println("Enter shield weight [must be greater than 0]: ");
			weight = scan.nextInt(); scan.nextLine();
			
			selectedHero.setQuality(quality);
			selectedHero.setQuantity(quantity);
			selectedHero.setLength(length);
            selectedHero.setWeight(weight);
        }
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		new Main();
	}

}
