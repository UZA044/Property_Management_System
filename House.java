package Question_3;


public class House extends Property {
	

	public House(int houseNumber, String street, String city, String postCode, int numberOfRooms) {
		super(houseNumber, street, city, postCode, numberOfRooms);
		// TODO Auto-generated constructor stub
	}

	public boolean isAvailable() {
		if (getAvailableRooms() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public double getPrice() {
		double result = 0;
		for (Room i : this.rooms.keySet()) {
			result += i.getPrice();

		}
		return result;

	}

	public void occupy(Room r, Question_3.ITenant t) {
		if (!(rooms.get(r) != null)) {
			rooms.put(r, t);
		}

	}

	

	@Override
	public String toString() {
		return super.toString()+" house :"+super.getAvailableRooms()+" available)";
		
	}

	@Override
	public String displayOccupiedProperty() {
		double total=0;
		String result = toString()+"\n";
		for (Room i:rooms.keySet()) {
			result+="\t"+"Room: "+i.getPrice()+"\n";
			total+=i.getPrice();
			
			
		}
		result+="\t"+"Total: £"+total*12+"0 (Council Tax: £"+super.councilTax+")"+"\n";
		return result;
	}



}
