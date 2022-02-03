package studentObject;

import java.util.Arrays;

import main.Student;

public class Data {
	Student[] results;
	Info info;
	public Student[] getResults() {
		return results;
	}
	public void setResults(Student[] results) {
		this.results = results;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public Data() {
		
	}
	@Override
	public String toString() {
		return "Data [results=" + Arrays.toString(results) + ", info=" + info + "]";
	}
	
}
