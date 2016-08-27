import java.io.*;

public class Soccer{
	
	public int maxPoints(int[] wins, int[] ties){

		int max = 0;

		for(int i=0; i < wins.length; i++){
			int val = 3*wins[i] + ties[i];
			if(val > max){
				max = val;
			}
		}

		return max;
	}


	public static void main(String[] args){

		Soccer sc = new Soccer();

		sc.test();
	}

	private void test(){

		int numtests = 5;
		int[] wins;
		int[] ties;
		int expected;
		int obtained;

		for(int i=0; i < numtests; i++){

			switch (i) {
				case 0: {
					wins = new int[]{1,4,3,0,0};
					ties = new int[]{3,1,5,3,1};
					expected = 14;
					obtained = maxPoints(wins, ties);
					printResult(i, expected, obtained);
					break;
				}

				case 1:{
					wins = new int[]{12,45,20,17,48,0};
					ties = new int[]{48,10,53,94,0,100};
					expected = 145;
					obtained = maxPoints(wins, ties);
					printResult(i, expected, obtained);
					break;
				}

				case 2:{
					wins = new int[]{35,0};
					ties = new int[]{0,76};
					expected = 105;
					obtained = maxPoints(wins, ties);
					printResult(i, expected, obtained);
					break;
				}

				case 3:{
					wins = new int[]{0,0,0,0};
					ties = new int[]{0,0,0,0};
					expected = 0;
					obtained = maxPoints(wins, ties);
					printResult(i, expected, obtained);
					break;
				}

				case 4:{
					wins = new int[]{13,79,26,73,14,89,71,37,89,71,19,59,39};
					ties = new int[]{88,27,5,70,84,94,20,50,2,11,31,22,50};
					expected = 361;
					obtained = maxPoints(wins, ties);
					printResult(i, expected, obtained);
					break;
				}				
			}
		}


	}

	private void printResult(int testNum, int expected, int obtained){

		System.out.println("Test no. "+testNum);
		
		if(obtained == expected) System.out.println("Success.");
		else System.out.println("Fail.");

		System.out.println("expected: "+expected+" obtained: "+obtained+"\n");
	}
}