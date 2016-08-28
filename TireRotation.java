import java.io.*;

public class TireRotation{

	private String[] positions = new String[]{"0123", "3201", "1032", "2310"};

	public int getCycle(String initial, String current){
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < current.length(); i++){
			sb.append(initial.indexOf(current.charAt(i)));
		}

		String pos = sb.toString();
		for(int i=0; i < positions.length; i++){
			if(pos.equals(positions[i])) return i+1;
		}

		return -1;
	}

	public static void main(String[] args){
		TireRotation tr = new TireRotation();
		tr.test();
	}

	private void test(){
		String initial;
		String current;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					initial = new String("ABCD");
					current = new String("ABCD");
					expected = 1;
					obtained = getCycle(initial, current);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					initial = new String("ABCD");
					current = new String("DCAB");
					expected = 2;
					obtained = getCycle(initial, current);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					initial = new String("ABCD");
					current = new String("CDBA");
					expected = 4;
					obtained = getCycle(initial, current);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					initial = new String("ABCD");
					current = new String("ABDC");
					expected = -1;
					obtained = getCycle(initial, current);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					initial = new String("ZAXN");
					current = new String("XNAZ");
					expected = 4;
					obtained = getCycle(initial, current);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\tSuccess");
		else sb.append("\tFail");
		sb.append("\texpected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}