import java.io.*;

public class MicroStrings{
	public String makeMicroString(int A, int D)	{
		StringBuilder sb = new StringBuilder();

		sb.append(A);
		while(A-D >= 0){
			A = A-D;
			sb.append(A);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MicroStrings ms = new MicroStrings();
		ms.test();
	}

	private void test(){
		int A, D;

		String expected;
		String obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					A = 12;
					D = 5;
					expected = new String("1272");
					obtained = makeMicroString(A, D);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					A = 3;
					D = 2;
					expected = new String("31");
					obtained = makeMicroString(A, D);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					A = 31;
					D = 40;
					expected = new String("31");
					obtained = makeMicroString(A, D);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					A = 30;
					D = 6;
					expected = new String("3024181260");
					obtained = makeMicroString(A, D);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}