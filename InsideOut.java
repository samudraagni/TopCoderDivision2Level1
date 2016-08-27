import java.io.*;

public class InsideOut{
	public String unscramble(String line){
		int len = line.length();
		int mid = len/2-1;

		StringBuilder sb = new StringBuilder();
		for(int i=mid; i >= 0; i--){
			sb.append(line.charAt(i));
		}
		for(int i=len-1; i > mid; i--){
			sb.append(line.charAt(i));
		}

		return sb.toString();
	}

	public static void main(String[] args){
		InsideOut is = new InsideOut();
		is.test();
	}

	private void test(){
		String line;
		String expected;
		String obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					line = new String("I ENIL SIHTHSIREBBIG S");
					expected = new String("THIS LINE IS GIBBERISH");
					obtained = unscramble(line);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					line = new String("LEVELKAYAK");
					expected = new String("LEVELKAYAK");
					obtained = unscramble(line);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					line = new String("H YPPAHSYADILO");
					expected = new String("HAPPY HOLIDAYS");
					obtained = unscramble(line);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					line = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
					expected = new String("MLKJIHGFEDCBAZYXWVUTSRQPON");
					obtained = unscramble(line);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					line = new String("RUT OWT SNEH HCNERF EERHTEGDIRTRAP A DNA  SEVODELT");
					expected = new String("THREE FRENCH HENS TWO TURTLEDOVES  AND A PARTRIDGE");
					obtained = unscramble(line);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();
		sb.append("Case "+testNum);

		if(expected.equals(obtained)) sb.append("\tSuccess");
		else sb.append("\tFail");
		sb.append("\nexpected: "+expected+"\nobtained: "+obtained+"\n");

		System.out.println(sb.toString());
	}
}