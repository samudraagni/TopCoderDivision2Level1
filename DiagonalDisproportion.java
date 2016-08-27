import java.io.*;

public class DiagonalDisproportion{
	
	public int getDisproportion(String[] matrix){

		int len = matrix.length;
		int mdSum = 0;
		int cdSum = 0;

		for(int i=0; i < len; i++){

			String v = matrix[i];
			for(int j=0; j < len; j++){
				if(i == j){
					mdSum += v.charAt(j)-'0';
				}

				if(j == len-i-1){
					cdSum += v.charAt(j)-'0';
				}
			}
		}

		return (mdSum - cdSum);
	}

	public static void main(String[] args){

		DiagonalDisproportion dd = new DiagonalDisproportion();
		dd.test();
	}

	private void test(){

		String[] matrix;
		int expected;
		int obtained;

		int numTests = 4;

		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					matrix = new String[]{"190","828","373"};
					expected = 1;
					obtained = getDisproportion(matrix);
					printResult(i, expected, obtained);
					break;
				}

				case 1:{
					matrix = new String[]{"9000","0120","0000","9000"};
					expected = -1;
					obtained = getDisproportion(matrix);
					printResult(i, expected, obtained);
					break;
				}

				case 2:{
					matrix = new String[]{"6"};
					expected = 0;
					obtained = getDisproportion(matrix);
					printResult(i, expected, obtained);
					break;
				}

				case 3:{
					matrix = new String[]{"7748297018","8395414567","7006199788","5446757413","2972498628","0508396790","9986085827","2386063041","5687189519","7729785238"};
					expected = -24;
					obtained = getDisproportion(matrix);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}


	private void printResult(int testNum, int expected, int obtained){

		StringBuilder op = new StringBuilder();
		op.append("\nTest no. "+testNum);
		
		if(obtained == expected) op.append("\tSuccess.");
		else op.append("\tFail.");
		
		op.append("\texpected "+expected+"\tobtained "+obtained+"\n");
		
		System.out.print(op.toString());
	}




















}