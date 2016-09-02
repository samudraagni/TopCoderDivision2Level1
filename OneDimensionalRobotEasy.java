import java.io.*;

public class OneDimensionalRobotEasy{
	public int finalPosition(String commands, int A, int B){
		int pos = 0;
		for(int i=0; i < commands.length(); i++){
			char com = commands.charAt(i);
			if(com == 'R' && pos+1 <= B) pos++;
			else if(com == 'L' && pos-1 >= -A) pos--;
		}
		return pos;
	}

	public static void main(String[] args) {
		OneDimensionalRobotEasy odr = new OneDimensionalRobotEasy();
		odr.test();
	}

	private void test(){
		String commands;
		int A, B;

		int expected = 0;
		int obtained = 0;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					commands = new String("RRLRRLLR");
					A = 10;
					B = 10;
					expected = 2;
					obtained = finalPosition(commands, A, B);
					break;
				}
				case 1:{
					commands = new String("RRRRR");
					A = 3;
					B = 4;
					expected = 4;
					obtained = finalPosition(commands, A, B);
					break;
				}
				case 2:{
					commands = new String("LLLLLLLLLLR");
					A = 2;
					B = 6;
					expected = -1;
					obtained = finalPosition(commands, A, B);
					break;
				}
				case 3:{
					commands = new String("RRRRRRRLRRLRRRRRRRRRRRRLRLRRRRRRRRLRRRRRLRRRRRRRRR");
					A = 5;
					B = 20;
					expected = 20;
					obtained = finalPosition(commands, A, B);
					break;
				}
				case 4:{
					commands = new String("RLRLLLLLLLRLLLRLLLLLLLLRLLLLLRLLLRRLLLLLRLLLLLRLLL");
					A = 34;
					B = 15;
					expected = -30;
					obtained = finalPosition(commands, A, B);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained:"+obtained);

		System.out.println(sb.toString());
	}
}