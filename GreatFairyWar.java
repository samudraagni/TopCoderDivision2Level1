import java.io.*;

public class GreatFairyWar{
	public int minHP(int[] dps, int[] hp){
		int val = 0;
		for(int i = 0; i < hp.length; i++){
			int sum = 0;
			for(int j=i; j < dps.length; j++){
				sum += dps[j];
			}
			val += (hp[i] * sum);
		}
		return val;
	}

	public static void main(String[] args){
		GreatFairyWar gfw = new GreatFairyWar();
		gfw.test();
	}

	private void test(){
		int[] dps;
		int[] hp;
		int expected;
		int obtained;

		int numTests = 6;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					dps = new int[]{1,2};
					hp = new int[]{3,4};
					expected = 17;
					obtained = minHP(dps, hp);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					dps = new int[]{1,1,1,1,1,1,1,1,1,1};
					hp = new int[]{1,1,1,1,1,1,1,1,1,1};
					expected = 55;
					obtained = minHP(dps, hp);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					dps = new int[]{20,12,10,10,23,10};
					hp = new int[]{5,7,7,5,7,7};
					expected = 1767;
					obtained = minHP(dps, hp);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					dps = new int[]{5,7,7,5,7,7};
					hp = new int[]{20,12,10,10,23,10};
					expected = 1998;
					obtained = minHP(dps, hp);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					dps = new int[]{30,2,7,4,7,8,21,14,19,12};
					hp = new int[]{2,27,18,19,14,8,25,13,21,30};
					expected = 11029;
					obtained = minHP(dps, hp);
					printResult(i, expected, obtained);
					break;
				}
				case 5:{
					dps = new int[]{1};
					hp = new int[]{1};
					expected = 1;
					obtained = minHP(dps, hp);
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