import java.io.*;
import java.util.Arrays;

public class AverageCandyLifetime{
	public double getAverage(int[] eatenCandies){
		int[] numDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int[] cumuDays = new int[numDays.length];
		Arrays.fill(cumuDays, 0);

		cumuDays[0] = numDays[0];
		for(int i=1; i < cumuDays.length; i++){
			cumuDays[i] += cumuDays[i-1] + numDays[i];
		}

		int numCandies = 0;
		int sum = 0;
		for(int i=0; i < eatenCandies.length; i++){
			sum += (cumuDays[i] * eatenCandies[i]);
			numCandies += eatenCandies[i];
		}

		return ((sum * 1.0)/numCandies);
	}

	public static void main(String[] args) {
		AverageCandyLifetime acf = new AverageCandyLifetime();
		acf.test();
	}

	private void test(){
		int[] eatenCandies;
		double expected;
		double obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					eatenCandies = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
					expected = 60.5;
					obtained = getAverage(eatenCandies);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					eatenCandies = new int[]{0, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
					expected = 59.0;
					obtained = getAverage(eatenCandies);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					eatenCandies = new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 50, 0, 0};
					expected = 301.5882352941176;
					obtained = getAverage(eatenCandies);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					eatenCandies = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
					expected = 252.80769230769232;
					obtained = getAverage(eatenCandies);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, double expected, double obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(Math.abs(expected - obtained) <= 1e-9) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}