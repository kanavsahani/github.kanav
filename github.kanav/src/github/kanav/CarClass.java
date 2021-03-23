package github.kanav;

public class CarClass {
	private String name;
	private int year;
	private int mileage;
	
	public CarClass (String name, int year, int mileage) {
		this.name = name;
		this.year = year;
		this.mileage = mileage;
	}
	
	public int drive (int distance) {
		return mileage += distance;
	}
	public double worth () {
		return 2022 - year * 1.0/mileage;
	}
	public void setMileage (int newMileage) {
		mileage = newMileage;
		}
	public int getMileage () {
		return mileage;
	}
}
