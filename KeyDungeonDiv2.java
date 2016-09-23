/* https://community.topcoder.com/stat?c=problem_statement&pm=12724 */

public class KeyDungeonDiv2{
	public 	int countDoors(int[] doorR, int[] doorG, int[] keys){

		int retval = 0;

		int red = keys[0];
		int green = keys[1];
		int white = keys[2];

		for(int i=0; i < doorR.length; i++){
			int numRedRem = red - doorR[i];
			int numGreenRem = green - doorG[i];
			int numWhiteRem = white;

			if(numRedRem >= 0 && numGreenRem >= 0) retval++;
			else if(numRedRem < 0 && numGreenRem < 0){
				if(numRedRem < numGreenRem){
					if(numWhiteRem + numRedRem >= 0 && numWhiteRem + numRedRem + numGreenRem >= 0) {
						retval++;
					}
				}
				else if(numRedRem > numGreenRem){
					if(numWhiteRem + numGreenRem >= 0 && numWhiteRem + numGreenRem + numRedRem >= 0) {
						retval++;
					}
				}
				else if(numRedRem == numGreenRem){
					if(numWhiteRem + numGreenRem >= 0 && numWhiteRem + numGreenRem + numRedRem >= 0){
						retval++;
					} 
				}
			}
			else if(numRedRem < 0 && numGreenRem >= 0){
				if(numRedRem + numWhiteRem >= 0) retval++;
			}
			else if(numGreenRem < 0 && numRedRem >= 0){
				if(numGreenRem + numWhiteRem >= 0) retval++;
			}
		}

		return retval;
	}
	

	public static void main(String[] args) {
		KeyDungeonDiv2 kdd = new KeyDungeonDiv2();
		kdd.test();
	}

	private void test(){
		int[][] doorR = new int[][]{
			{2, 0, 5, 3},
			{0, 1, 2, 0},
			{3, 5, 4, 2, 8},
			{4, 5, 4, 6, 8},
			{41,44,41,57,58,74,84,100,58,2,43,32,82,97,44,13,35,98,96,81,43,77,18,51,27,27,39,39,45,82,59,20,28,93,6,39,64,78,28,85,17,56,3,68,4,0,36,80,41,77}
		};

		int[][] doorG = new int[][]{
			{1, 4, 0, 2},
			{0, 2, 3, 1},
			{4, 2, 3, 8, 1},
			{2, 1, 2, 3, 5},
			{67,15,53,36,88,29,26,57,68,99,97,27,51,70,3,49,65,75,35,92,66,0,23,96,38,86,98,31,26,75,30,2,92,78,100,99,38,26,85,74,77,15,16,48,100,88,55,93,99,54}
		};

		int[][] keys = new int[][]{
			{2, 3, 1},
			{0, 0, 0},
			{0, 0, 10},
			{1, 2, 1},
			{39,31,34}
		};

		int[] want = new int[]{3, 1, 5, 0, 17};

		for(int i=0; i < doorR.length; i++){
			int got = countDoors(doorR[i], doorG[i], keys[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}