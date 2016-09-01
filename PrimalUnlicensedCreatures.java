import java.io.*;
import java.util.Arrays;

public class PrimalUnlicensedCreatures{
	public int maxWins(int initialLevel, int[] grezPower){
		int numKills = 0;
		Arrays.sort(grezPower);

		for(int i=0; i < grezPower.length; i++){
			if(grezPower[i] < initialLevel){
				initialLevel += (grezPower[i]/2);
				numKills++;
			}
		}

		return numKills;
	}

	public static void main(String[] args) {
		PrimalUnlicensedCreatures puc = new PrimalUnlicensedCreatures();
		puc.test();
	}

	private void test(){
		int initialLevel;
		int[] grezPower;

		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					initialLevel = 31;
					grezPower = new int[]{10, 20, 30};
					expected = 3;
					obtained = maxWins(initialLevel, grezPower);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					initialLevel = 20;
					grezPower = new int[]{24, 5, 6, 38};
					expected = 3;
					obtained = maxWins(initialLevel, grezPower);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					initialLevel = 20;
					grezPower = new int[]{3, 3, 3, 3, 3, 1, 25 };
					expected = 6;
					obtained = maxWins(initialLevel, grezPower);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					initialLevel = 4;
					grezPower = new int[]{3, 13, 6, 4, 9};
					expected = 5;
					obtained = maxWins(initialLevel, grezPower);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					initialLevel = 7;
					grezPower = new int[]{7, 8, 9, 10};
					expected = 0;
					obtained = maxWins(initialLevel, grezPower);
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