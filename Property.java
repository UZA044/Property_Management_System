package Question_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;



abstract class Property {
	private int houseNumber;
	private String street;
	private String city;
	private String postCode;
	private int numberOfRooms;
	protected HashMap<Room, ITenant> rooms;
	protected double councilTax;
	private ArrayList<Complaint> complaints;

	

	public Property(int houseNumber, String street, String city, String postCode, int numberOfRooms) {
		super();
		if (validatePostCode(postCode)) {
			this.postCode = postCode;
		} else {
			throw new IllegalArgumentException("Incorrect");
		}
		this.houseNumber = houseNumber;
		this.street = street;
		if (validateCity(city)) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("Incorrect");
		}
		this.city = city;
		this.postCode = postCode;
		this.numberOfRooms = numberOfRooms;
		this.rooms = new HashMap<Room, ITenant>();
		this.complaints = new ArrayList<Complaint>();
	}
	public ArrayList<Complaint> getComplaints() {
		return complaints;
	}
	public void addComplaint(Complaint complaint) {
		complaints.add(complaint);
		
	}
	public int getAvailableRooms() {
		int result = 0;
		for (ITenant i : this.rooms.values()) {
			if ((i.getType() != TenantType.STUDENT)||(i.getType() != TenantType.PROFESSIONAL)) {
				result += 1;
			}
		}
		return numberOfRooms-result;
	
	}
	public void setCouncilTax(double tax) {
		if (!isAvailable()) {
			int count=0;
			for (ITenant i:rooms.values()) {
				if (i.getType()==TenantType.PROFESSIONAL) {
					count+=1;
				
				}
			}
			if (count==1) {
				this.councilTax=tax-(tax*0.25);
			}else if (count==numberOfRooms) {
				this.councilTax=tax;
			}else {
				this.councilTax=0;
			}
		
	}}
	
	public double getCouncilTax() {
		return this.councilTax;
	}
	private boolean validateCity(String input) {
		if (input=="Guildford") {
			return true;
		}else {
			return false;
		}
		
		
	}
	private boolean validatePostCode(String input) {
		String fORMAT1 = "^[A-Z]{2}+[0-9]{2}+[A-Z]{2}$";
		String fORMAT2 = "^[A-Z]{2}+[0-9]{1}+[ ]+[0-9]{1}+[A-Z]{2}$";
		if ((Pattern.matches(fORMAT1, input)) || (Pattern.matches(fORMAT2, input))) {
			return true;
		} else {
			return false;
		}
	}


	public HashMap<Room, ITenant> getRooms() {
		return rooms;
	}

	public int calculateImpact() {
		int impact=0;
		for (Complaint i:complaints) {
			impact+=i.getSeverity().getWeight();
			
			
		}
		return impact;
	}

	@Override
	public String toString() {
		return this.houseNumber + " " + this.street + ", " + this.city + " " + this.postCode + " (" + this.numberOfRooms
				+ " bedroom";
	}
	public abstract double getPrice();
	public abstract boolean isAvailable();
	public abstract void occupy(Room r,ITenant t);
	public abstract String displayOccupiedProperty();

}