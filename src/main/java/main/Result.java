package main;

import java.util.Arrays;

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
