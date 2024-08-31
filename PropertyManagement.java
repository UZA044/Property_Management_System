package Question_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PropertyManagement {
	private ArrayList<Property> properties;

	public PropertyManagement() {
		super();
		this.properties = new ArrayList<Property>();
	}

	public void addProperty(Property property) {
		this.properties.add(property);
	}

	public void addTenant(Property property, Room r, ITenant t) {
		for (Property i : this.properties) {
			if (i == property) {
				if (property instanceof Flat) {
					if (t.getType()==TenantType.PROFESSIONAL) {
						i.occupy(r, t);

					}
				}else {
					i.occupy(r, t);

					
				}
				
			}

		}
	}

	public void removeProperty(Property property) {
		boolean present = false;
		for (Property i : this.properties) {
			if (i == property) {
				present = true;
			}
		}
		if (present == true) {
			this.properties.remove(property);
		} else {
			throw new IllegalArgumentException("Incorrect");
		}
	}
	public int numberOfPropertyType(String type) {
		int count=0;
		boolean house_selected=false;
		if (type.equals("house")){
			house_selected=true;
			
		}
		for (Property i :this.properties) {
			if ((i instanceof House)&&(house_selected)) {
				count+=1;
			}else if ((i instanceof Flat)&&(!house_selected)) {
				count+=1;
			}
		}
		return count;
		
	}
	public double percentageCouncilTaxExemption() {
		double total=0;
		double exempt=0;
		for (Property i : this.properties) {
			total+=1;

			if ((i.getCouncilTax()==0)&&(i.getAvailableRooms()==0)) {
				exempt+=1;				
			}
			
		}
		return ((exempt/total)*100);
	}
	public String findProblematicProperty() {
		int highest_weight=0;
		Property most_problematic=null;
		for (Property i: this.properties) {
			int current_weight=i.calculateImpact();
			
				
				
			
			if (current_weight>highest_weight) {
				most_problematic=i;
			}
		}
		return most_problematic.toString();
		
	}
	public String displayInfographics() {
		int agebracket1=0;
		int agebracket2=0;
		int agebracket3=0;
		int agebracket4=0;
		int agebracket5=0;
		int prof=0;
		int student=0;
		for (Property i: this.properties) {
			HashMap<Room, ITenant> rooms=i.getRooms();
			for (ITenant k: rooms.values()) {
				if (k!=null) {
					if (k.getType()==TenantType.PROFESSIONAL) {
						prof+=1;
					}else {
						student+=1;
					}
					
					if ((k.getAge()>=17)&&(k.getAge()<=25)){
						agebracket1+=1;
						
					}else if ((k.getAge()>=26)&&(k.getAge()<=35)){
						agebracket2+=1;
						
					}else if ((k.getAge()>=36)&&(k.getAge()<=49)){
						agebracket3+=1;
						
					}else if ((k.getAge()>=50)&&(k.getAge()<=60)){
						agebracket4+=1;
						
					}else {
						agebracket5+=1;
					}
					
				}
			}
			
			
		}
		return "Confirmed Tenant Summary:"+"\n"
		+"17-25:"+agebracket1+"\n"
		+"26-35:"+agebracket2+"\n"
		+"36-49:"+agebracket3+"\n"
		+"50-60:"+agebracket4+"\n"
		+"60+:"+agebracket5+"\n"
		+"*****"+"\n"
		+"Professional:"+prof+"\n"
		+"Student:"+student;
	}
	public String displayProperties() {
		String result = "";
		for (Property i : this.properties) {
			if (i.getAvailableRooms()>0) {
				result+=i.toString()+"\n";
			}else {
				result+=i.displayOccupiedProperty();
			}
		}
		return result;
	}

}
