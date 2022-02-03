package main;

public class dateOfBirth {
	private String date;
	private String age;
	
	@Override
	public String toString() {
		return "dateOfBirth [date=" + date + ", age=" + age + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public dateOfBirth() {
		
	}
	
}
