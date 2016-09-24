/* https://community.topcoder.com/stat?c=problem_statement&pm=13089 
	Successful for 249.99/250 points
*/

public class AmebaDiv2{
	public int simulate(int[] X, int A){
		for(int x : X){
			if(A == x){
				A = A * 2;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		AmebaDiv2 ad = new AmebaDiv2();
		ad.test();
	}

	private void test(){
		int[][] X = new int[][]{
			{2,1,3,1,2},
			{1,4,9,16,25,36,49},
			{1,2,4,8,16,32,64,128,256,1024,2048},
			{817,832,817,832,126,817,63,63,126,817,832,287,823,817,574}
		};

		int[] A = new int[]{1, 10, 1, 63};

		int[] want = new int[]{4, 10, 512, 252};

		for(int i=0; i < X.length; i++){
			int got = simulate(X[i], A[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}