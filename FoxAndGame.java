import java.io.*;

public class FoxAndGame{
	
	public int countStars(String[] result){
		int val = 0;
		int len = result.length;

		for(int i=0; i < len; i++){
			String row = result[i];
			if(row.equals("o--")) val += 1;
			else if(row.equals("oo-")) val += 2;
			else if(row.equals("ooo")) val += 3;
		}

		return val;
	}

	public static void main(String[] args){
		FoxAndGame f = new FoxAndGame();
		f.test();
	}

	private void test(){
		String[] result;
		int expected;
		int obtained;

		int numTests = 7;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					result = new String[]{"ooo", "ooo"};
					expected = 6;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					result = new String[]{"ooo", "oo-", "o--"};
					expected = 6;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					result = new String[]{"ooo", "---", "oo-", "---", "o--"};
					expected = 6;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					result = new String[]{"o--", "o--", "o--", "ooo", "---"};
					expected = 6;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					result = new String[]{"---", "o--", "oo-", "ooo", "ooo", "oo-", "o--", "---"};
					expected = 12;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 5:{
					result = new String[]{"---", "---", "---", "---", "---", "---"};
					expected = 0;
					obtained = countStars(result);
					printResult(i, expected, obtained);
					break;
				}
				case 6:{
					result = new String[]{"oo-"};
					expected = 2;
					obtained = countStars(result);
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