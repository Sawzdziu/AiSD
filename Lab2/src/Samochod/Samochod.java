package Samochod;

public class Samochod {

	String registrationNumber;
	String brand;
	String model;
	int yearOfProduction;
	double engineCapacity;
	String color;

	public Samochod(String rN, String brand, String model, int year,
			double engine, String color) {
		this.registrationNumber = rN;
		this.brand = brand;
		this.model = model;
		this.yearOfProduction = year;
		this.engineCapacity = engine;
		this.color = color;
	}

	public String toString() {
		String registration = "Registration number: " + this.registrationNumber;
		String brandAndModel = " Brand: " + this.brand + " Model: " + this.model;
		String engine = " Engine capacity: " + this.engineCapacity;
		String year = " Year of production: " + this.yearOfProduction;
		String color = " Color: " + this.color;
		return (registration + brandAndModel + engine + year + color);
	}

}
