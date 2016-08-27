import java.io.*;

public class Sortness{
	
	public double getSortness(int[] a){

		double val = 0.0;
		int len = a.length;

		for(int i=0; i < len; i++){
			int sval = 0;
			for(int j=0; j < len; j++){
				if((j < i && a[j] > a[i]) || (j > i && a[j] < a[i])){
					sval++;
				}
			}
			val += sval;
		}

		return (val/len);
	}

	public static void main(String[] args){
		Sortness s = new Sortness();
		s.test();
	}

	private void test(){
		int[] a;
		double expected;
		double obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					a = new int[]{3,2,1,4,6,7,5,8};
					expected = 1.25;
					obtained = getSortness(a);
					printResults(i, expected, obtained);
					break;
				}
				case 1:{
					a = new int[]{1,2,3};
					expected = 0.0;
					obtained = getSortness(a);
					printResults(i, expected, obtained);
					break;
				}
				case 2:{
					a = new int[]{5,4,3,2,1};
					expected = 4.0;
					obtained = getSortness(a);
					printResults(i, expected, obtained);
					break;
				}
				case 3:{
					a = new int[]{1,5,8,7,9,6,10,12,11,3,4,2};
					expected = 5.166666666666667;
					obtained = getSortness(a);
					printResults(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResults(int testNum, double expected, double obtained){

		double threshold = 0.000000001;
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(Math.abs(expected-obtained) <= threshold) sb.append("\tSuccess");
		else sb.append("\tFail");
		sb.append("\texpected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}