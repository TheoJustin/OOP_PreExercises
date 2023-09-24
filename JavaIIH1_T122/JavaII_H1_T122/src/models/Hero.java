package models;

public class Hero {
	
	public String id;
	public String name;
	public int age;
	public String gender;
	public String type;
	public int length;
	public int weight;
	public String quality;
	public int quantity;
	
	
	public Hero(String id, String name, int age, String gender, String type, int length, int weight, String quality, int quantity) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
		this.length = length;
		this.weight = weight;
		this.quality = quality;
		this.quantity = quantity;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
