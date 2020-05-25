package exercises;

/**
 * Prints n-dimensional arrays of double, where n can be up to 7.
 * Adapted from Exercises 3, 4 - Chapter 16, page 543 Think in Java (4th edition) - Bruce Eckel
 * 
 * REQUIRES in same package:
 * MultidimArraysComplementary.java
 * 
 * Example1: create2dArray(new int[] {3,5},5,10): 2 dimensional array: 3 outer elements, each with 5 elements. 
 * In the 1st outer element, the 5 elements increase gradually between 10 and 20; 
 * in the 2nd outer element, the 5 elements increase gradually between 11 and 20; 
 * in the 3rd (and last) outer element, the 5 elements increase gradually between 12 and 20; 
 * [[5.0, 6.25, 7.5, 8.75, 10.0], [6.0, 7.0, 8.0, 9.0, 10.0], [7.0, 7.75, 8.5, 9.25, 10.0]] 
 * 
 * Example2: create3dArray(new int[]{3,4,6},0,100): 3 dimensional array: 3 outer elements, each with 4 inner elements, each with 5 elements. 
 * In the 1st inner element, the 6 elements increase gradually between 0 and 100; 
 * in the 2nd inner element, the 6 elements increase gradually between 1 and 100; 
 * ...
 * in the 4th (and last) inner element, the 6 elements increase gradually between 3 and 100; 
 * [[[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]], [[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]], [[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]]]
 * 
 * @author feBueno, May 2020
 */

import static net.mindview.util.Print.print;
import java.util.*;
import java.util.stream.IntStream;

public class MultidimArrays {
	static double[][] create2dArray(int[] d, double start, double end) {
		
		//Error handling
		if(!(start < end)) {
			System.out.println("Lowest must be less than highest");
			return null;
		}
		if(IntStream.of(d).anyMatch(x -> x < 1)) {
			System.out.println("Size must be > 0");
			return null;
		}
		
		
		double[][] result = new double[d[0]][d[1]];
		result[0] = new double[d[1]];

		for(int i = 0; i < d[0]; i++) {
			result[i] = new double[d[1]];
			for(int j = 0; j < d[1]; j++) {
				result[i][j] = start+i + ((end-(start+i))/(d[1]-1))*j;
			}
		}
		return result;
	} 

	public static void main(String[] args) {
		
		print(Arrays.deepToString(create2dArray(new int[] {0,2},4,5)));
		print(Arrays.deepToString(create2dArray(new int[] {2,3},5,4)));
		print(Arrays.deepToString(create2dArray(new int[] {1,2},5,10)));
		print(Arrays.deepToString(create2dArray(new int[] {2,2},5,10)));
		print(Arrays.deepToString(create2dArray(new int[] {3,3},5,10)));
		print(Arrays.deepToString(create2dArray(new int[] {3,5},5,10)));
		print(Arrays.deepToString(MultidimArraysComplementary.create3dArray(new int[]{3,4,6},0,100)));
	}
} /*Output:
Size must be > 0
null
Lowest must be less than highest
null
[[5.0, 10.0]]
[[5.0, 10.0], [6.0, 10.0]]
[[5.0, 7.5, 10.0], [6.0, 8.0, 10.0], [7.0, 8.5, 10.0]]
[[5.0, 6.25, 7.5, 8.75, 10.0], [6.0, 7.0, 8.0, 9.0, 10.0], [7.0, 7.75, 8.5, 9.25, 10.0]]
[[[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]], [[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]], [[0.0, 20.0, 40.0, 60.0, 80.0, 100.0], [1.0, 20.8, 40.6, 60.400000000000006, 80.2, 100.0], [2.0, 21.6, 41.2, 60.800000000000004, 80.4, 100.0], [3.0, 22.4, 41.8, 61.199999999999996, 80.6, 100.0]]]
*/