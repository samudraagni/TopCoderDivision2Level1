/* https://community.topcoder.com/stat?c=problem_statement&pm=11499 

	249.99/250
*/

public class TrainingCamp{
	public String[] determineSolvers(String[] attendance, String[] problemTopics){
		String[] retval = new String[attendance.length];

		for(int i=0; i < attendance.length; i++){
			retval[i] = new String();
		}

		for(int i=0; i < problemTopics.length; i++){
			String daysCovered = problemTopics[i];

			int k = 0;
			while(k < attendance.length){
				String daysAttended = attendance[k];
				int numDaysCovered = 0;
				int numDaysAttended = 0;

				for(int j = 0; j < daysCovered.length(); j++){
					if(daysCovered.charAt(j) == 'X'){
						numDaysCovered++;
					}

					if(daysCovered.charAt(j) == 'X' && daysAttended.charAt(j) == 'X'){
						numDaysAttended++;
					}
				}

				if(numDaysAttended == numDaysCovered){
					retval[k] += "X";
				}
				else{
					retval[k] += "-";
				}

				k++;
			}
		}
		
		return retval;
	}
}

	public static void main(String[] args) {
		TrainingCamp tc = new TrainingCamp();
		tc.test();
	}

	private void test(){
		String[][] attendance = new String[][]{
			{"XXX",
			 "XXX",
			 "XX-"},
			{"-XXXX",
			 "----X",
			 "XXX--",
			 "X-X-X"},
			{"-----",
 			 "XXXXX"},
 			{"-",
			 "X",
			 "X",
			 "-",
			 "X"},
			{"X----X--X",
			 "X--X-X---",
			 "--X-X----",
			 "XXXX-X-X-",
			 "XXXX--XXX"}
		};

		String[][] problemTopics = new String[][]{
			{"---",
			 "XXX",
			 "-XX",
			 "XX-"},
			{"X---X",
			 "-X---",
			 "XXX--",
			 "--X--"
			},
			{"XXXXX",
			 "-----",
			 "--X-X"},
			{"-",
 			 "X"},
 			{"X----X-X-",
			 "-----X---",
			 "-X----X-X",
			 "-X-X-X---",
			 "-----X---",
			 "X-------X"} 
		};

		String[][] want = new String[][]{
			{"XXXX", "XXXX", "X--X" },
			{"-X-X", "----", "-XXX", "X--X" },
			{"-X-", "XXX" },
			{"X-", "XX", "XX", "X-", "XX" },
			{"-X--XX", "-X--X-", "------", "XX-XX-", "--X--X" }
		};

		for(int i=0; i < attendance.length; i++){
			String[] got = determineSolvers(attendance[i], problemTopics[i]);

			boolean pass = true;
			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.length != want[i].length) pass = false;
			else{
				for(int j=0; j < got.length; j++){
					if(!got[j].equals(want[i][j])){
						pass = false;
						break;
					}
				}
			}
			if(pass) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\n got: "+Arrays.toString(got)+"\n want: "+Arrays.toString(want[i]));

			System.out.println(sb.toString());
		}
	}
}