import java.io.*;
import java.util.*;

public class DerivativeSequence{
	public int[] derSeq(int[] a, int n){
		int count = 0;
		while(count < n){
			ArrayList<Integer> vals = new ArrayList<Integer>();

			for(int i=1; i < a.length; i++){
				vals.add(i-1, a[i]-a[i-1]);
			}

			a = new int[vals.size()];
			for(int i=0; i < vals.size(); i++){
				a[i] = vals.get(i);
			}

			count++;
		}

		return a;
	}

	public static void main(String[] args) {
		DerivativeSequence ds = new DerivativeSequence();
		ds.test();
	}

	private void test(){
		int[] a;
		int n;

		int[] expected = new int[20];
		int[] obtained = new int[20];

		int numcases = 5;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					a = new int[]{5,6,3,9,-1};
					n = 1;
					expected = new int[]{1, -3, 6, -10 };
					obtained = derSeq(a, n);
					break;
				}
				case 1:{
					a = new int[]{5,6,3,9,-1};
					n = 2;
					expected = new int[]{-4, 9, -16 };
					obtained = derSeq(a, n);
					break;
				}
				case 2:{
					a = new int[]{5,6,3,9,-1};
					n = 4;
					expected = new int[]{-38};
					obtained = derSeq(a, n);
					break;
				}
				case 3:{
					a = new int[]{4,4,4,4,4,4,4,4};
					n = 3;
					expected = new int[]{0, 0, 0, 0, 0 };
					obtained = derSeq(a, n);
					break;
				}
				case 4:{
					a = new int[]{-100,100};
					n = 0;
					expected = new int[]{-100,100};
					obtained = derSeq(a, n);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int caseNum, int[] expected, int[] obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+caseNum);
		
		boolean pass = true;
		if(expected.length != obtained.length) pass = false;
		else{
			for(int i=0; i < expected.length; i++){
				if(expected[i] != obtained[i]){
					pass = false;
					break;
				}
			}
		}

		if(pass) sb.append("\t Success");
		else sb.append("\t Fail");

		sb.append("\t expected: "+Arrays.toString(expected)+" \t obtained: "+Arrays.toString(obtained));

		System.out.println(sb.toString());
	}
}