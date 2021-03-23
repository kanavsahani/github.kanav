package github.kanav;

public class GarageClass {
	private CarClass[] garage;
	
	public GarageClass (int n) {
		garage = new CarClass[n];
	}
	
	public void addCar (int i , String name, int year, int mileage) {
		garage[i] = new CarClass(name, year, mileage);
	}
	public double totalWorth () {
		int count = 0;
		for (int i = 0; i < garage.length; i++) {
			if (garage[i] == null) {
				continue;
			}
			else {
				count += garage[i].worth();
			}
			
			
		}
		return count;
	}
	public static void main(String[] args) {
		CarClass car1 = new CarClass ("Ferrari", 2005, 10000);
		CarClass car2 = new CarClass ("Lamborghini", 2008, 5000);
		
		GarageClass garage = new GarageClass(2);
		
		garage.addCar(0, "Ferrari", 2005, 10000);
		garage.addCar(1,"Lamborghini", 2008, 5000);
		
		System.out.println(car1.worth());
		car1.drive(100000);
		System.out.println(car1.worth());

		System.out.println(garage.totalWorth());
	}
}
