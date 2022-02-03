package main;

public class Registered {
	private String date;
	private String age;
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
	@Override
	public String toString() {
		return "Registered [date=" + date + ", age=" + age + "]";
	}
	public Registered() {
		
	}
}
