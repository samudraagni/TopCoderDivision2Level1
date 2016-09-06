import java.io.*;

public class TournamentJudging{
	public int getPoints(int[] rawScores, int[] conversionFactor){

		int retval = 0;

		for(int i=0; i < rawScores.length; i++){
			double val = (1.0 * rawScores[i])/conversionFactor[i];
			double rounding = val - (long) val;

			if(rounding >= 0.5){
				retval += (int)(Math.ceil(val));
			}
			else{
				retval += (int)(Math.floor(val));
			}
		}

		return retval;
	}

	public static void main(String[] args) {
		TournamentJudging tj = new TournamentJudging();
		tj.test();
	}

	private void test(){
		int[] rawScores;
		int[] conversionFactor;

		int expected = 0;
		int obtained = 0;

		int numtests = 5;
		for(int i=0; i < numtests; i++){
			switch(i){
				case 0:{
					rawScores = new int[]{10, 20, 30};
					conversionFactor = new int[]{10, 10, 5};
					expected = 9;
					obtained = getPoints(rawScores, conversionFactor);
					break;
				}
				case 1:{
					rawScores = new int[]{8, 16, 32};
					conversionFactor = new int[]{10, 10, 5};
					expected = 9;
					obtained = getPoints(rawScores, conversionFactor);
					break;
				}
				case 2:{
					rawScores = new int[]{60, 59};
					conversionFactor = new int[]{24, 24};
					expected = 5;
					obtained = getPoints(rawScores, conversionFactor);
					break;
				}
				case 3:{
					rawScores = new int[]{47, 42, 37, 30, 27, 21, 18};
					conversionFactor = new int[]{1, 2, 3, 4, 5, 6, 7};
					expected = 100;
					obtained = getPoints(rawScores, conversionFactor);
					break;
				}
				case 4:{
					rawScores = new int[]{0, 1000000, 5000, 1000000};
					conversionFactor = new int[]{1, 2, 1000000, 4};
					expected = 750000;
					obtained = getPoints(rawScores, conversionFactor);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int caseNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+caseNum);
		if(expected == obtained) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained: "+obtained);

		System.out.println(sb.toString());
	}
}