import java.io.*;

public class BettingMoney{
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult){
		int amountLost = amounts[finalResult] * centsPerDollar[finalResult];
		int totalAmount = 0;

		for(int i=0; i < amounts.length; i++){
			if(i != finalResult) totalAmount += amounts[i];
		}

		/* convert to cents */
		totalAmount = totalAmount * 100;

		return totalAmount - amountLost;
	}

	public static void main(String[] args) {
		BettingMoney bm = new BettingMoney();
		bm.test();
	}

	private void test(){
		int[] amounts;
		int[] centsPerDollar;
		int finalResult;

		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					amounts = new int[]{10,20,30};
					centsPerDollar = new int[]{20,30,40};
					finalResult = 1;
					expected = 3400;
					obtained = moneyMade(amounts, centsPerDollar, finalResult);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					amounts = new int[]{200,300,100};
					centsPerDollar = new int[]{10,10,10};
					finalResult = 2;
					expected = 49000;
					obtained = moneyMade(amounts, centsPerDollar, finalResult);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					amounts = new int[]{100,100,100,100};
					centsPerDollar = new int[]{5,5,5,5};
					finalResult = 0;
					expected = 29500;
					obtained = moneyMade(amounts, centsPerDollar, finalResult);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					amounts = new int[]{5000,5000};
					centsPerDollar = new int[]{100,2};
					finalResult = 0;
					expected = 0;
					obtained = moneyMade(amounts, centsPerDollar, finalResult);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					amounts = new int[]{100};
					centsPerDollar = new int[]{10};
					finalResult = 0;
					expected = -1000;
					obtained = moneyMade(amounts, centsPerDollar, finalResult);
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