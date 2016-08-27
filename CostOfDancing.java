import java.io.*;
import java.util.*;

public class CostOfDancing{
	
	public int minimum(int K, int[] danceCost){
		int sum = 0;

		if(K < danceCost.length) Arrays.sort(danceCost);

		for(int i=0; i < K; i++){
			sum += danceCost[i];
		}

		return sum;
	}

	public static void main(String[] args){

		CostOfDancing cd = new CostOfDancing();
		cd.test();
	}

	private void test(){

		int K;
		int[] danceCost;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {

				case 0: {
					K = 2;
					danceCost = new int[]{1, 5, 3, 4};
					expected = 4;
					obtained = minimum(K, danceCost);
					printResult(i, expected, obtained);
					break;
				}

				case 1: {
					K = 3;
					danceCost = new int[]{1, 5, 4};
					expected = 10;
					obtained = minimum(K, danceCost);
					printResult(i, expected, obtained);
					break;
				}
				
				case 2: {
					K = 1;
					danceCost = new int[]{2, 2, 4, 5, 3};
					expected = 2;
					obtained = minimum(K, danceCost);
					printResult(i, expected, obtained);
					break;
				}

				case 3: {
					K = 39;
					danceCost = new int[]{973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913, 93, 129, 758, 108, 433, 181, 163, 96, 932,703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908, 321, 709, 752, 346, 656, 413, 629, 801};
					expected = 20431;
					obtained = minimum(K, danceCost);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){

		System.out.print("\nTest no. "+testNum+"\t");
		
		if(obtained == expected)System.out.print("Success.\t");
		else System.out.print("Fail.\t");

		System.out.println("expected: "+expected+"\tobtained:"+obtained);
	}




}