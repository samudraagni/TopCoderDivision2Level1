import java.io.*;
import java.util.Arrays;

public class MedianOfNumbers{
	
	public int findMedian(int[] numbers){
		int[] higher = new int[numbers.length];
		int[] lower = new int[numbers.length];

		Arrays.fill(higher, 0);
		Arrays.fill(lower, 0);

		for(int i=0; i < numbers.length; i++){
			for(int j=0; j < numbers.length; j++){
				if(i != j){
					if(numbers[j] > numbers[i]) higher[i]++;
					if(numbers[j] < numbers[i]) lower[i]++;
				}
			}
		}

		/* find index where higher[idx] == lower[idx] */
		for(int i=0; i < higher.length; i++){
			if(higher[i] == lower[i]){
				return numbers[i];
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		MedianOfNumbers mn = new MedianOfNumbers();
		mn.test();	
	}

	private void test(){
		int[] numbers;
		int expected;
		int obtained;

		int numTests = 6;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					numbers = new int[]{1, 4, 2, 5, 7};
					expected = 4;
					obtained = findMedian(numbers);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					numbers = new int[]{1, 5, 8, 3};
					expected = -1;
					obtained = findMedian(numbers);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					numbers = new int[]{7};
					expected = 7;
					obtained = findMedian(numbers);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					numbers = new int[]{7, 12};
					expected = -1;
					obtained = findMedian(numbers);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					numbers = new int[]{66, 53, 47, 86, 18, 21, 97, 92, 15};
					expected = 53;
					obtained = findMedian(numbers);
					printResult(i, expected, obtained);
					break;
				}
				case 5:{
					numbers = new int[]{32, 54, 27, 4, 69, 96, 73, 1, 100, 15, 21};
					expected = 32;
					obtained = findMedian(numbers);
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