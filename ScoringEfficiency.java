/* https://community.topcoder.com/stat?c=problem_statement&pm=2341 */

import java.io.*;

public class ScoringEfficiency{
	public double getPointsPerShot(String[] gameLog){
		int totalPoints = 0;
		int fieldGoalsAttempted = 0;
		int freeThrowsAttempted = 0;

		for(String s : gameLog){
			if(s.startsWith("Made 2")){
				totalPoints += 2;
				fieldGoalsAttempted++;
			}
			else if(s.startsWith("Made 3")){
				totalPoints += 3;
				fieldGoalsAttempted++;
			}
			else if(s.startsWith("Made free")){
				totalPoints += 1;
				freeThrowsAttempted++;
			}
			else if(s.startsWith("Missed free")){
				freeThrowsAttempted++;
			}
			else{
				fieldGoalsAttempted++;
			}
		}

		return (totalPoints/(fieldGoalsAttempted + 0.5 * freeThrowsAttempted));
	}

	public static void main(String[] args) {
		ScoringEfficiency se = new ScoringEfficiency();
		se.test();
	}

	private void test(){
		String[][] gameLog = new String[][]{
			{"Made 3 point field goal", 
 			"Missed 2 point field goal"},
 			{"Made free throw",
			 "Missed free throw",
			 "Missed free throw",
			 "Missed free throw",
			 "Made free throw"},
			{"Made 2 point field goal", "Made 2 point field goal", "Made 2 point field goal", 
			 "Made 2 point field goal", "Missed 2 point field goal",
			 "Made 3 point field goal", "Made 3 point field goal", "Made 3 point field goal",
			 "Missed 3 point field goal", "Missed 3 point field goal", 
			 "Missed 3 point field goal", "Missed 3 point field goal",
			 "Made free throw", "Made free throw", "Made free throw", 
			 "Made free throw", "Made free throw", "Made free throw", 
			 "Made free throw", "Missed free throw", "Missed free throw"},
			{"Made 2 point field goal", "Missed free throw",
			 "Made free throw", "Missed free throw", "Made free throw", 
			 "Made 2 point field goal", "Made 2 point field goal",
			 "Missed 2 point field goal", "Missed 2 point field goal",
			 "Made 3 point field goal", "Missed 2 point field goal",
			 "Made 2 point field goal", "Missed 2 point field goal",
			 "Made 3 point field goal", "Missed 2 point field goal",
			 "Missed 2 point field goal", "Missed 3 point field goal",
			 "Made free throw", "Made free throw", 
			 "Missed 3 point field goal", "Missed 2 point field goal",
			 "Missed 2 point field goal", "Made 2 point field goal",
			 "Missed 2 point field goal", "Made 2 point field goal",
			 "Missed 3 point field goal"}  
		};

		double[] want = new double[]{1.5, 0.8, 1.4545454545454546, 0.9565217391304348};

		for(int i=0; i < gameLog.length; i++){
			double got = getPointsPerShot(gameLog[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got - want[i]) < 1e-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}