
public class Plane extends Vehicle {

	String plane_wing;
	public Plane() {
		// TODO Auto-generated constructor stub
	}

	public Plane(String id, int horsePower, int price, String vehicle, String name, String engine, String manufacturer, String type, String color, String plane_wing) {
		super(id, horsePower, price, vehicle, name, engine, manufacturer, type, color);
		this.plane_wing = plane_wing;
		// TODO Auto-generated constructor stub
	}

}
