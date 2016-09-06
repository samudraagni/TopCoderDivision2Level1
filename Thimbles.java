import java.io.*;

public class Thimbles{

	public int thimbleWithBall(String[] swaps){
		boolean[] positions = new boolean[3];
		positions[0] = true;/* the starting position of the ball */
		positions[1] = false;
		positions[2] = false;

		for(String s : swaps){
			/* "X-Y" (quotes for clarity), which means that the thimble in position X was swapped with the thimble in position Y */
			int swapX = s.charAt(0)-'0'-1;
			int swapY = s.charAt(2)-'0'-1;

			boolean temp = positions[swapY];
			positions[swapY] = positions[swapX];
			positions[swapX] = temp;
		}

		int retval = -1;
		if(positions[0] == true) retval = 1;
		else if(positions[1] == true) retval = 2;
		else if(positions[2] == true) retval = 3;

		return retval;
	}

	public static void main(String[] args) {
		Thimbles tm = new Thimbles();
		tm.test();
	}

	private void test(){
		String[] swaps;

		int expected = -1;
		int obtained = -1;

		int numtests = 4;
		for(int i=0; i < numtests; i++){
			switch (i) {
				case 0:{
					swaps = new String[]{"1-2", "3-1"};
					expected = 2;
					obtained = thimbleWithBall(swaps);
					break;
				}
				case 1:{
					swaps = new String[]{"3-1", "2-3", "3-1", "3-2"};
					expected = 3;
					obtained = thimbleWithBall(swaps);
					break;
				}
				case 2:{
					swaps = new String[]{"2-3", "1-3", "2-3", "2-1", "3-1"};
					expected = 3;
					obtained = thimbleWithBall(swaps);
					break;
				}
				case 3:{
					swaps = new String[]{"1-2", "3-2", "1-2", "2-1", "2-1", "3-2", "1-3", "3-1", "1-2"};
					expected = 1;
					obtained = thimbleWithBall(swaps);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int caseNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+caseNum);
		if(expected == obtained) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained: "+obtained);

		System.out.println(sb.toString());
	}
}