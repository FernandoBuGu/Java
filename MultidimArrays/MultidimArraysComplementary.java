package exercises;

/**
 * Complementary methods for MultidimArrays.java. 
 * Each method returns an arrays of a number of dimensions in [3-7] 
 * following the structure described in MultidimArrays.java
 * 
 * 
 * @author feBueno, May 2020
 */

public class MultidimArraysComplementary extends MultidimArrays{
	static double[][][] create3dArray(int[] d, double start, double end) {
			
		int[] dims= {d[1],d[2]};

		double[][][] result = new double[d[0]][d[1]][d[2]];
		for(int i = 0; i < d[0]; i++) 
			result[i] = MultidimArrays.create2dArray(dims, start, end);
		return result;
	} 
	
	static double[][][][] create4dArray(int[] d, double start, double end) {
		
		int[] dims= {d[1],d[2],d[3]};
		
		double[][][][] result = new double[d[0]][d[1]][d[2]][d[3]];
		for(int i = 0; i < d[0]; i++) 
			result[i] = create3dArray(dims, start, end);
		return result;
	}
	
	static double[][][][][] create5dArray(int[] d, double start, double end) {
		
		int[] dims= {d[1],d[2],d[3],d[4]};
		
		double[][][][][] result = new double[d[0]][d[1]][d[2]][d[3]][d[4]];
		for(int i = 0; i < d[0]; i++) 
			result[i] = create4dArray(dims, start, end);
		return result;
	} 
	
	static double[][][][][][] create6dArray(int[] d, double start, double end) {
		
		int[] dims= {d[1],d[2],d[3],d[4],d[5]};
		
		double[][][][][][] result = new double[d[0]][d[1]][d[2]][d[3]][d[4]][d[5]];
		for(int i = 0; i < d[0]; i++) 
			result[i] = create5dArray(dims, start, end);
		return result;
	}
	static double[][][][][][][] create7dArray(int[] d, double start, double end) {
		
		int[] dims= {d[1],d[2],d[3],d[4],d[5],d[6]};
		
		double[][][][][][][] result = new double[d[0]][d[1]][d[2]][d[3]][d[4]][d[5]][d[6]];
		for(int i = 0; i < d[0]; i++) 
			result[i] = create6dArray(dims, start, end);
		return result;
	}
}