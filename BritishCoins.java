import java.io.*;
import java.util.Arrays;

public class BritishCoins{
	public int[] coins(int pence){
		int[] retval = new int[3];

		retval[0] = 0;//pounds
		retval[1] = 0;//shillings
		retval[2] = 0;//pennies

		int pennyToOneShilling = 12;
		int pennyToOnePound = 240;

		while(pence >= pennyToOnePound){
			pence = pence - pennyToOnePound;
			retval[0]++;
		}

		while(pence >= pennyToOneShilling){
			pence = pence - pennyToOneShilling;
			retval[1]++;
		}

		retval[2] = pence;

		return retval;
	}

	public static void main(String[] args) {
		BritishCoins bc = new BritishCoins();
		bc.test();
	}

	private void test(){
		int pence;

		int[] want = new int[3];
		int[] got = new int[3];
		int numcases = 5;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					pence = 533;
					want = new int[]{ 2,  4,  5 };
					got = coins(pence);
					break;
				}
				case 1:{
					pence = 0;
					want = new int[]{ 0,  0,  0 };
					got = coins(pence);
					break;
				}
				case 2:{
					pence = 6;
					want = new int[]{ 0,  0,  6 };
					got = coins(pence);
					break;
				}
				case 3:{
					pence = 4091;
					want = new int[]{ 17,  0,  11 };
					got = coins(pence);
					break;
				}
				case 4:{
					pence = 10000;
					want = new int[]{ 41,  13,  4 };
					got = coins(pence);
					break;
				}
			}
			printResult(i, want, got);
		}
	}

	private void printResult(int i, int[] want, int[] got){
		boolean pass = false;
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+i);
		if(want[0] == got[0] && want[1] == got[1] && want[2] == got[2]) pass = true;
		if(pass) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\n want: "+Arrays.toString(want)+"\n got: "+Arrays.toString(got));

		System.out.println(sb.toString());
	}
}
