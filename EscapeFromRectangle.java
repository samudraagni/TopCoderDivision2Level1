import java.io.*;

public class EscapeFromRectangle{
	public int shortest(int x, int y, int w, int h){
		/* I am at (x,y). Origin is at (0,0) top right at(w,h) */
		int minX = (x < (w-x))?x:(w-x);
		int minY = (y < (h-y))?y:(h-y);

		return Math.min(minX, minY);
	}

	public static void main(String[] args) {
		EscapeFromRectangle efr = new EscapeFromRectangle();
		efr.test();
	}

	private void test(){
		int x, y, w, h;

		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					x = 1;
					y = 1;
					w = 5;
					h = 5;
					expected = 1;
					obtained = shortest(x, y, w, h);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					x = 6;
					y = 2;
					w = 10;
					h = 3;
					expected = 1;
					obtained = shortest(x, y, w, h);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					x = 653;
					y = 375;
					w = 1000;
					h = 1000;
					expected = 347;
					obtained = shortest(x, y, w, h);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					x = 161;
					y = 181;
					w = 762;
					h = 375;
					expected = 161;
					obtained = shortest(x, y, w, h);
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
		sb.append("\t expected: "+ expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}