import java.io.*;

public class CheckFunction{

	public int newFunction(String code){
		int [] numDashes = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

		int sum = 0;
		for(int i=0; i < code.length(); i++){
			sum += numDashes[code.charAt(i)-'0'];
		}

		return sum;
	}

	public static void main(String[] args){

		CheckFunction cf = new CheckFunction();

		cf.printResult(157, cf.newFunction("73254370932875002027963295052175"));
		cf.printResult(28, cf.newFunction("02468"));
		cf.printResult(21, cf.newFunction("13579"));
	}

	private void printResult(int expected, int obtained){
		if(expected == obtained) System.out.println("Success.");
		else System.out.println("Fail.");

		System.out.println("Expected "+expected+" got "+obtained+".\n");
	}
}

/* PV

public class CheckFunction{

	public int newFunction(String code){
		int [] numDashes = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

		int sum = 0;
		for(int i=0; i < code.length(); i++){
			sum += numDashes[code.charAt(i)-'0'];
		}

		return sum;
	}
}

*/