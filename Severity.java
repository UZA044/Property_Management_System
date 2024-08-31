package Question_3;

public enum Severity {
	HIGH, MEDIUM, LOW;
	
	 int getWeight() {
        switch (this) {
            case HIGH:
                return 3;
            case MEDIUM:
                return 2;
            case LOW:
                return 1;}
			return 0;}
}
