import java.io.*;
import java.util.Arrays;

public class Justifier{
	public String[] justify(String[] textIn){
		int maxLen = 0;
		for(String s:textIn){
			if(s.length() > maxLen){
				maxLen = s.length();
			}
		}

		for(int i=0; i < textIn.length; i++){
			String s = textIn[i];
			if(s.length() < maxLen){
				int numSpaces = maxLen - s.length();
				StringBuilder sb = new StringBuilder();
				for(int j=0; j < numSpaces; j++){
					sb.append(" ");
				}
				sb.append(s);
				textIn[i] = sb.toString();
			}
		}

		return textIn;
	}

	public static void main(String[] args) {
		Justifier jst = new Justifier();
		jst.test();
	}

	private void test(){
		String[] textIn;
		String[] expected;
		String[] obtained;

		int numTests = 3;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					textIn = new String[]{"BOB","TOMMY","JIM"};
					expected = new String[]{"  BOB",  "TOMMY",  "  JIM"};
					obtained = justify(textIn);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					textIn = new String[]{"LONGEST","A","LONGER","SHORT"};
					expected = new String[]{"LONGEST","      A",  " LONGER",  "  SHORT"};
					obtained = justify(textIn);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					textIn = new String[]{"JOHN","JAKE","ALAN","BLUE"};
					expected = new String[]{"JOHN","JAKE","ALAN","BLUE"};
					obtained = justify(textIn);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String[] expected, String[] obtained){
		StringBuilder sb = new StringBuilder();

		boolean pass = true;
		for(int i = 0; i < expected.length; i++){
			if(!expected[i].equals(obtained[i])){
				pass = false; 
				break;
			}
		}

		sb.append("Case "+testNum);
		if(pass) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\n expected: "+Arrays.toString(expected)+"\n obtained: "+Arrays.toString(obtained)+"\n");

		System.out.println(sb.toString());
	}
}