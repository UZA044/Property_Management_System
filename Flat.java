package Question_3;



public class Flat extends Property{
	private double MAINTENANCE_COSTS=500.0;
	private int floor;

	
	
	public Flat(int houseNumber, String street, String city, String postCode, int numberOfRooms, int floor) {
		super(houseNumber, street, city, postCode, numberOfRooms);
		this.floor=floor;
	}


	
	

	public boolean isAvailable() {
		boolean professional_present=false;
		for (Question_3.ITenant i: rooms.values()) {
			if (i.getType()==TenantType.PROFESSIONAL) {
				professional_present=true;
			}
		}
		return (!professional_present);
	}

	public double getPrice() {
		double result = 0;
		for (Room i : this.rooms.keySet()) {
			result += i.getPrice();

		}
		return result;

	}

	public void occupy(Room r, ITenant t) {
		if (isAvailable()) {
			rooms.put(r, t);
		}
		
	}
	

	@Override
	public String toString() {
		int rooms_available=0;
		if (isAvailable()) {
			rooms_available=super.getAvailableRooms();
		}else {
			rooms_available=0;
		}
		return super.toString()+" flat on "+this.floor+" floor"+" :"+rooms_available+" available)";
	}





	@Override
	public String displayOccupiedProperty() {
		double total=500;
		String result = toString();
		for (Room i:rooms.keySet()) {
			result+="\t"+"Room:"+i.getPrice();
			total+=i.getPrice();
			
			
		}
		result+="\t"+"Total: £"+total+" (Council Tax: £"+super.councilTax+")";
		return result;
	}

}
