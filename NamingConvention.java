import java.io.*;

public class NamingConvention{
	String toCamelCase(String variableName){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < variableName.length(); i++){
			if(variableName.charAt(i) == '_'){
				int charval = (variableName.charAt(i+1)-'a')+'A';
				sb.append(Character.toString((char) charval));
				i++;
			}
			else{
				sb.append(variableName.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		NamingConvention nc = new NamingConvention();
		nc.test();
	}

	private void test(){
		String variableName;
		String expected;
		String obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					variableName = new String("sum_of_two_numbers");
					expected = new String("sumOfTwoNumbers");
					obtained = toCamelCase(variableName);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					variableName = new String("variable");
					expected = new String("variable");
					obtained = toCamelCase(variableName);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					variableName = new String("t_o_p_c_o_d_e_r");
					expected = new String("tOPCODER");
					obtained = toCamelCase(variableName);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					variableName = new String("the_variable_name_can_be_very_long_like_this");
					expected = new String("theVariableNameCanBeVeryLongLikeThis");
					obtained = toCamelCase(variableName);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}