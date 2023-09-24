
public class Boat extends Vehicle {

	String sail_type;
	
	public Boat() {
		// TODO Auto-generated constructor stub
	}

	public Boat(String id, int horsePower, int price, String vehicle, String name, String engine, String manufacturer, String type, String color, String sail_type) {
		super(id, horsePower, price, vehicle, name, engine, manufacturer, type, color);
		this.sail_type = sail_type;
	}

}
