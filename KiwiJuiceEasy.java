import java.io.*;
import java.util.Arrays;

public class KiwiJuiceEasy{
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){

		for(int i=0; i < fromId.length; i++){
			int from = fromId[i];
			int to = toId[i];

			int toBottlesCapacity = capacities[to];
			int tosCurrentAmount = bottles[to];

			int fromsCurrentAmount = bottles[from];

			if(fromsCurrentAmount > 0){
				int amountNeededToFillToBottle = toBottlesCapacity - tosCurrentAmount;
				if(fromsCurrentAmount > amountNeededToFillToBottle){
					int pourAmount = amountNeededToFillToBottle;
					bottles[to] += pourAmount;

					int remainingAmountInFrom = fromsCurrentAmount - pourAmount;
					bottles[from] = remainingAmountInFrom;

				}
				else if(fromsCurrentAmount <= amountNeededToFillToBottle){
					int pourAmount = fromsCurrentAmount;//pour everything
					bottles[to] += pourAmount;
					bottles[from] = 0;
				}
			}
		}

		return bottles;
	} 

	public static void main(String[] args) {
		KiwiJuiceEasy kje = new KiwiJuiceEasy();
		kje.test();
	}

	private void test(){
		int[] capacities;
		int[] bottles;
		int[] fromId;
		int[] toId;

		int[] expected;
		int[] obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					capacities = new int[]{20, 20};
					bottles = new int[]{5, 8};
					fromId = new int[]{0};
					toId = new int[]{1};
					expected = new int[]{0, 13 };
					obtained = thePouring(capacities, bottles, fromId, toId);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					capacities = new int[]{10, 10};
					bottles = new int[]{5, 8};
					fromId = new int[]{0};
					toId = new int[]{1};
					expected = new int[]{3, 10 };
					obtained = thePouring(capacities, bottles, fromId, toId);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					capacities = new int[]{30, 20, 10};
					bottles = new int[]{10, 5, 5};
					fromId = new int[]{0, 1, 2};
					toId = new int[]{1, 2, 0};
					expected = new int[]{10, 10, 0 };
					obtained = thePouring(capacities, bottles, fromId, toId);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					capacities = new int[]{14, 35, 86, 58, 25, 62};
					bottles = new int[]{6, 34, 27, 38, 9, 60};
					fromId = new int[]{1, 2, 4, 5, 3, 3, 1, 0};
					toId = new int[]{0, 1, 2, 4, 2, 5, 3, 1};
					expected = new int[]{0, 14, 65, 35, 25, 35 };
					obtained = thePouring(capacities, bottles, fromId, toId);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					capacities = new int[]{700000, 800000, 900000, 1000000};
					bottles = new int[]{478478, 478478, 478478, 478478};
					fromId = new int[]{2, 3, 2, 0, 1};
					toId = new int[]{0, 1, 1, 3, 2};
					expected = new int[]{0, 156956, 900000, 856956 };
					obtained = thePouring(capacities, bottles, fromId, toId);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int[] expected, int[] obtained){
		StringBuilder sb = new StringBuilder();

		boolean pass = true;
		for(int i=0; i < expected.length; i++){
			if(expected[i] != obtained[i]){
				pass = false;
				break;
			}
		}

		sb.append("\nCase "+testNum);
		if(pass) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\nexpected: "+Arrays.toString(expected)+"\nobtained: "+Arrays.toString(obtained)+"\n");

		System.out.println(sb.toString());
	}
}