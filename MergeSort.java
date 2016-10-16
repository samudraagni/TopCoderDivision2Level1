import java.io.*;
import java.util.*;

public class MergeSort{
	
	public int[] sort(int[] array){
		if(array == null) return null;
		if(array.length < 2) return array;

		int[] array1 = new int[array.length/2];
		System.arraycopy(array, 0, array1, 0, array1.length);

		int[] array2;
		if(array.length % 2 == 0){
			array2 = new int[array.length/2];
		} else {
			array2 = new int[array.length/2 + 1];
		}
		System.arraycopy(array, array1.length, array2, 0, array2.length);

		array1 = sort(array1);
		array2 = sort(array2);

		int a = 0;
		int a1 = 0;
		int a2 = 0;

		while(a1 < array1.length && a2 < array2.length){
			if(array1[a1] < array2[a2]){
				array[a++] = array1[a1++];
			} else {
				array[a++] = array2[a2++];
			}
		}

		while(a1 < array1.length){
			array[a++] = array1[a1++];
		}

		while(a2 < array2.length){
			array[a++] = array2[a2++];
		}

		return array;
	}	

	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		ms.test();
	}

	private void test(){
		int[][] array = new int[][]{
			{4, 2, 8, 1, 5, 6, 0},
			{-19, 0, -29, -89, 9, -23},
			{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
		};

		int[][] want = new int[][]{
			{0, 1, 2, 4, 5, 6, 8},
			{-89, -29, -23, -19, 0, 9},
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		};

		for(int i=0; i < array.length; i++){
			int[] got = sort(array[i]);

			boolean pass = true;
			for(int j=0; j < got.length; j++){
				if(got[j] != want[i][j]){
					pass = false;
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(pass) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\ngot:\t"+Arrays.toString(got)+"\nwant:\t"+Arrays.toString(want[i])+"\n");

			System.out.println(sb.toString());
		}
	}
}