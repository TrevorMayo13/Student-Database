package studentObject;

import java.util.Arrays;

import main.Student;

public class Result {
	private Student[] results;
	public Result() {
		
	}
	public Student[] getResults() {
		return results;
	}
	public void setResults(Student[] results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "Result [results=" + Arrays.toString(results) + "]";
	}
}
