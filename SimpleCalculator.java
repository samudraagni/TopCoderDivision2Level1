import java.io.*;

public class SimpleCalculator{
	public int calculate(String input){
		int op1, op2;
		char op;
		int opIdx = 0;
		int retval = 0;

		for(int i=0; i < input.length(); i++){
			char c = input.charAt(i);
			if("+-/*".indexOf(c) != -1){
				opIdx = i;
				break;
			}
		}

		op1 = Integer.parseInt(input.substring(0,opIdx));
		op2 = Integer.parseInt(input.substring(opIdx+1));
		op = input.charAt(opIdx);

		switch (op) {
			case '+': retval = op1 + op2; break;
			case '-': retval = op1 - op2; break;
			case '*': retval = op1 * op2; break;
			case '/': retval = op1 / op2; break;
		}

		return retval;
	}

	public static void main(String[] args) {
		SimpleCalculator sc = new SimpleCalculator();
		sc.test();
	}

	private void test(){
		String input;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					input = new String("5/3");
					expected = 1;
					obtained = calculate(input);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					input = new String("15*3");
					expected = 45;
					obtained = calculate(input);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					input = new String("1-10000");
					expected = -9999;
					obtained = calculate(input);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					input = new String("0000000000000018/00000000000000000009");
					expected = 2;
					obtained = calculate(input);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\tSuccess");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}