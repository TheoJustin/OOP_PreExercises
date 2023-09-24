
public class Car extends Vehicle {

	String car_type;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String id, int horsePower, int price, String vehicle, String name, String engine, String manufacturer, String type, String color, String car_type) {
		super(id, horsePower, price, vehicle, name, engine, manufacturer, type, color);
		this.car_type = car_type;
	}

}
