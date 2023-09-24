import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	Vector<Boat> boats = new Vector<Boat>();
	Vector<Plane> planes = new Vector<Plane>();
	Vector<Car> cars = new Vector<Car>();
	
	public int invCars = 0;
	public int invBoats = 0;
	public int invPlanes = 0;
	
	public void insert() {
		String vehicle;
		String name;
		String engine;
		String manufacturer;
		String type;
		String color;
		
		String car_type;
		String boat_type;
		String plane_wing;
		
		do{
            System.out.println("Input Vehicle (Boat / Car / Plane) [Case sensitive] : ");
            vehicle = scan.nextLine();
        }while(!vehicle.matches("Boat|Car|Plane"));

        do{
            System.out.println("Input Vehicle name (3 - 15 chars) :");
            name = scan.nextLine();
        }while(name.length() < 3 || name.length() > 15);

        do{
            System.out.println("Input Engine's name (5 - 20 chars)  :");
            engine = scan.nextLine();
        }while(engine.length() < 5 || engine.length() > 20);

        do{
            System.out.println("Input Engine's Manufacturer (Yamaha / Suzuki / Honda) [Case sensitive] :");
            manufacturer = scan.nextLine();
        }while(!manufacturer.matches("Yamaha|Suzuki|Honda"));

        do{
            System.out.println("Input Engine's type (Electric / Diesel / Turbine) [Case sensitive] : ");
            type = scan.nextLine();
        }while(!type.matches("Electric|Diesel|Turbine"));

        do{
            System.out.println("Input Vehicle color (Black / White / Grey) [Case sensitive] : ");
            color = scan.nextLine();
        }while(!color.matches("Black|White|Grey"));
		
		String id;
		Random random = new Random();
        int x1 = random.nextInt(10);
        int x2 = random.nextInt(10);
        int x3 = random.nextInt(10);
		id = String.format("VH%d%d%d", x1, x2, x3);
		
		int horsePower;
		if(manufacturer.contains("Yamaha")) {
			if(type.contains("Electric")) {
				horsePower = (250+80)*2;								
			}else if(type.contains("Diesel")) {
				horsePower = (250+50)*2;				
			}else {
				horsePower = (250+120)*2;	
			}
		}else if(manufacturer.contains("Suzuki")) {
			if(type.contains("Electric")) {
				horsePower = (275+80)*2;								
			}else if(type.contains("Diesel")) {
				horsePower = (275+50)*2;				
			}else {
				horsePower = (275+120)*2;	
			}
		}else {
			if(type.contains("Electric")) {
				horsePower = (300+80)*2;								
			}else if(type.contains("Diesel")) {
				horsePower = (300+50)*2;				
			}else {
				horsePower = (300+120)*2;	
			}		
		}
		
		int price = (horsePower*5000) + 50000;
		
		
		if(vehicle.contains("Boat")) {
			do {
				System.out.println("Input Boat's sail type (Triangle / Spinnaker / Square) [Case sensitive] :");
				boat_type = scan.nextLine();
			}while (!boat_type.matches("Triangle|Spinnaker|Square"));
			boats.add(new Boat(id, horsePower, price, vehicle, name, engine, manufacturer, type, color, boat_type));
			invBoats++;
		}else if(vehicle.contains("Plane")) {
			do {				
				System.out.println("Input Plane's wing type (Straight / Delta / High) [Case sensitive] :");
				plane_wing = scan.nextLine();
			}while (!plane_wing.matches("Straight|Delta|High"));
			planes.add(new Plane(id, horsePower, price, vehicle, name, engine, manufacturer, type, color, plane_wing));
			invPlanes++;
		}else if(vehicle.contains("Car")) {
			do {
				System.out.println("Input car's type (Sedan, Truck, SUV) [Case sensitive] :");	
				car_type = scan.nextLine();				
			}while (!car_type.matches("Sedan|Truck|SUV"));
			cars.add(new Car(id, horsePower, price, vehicle, name, engine, manufacturer, type, color, car_type));
			invCars++;
		}
		
	}
	
	public void view() {
		String choice;
		System.out.println("Input choice (Boat / Car / Plane) [Case sensitive] :");
		choice = scan.nextLine();
		
		if(choice.contains("Car")) {
			if(invCars == 0) {
				System.out.println("There's no vehicle with Car type in the list\r\n" + "Press enter to go back...");
				scan.nextLine();				
			}else {
				for (Car car : cars) {
					System.out.println("id: " + car.id +
			                   ", name: " + car.name +
			                   ", price: " + car.price +
			                   ", horsepower: " + car.horsePower +
			                   ", color: " + car.color +
			                   ", engine: " + car.engine +
			                   ", manufacturer: " + car.manufacturer +
			                   ", car type: " + car.car_type);				
				}
			}
		}else if(choice.contains("Plane")) {
			if(invPlanes == 0) {
				System.out.println("There's no vehicle with Plane type in the list\r\n" + "Press enter to go back...");
				scan.nextLine();				
			}else {
				for (Plane plane : planes) {
					System.out.println("id: " + plane.id +
			                   ", name: " + plane.name +
			                   ", price: " + plane.price +
			                   ", horsepower: " + plane.horsePower +
			                   ", color: " + plane.color +
			                   ", engine: " + plane.engine +
			                   ", manufacturer: " + plane.manufacturer +
			                   ", plane wing: " + plane.plane_wing);				
				}
			}
		}else if(choice.contains("Boat")) {
			if(invBoats == 0) {
				System.out.println("There's no vehicle with Boat type in the list\r\n" + "Press enter to go back...");
				scan.nextLine();				
			}else {
				for (Boat boat : boats) {
					System.out.println("id: " + boat.id +
			                   ", name: " + boat.name +
			                   ", price: " + boat.price +
			                   ", horsepower: " + boat.horsePower +
			                   ", color: " + boat.color +
			                   ", engine: " + boat.engine +
			                   ", manufacturer: " + boat.manufacturer +
			                   ", sail type: " + boat.sail_type);				
				}
			}
		}
	}
	
	public Main() {
		int inp = -1;
		do {
			System.out.println("Welcome to Merci Company");
			System.out.println("1. View vehicles");
			System.out.println("2. Create a vehicle");
			System.out.println("3. Delete vehicle");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			inp = scan.nextInt(); scan.nextLine();
					
			switch(inp) {
			case 1:
				view();
				break;
			case 2:
				insert();
				break;
			case 3:
				delete();
				break;
			}
			
		}while(inp != 4);
		
		System.out.println("Thank you for using the program...");
	}
	
	private void viewAll() {
		for (Boat boat : boats) {
			System.out.println("id: " + boat.id +
	                   ", name: " + boat.name +
	                   ", price: " + boat.price +
	                   ", horsepower: " + boat.horsePower +
	                   ", color: " + boat.color +
	                   ", engine: " + boat.engine +
	                   ", manufacturer: " + boat.manufacturer +
	                   ", sail type: " + boat.sail_type);				
		}
		
		for (Plane plane : planes) {
			System.out.println("id: " + plane.id +
	                   ", name: " + plane.name +
	                   ", price: " + plane.price +
	                   ", horsepower: " + plane.horsePower +
	                   ", color: " + plane.color +
	                   ", engine: " + plane.engine +
	                   ", manufacturer: " + plane.manufacturer +
	                   ", plane wing: " + plane.plane_wing);				
		}
		
		for (Car car : cars) {
			System.out.println("id: " + car.id +
	                   ", name: " + car.name +
	                   ", price: " + car.price +
	                   ", horsepower: " + car.horsePower +
	                   ", color: " + car.color +
	                   ", engine: " + car.engine +
	                   ", manufacturer: " + car.manufacturer +
	                   ", car type: " + car.car_type);				
		}
		
	}
	
	private void delete() {
		viewAll();
		
		System.out.println("Input vehicle ID (Input 0 to go back): ");
		String id;
		id = scan.nextLine();
		
	    boolean found = false;

	    for(int i = 0; i < boats.size(); i++){
	        if(boats.get(i).id.equals(id)){
	            boats.remove(i);
	            found = true;
	            invBoats--;
	            break;
	        }
	    }

	    if(!found){
	        for(int i = 0; i < planes.size(); i++){
	            if(planes.get(i).id.equals(id)){
	                planes.remove(i);
	                found = true;
	                invPlanes--;
	                break;
	            }
	        }
	    }

	    if(!found){
	        for (int i = 0; i < cars.size(); i++){
	            if(cars.get(i).id.equals(id)){
	                cars.remove(i);
	                found = true;
	                invCars--;
	                break;
	            }
	        }
	    }

	    if(found){
	        System.out.println("Remove Success!");
	    } else {
	        System.out.println("ID not found");
	    }
	}

	public static void main(String[] args) {
//		System.out.println("Hello World");
		new Main();
	}

}
