import java.io.*;
import java.util.Arrays;

public class LittleElephantAndBooks{
	public int getNumber(int[] pages, int number){
		Arrays.sort(pages);
		int sum = 0;
		
		for(int i=0; i < number-1; i++){
			sum += pages[i];
		}
		sum += pages[number];

		return sum;
	}

	public static void main(String[] args) {
		LittleElephantAndBooks leb = new LittleElephantAndBooks();
		leb.test();
	}

	private void test(){
		int[] pages;
		int number;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0: {
					pages = new int[]{1, 2};
					number = 1;
					expected = 2;
					obtained = getNumber(pages, number);
					printResult(i, expected, obtained);
					break;
				}
				case 1: {
					pages = new int[]{74, 7, 4, 47, 44};
					number = 3;
					expected = 58;
					obtained = getNumber(pages, number);
					printResult(i, expected, obtained);
					break;
				}
				case 2: {
					pages = new int[]{3, 1, 9, 7, 2, 8, 6, 4, 5};
					number = 7;
					expected = 29;
					obtained = getNumber(pages, number);
					printResult(i, expected, obtained);
					break;
				}
				case 3: {
					pages = new int[]{74, 86, 32, 13, 100, 67, 77};
					number = 2;
					expected = 80;
					obtained = getNumber(pages, number);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}