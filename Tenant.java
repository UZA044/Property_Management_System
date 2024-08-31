package Question_3;

public class Tenant implements ITenant {
	private String forename;
	private String surname;
	private int age;
	private TenantType type;

	public Tenant(String forename, String surname, int age, TenantType type) {
		super();
		if (forename!=null && surname!=null && type!=null) {
			this.forename = forename;
			this.surname = surname;
			this.type = type;
			if (age>16) {
				this.age=age;
				
			}else {
				throw new IllegalArgumentException("Incorrect");
			}
		}else {
			throw new NullPointerException("Incorrect");
			
		}
		
	}

	@Override
	public String getName() {
		return this.forename + " " + this.surname;

	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	@Override
	public TenantType getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}
