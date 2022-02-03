package studentObject;

public class Street {
	private String number;
	private String name;
	
	@Override
	public String toString() {
		return "Street [number=" + number + ", name=" + name + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Street() {
		
	}
}
