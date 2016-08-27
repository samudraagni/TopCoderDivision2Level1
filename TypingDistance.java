import java.io.*;
import java.util.Arrays;

public class TypingDistance{
	public int minDistance(String keyboard, String word){
		int[] pos = new int[26];
		Arrays.fill(pos,-1);
		for(int i=0; i < keyboard.length(); i++){
			pos[keyboard.charAt(i)-'a'] = i;
		}

		int md = 0;
		for(int i=1; i < word.length(); i++){
			int letter1Pos = pos[word.charAt(i-1)-'a'];
			int letter2Pos = pos[word.charAt(i)-'a'];
			
			int distance = (int)Math.abs(letter1Pos - letter2Pos);
			
			md += distance;
		}

		return md;
	}

	public static void main(String[] args){
		TypingDistance td = new TypingDistance();
		td.test();
	}

	private void test(){
		String keyboard;
		String word;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					keyboard = new String("qwertyuiop");
					word = new String("potter");
					expected = 8;
					obtained = minDistance(keyboard, word);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					keyboard = new String("tc");
					word = new String("tctcttccctccccttc");
					expected = 9;
					obtained = minDistance(keyboard, word);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					keyboard = new String("a");
					word = new String("aaaaaaaaaaa");
					expected = 0;
					obtained = minDistance(keyboard, word);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					keyboard = new String("kwadrutove");
					word = new String("rowerowe");
					expected = 39;
					obtained = minDistance(keyboard, word);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					keyboard = new String("qwertyuiopasdfghjklzxcvbnm");
					word = new String("topcodersingleroundmatchgoodluckhavefun");
					expected = 322;
					obtained = minDistance(keyboard, word);
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