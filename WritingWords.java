import java.io.*;

public class WritingWords{
	
	public int write(String word){

		int val = 0;
		for(int i=0; i < word.length(); i++){
			val += (word.charAt(i)-'A') + 1;
		}

		return val;
	}

	public static void main(String[] args){
		WritingWords w = new WritingWords();
		w.test();
	}

	private void test(){

		String word;
		int expected;
		int obtained;

		int numTests = 6;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					word = new String("A");
					expected = 1;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					word = new String("ABC");
					expected = 6;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					word = new String("VAMOSGIMNASIA");
					expected = 143;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					word = new String("TOPCODER");
					expected = 96;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					word = new String("SINGLEROUNDMATCH");
					expected = 183;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
				case 5:{
					word = new String("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
					expected = 1300;
					obtained = write(word);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){

		StringBuilder sb = new StringBuilder();

		sb.append("Test "+testNum);
		if(expected == obtained) sb.append("\tSuccess.");
		else sb.append("\tFail.");
		sb.append("\texpected: "+expected+" obtained: "+obtained+"\n");

		System.out.println(sb.toString());
	}
}