import java.io.*;

public class TheBlackJackDivTwo{
	public int score(String[] cards){

		int val = 0;

		for(String s : cards){
			char c = s.charAt(0);
			val += getPoint(c);
		}

		return val;
	}

	private int getPoint(char c){
		if(Character.isDigit(c)) return c-'0';
		if(c == 'A') return 11;
		return 10;
	}

	public static void main(String[] args){
		TheBlackJackDivTwo tbc = new TheBlackJackDivTwo();
		tbc.test();
	}

	private void test(){
		String[] cards;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					cards = new String[]{"4S", "7D"};
					expected = 11;
					obtained = score(cards);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					cards = new String[]{"KS", "TS", "QC"};
					expected = 30;
					obtained = score(cards);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					cards = new String[]{"AS", "AD", "AH", "AC"};
					expected = 44;
					obtained = score(cards);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					cards = new String[]{"3S", "KC", "AS", "7C", "TC", "9C", "4H", "4S", "2S"};
					expected = 60;
					obtained = score(cards);
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
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}