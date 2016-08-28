import java.io.*;

public class AccountBalance{
	public int processTransactions(int startingBalance, String[] transactions){
		int val = startingBalance;
		for(String s:transactions){
			val = process(val, s);
		}
		return val;
	}

	private int process(int val, String s){
		String[] parts = s.split(" ");
		int retval = 0;
		if(parts[0].equals("D")){
			retval = val - Integer.parseInt(parts[1]);
		}
		else if(parts[0].equals("C")){
			retval = val + Integer.parseInt(parts[1]);
		}
		return retval;
	}

	public static void main(String[] args){
		AccountBalance ab = new AccountBalance();
		ab.test();
	}

	private void test(){
		int startingBalance;
		String[] transactions;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					startingBalance = 100;
					transactions = new String[]{"C 1000", "D 500", "D 350"};
					expected = 250;
					obtained = processTransactions(startingBalance, transactions);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					startingBalance = 100;
					transactions = new String[]{};
					expected = 100;
					obtained = processTransactions(startingBalance, transactions);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					startingBalance = 100;
					transactions = new String[]{"D 50", "D 20", "D 40"};
					expected = -10;
					obtained = processTransactions(startingBalance, transactions);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					startingBalance = 53874;
					transactions = new String[]{"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"};
					expected = 10580;
					obtained = processTransactions(startingBalance, transactions);
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
		else sb.append("\tFail");
		sb.append("\texpected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}