/* Problem stment: https://community.topcoder.com/stat?c=problem_statement&pm=7894 */

import java.io.*;
import java.util.*;

public class ValueAddedTax{
	public double calculateFinalPrice(String product, int price, String[] food){
		HashSet<String> set = new HashSet<String>();
		for(String s:food){
			set.add(s);
		}

		double tax = set.contains(product)? 0.1 : 0.18;
		
		return price + (price * tax);
	}

	public static void main(String[] args) {
		ValueAddedTax vat = new ValueAddedTax();
		vat.test();
	}

	private void test(){
		String[] products = new String[]{"milk", "car", "abc"};
		int[] prices = new int[]{1, 100, 57};
		String[][] foods = new String[][]{
			{"bread", "butter", "milk"},
			{"bread", "butter", "milk"},
			{"a", "b", "c"}
		};

		double [] want = new double[]{1.1, 118.0, 67.25999999999999};

		for(int i=0; i < products.length; i++){
			double got = calculateFinalPrice(products[i], prices[i], foods[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got-want[i]) < 1e-9) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want "+want[i]+"\t got: "+got);

			System.out.println(sb.toString()+"\n");
		}
	}
}