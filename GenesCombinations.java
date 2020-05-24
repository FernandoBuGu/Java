package exercises;

/**
 * Generate random combinations of String[] from a larger String[]
 * 
 * Applications:
 * In this case, each String is a Breast-Cancer-gene-name
 * from a set of 13 very relevant breast cancer genes. 
 * Combinations could represent interactions.
 * A number of gene combinations are printed.
 * 
 * @author feBueno, May 2020
 */

import java.util.*;
import static net.mindview.util.Print.*;

public class GenesCombinations {

	static Random rand = new Random();//set seed for reproducible
	
	public static final String[] GENES_ArrStr = {//Array of Strings from which combinations (smaller Array of String) are sampled
		"BRCA1", "BRCA2", "TP53", "PTEN", 
		"ATM", "CHEK2", "PALB2", "CDH1", "NBN", "STK11",
		"NF1", "BRIP1", "BARD1", "MLH1",
	};
	
	
	public static String[] getCombination(int maxCombinationSize_int, boolean enableLesser_boo) {
		/* 
		 * 
		 * Expected within Class: 
		 * 		Random(): rand, in this case
		 * 		String[]: GENES_ArrStr, in this case
		 * 
		 * In:
		 * 		maxCombinationSize_int: maximum number of genes allowed in each Combination
		 * 		enableLesser_boo: whether lesser combination should be allowed
		 * 			(i.e. if maxCombinationSize_int=5, combinations with 2, 3 and 4 genes are also allowed)
		 * 
		 * Out: 
		 * 		combination_ArrStr: combination sampled from GENES_ArrStr with <= maxCombinationSize_int elements
		 * 			sample without replacement
		 */
				
		if(maxCombinationSize_int>GENES_ArrStr.length)//maxCombinationSize_int can't be larger than the array from which we sample 
			throw new IllegalArgumentException("maximum argument allowed: "+ GENES_ArrStr.length);
		
		
		//set combination size
		int combinationSize_int;//number of genes to be included in the combination
		do
			combinationSize_int= rand.nextInt(maxCombinationSize_int+1);//+1 since arrays start at index 0
		while(combinationSize_int<2);//minimum combination size should be 2
		if(!enableLesser_boo) {combinationSize_int=maxCombinationSize_int;}
		
		
		String[] combination_ArrStr = new String[combinationSize_int];
		
		boolean[] selected_ArrBoo = new boolean[GENES_ArrStr.length];
		//each element in GENES_ArrStr has a boo that is false unless it was already included in combination_ArrStr
		
		//Iteratively, fill one String in combination_ArrStr
		for(int i=0;i<combinationSize_int;i++) {
			
			int randomIdx_int;//random index corresponding to GENES_ArrStr or selected_ArrBoo  
			
			//sample randomIdx_int again if selected_ArrBoo[randomIdx_int] is already true
			do
				randomIdx_int = rand.nextInt(GENES_ArrStr.length);
			while(selected_ArrBoo[randomIdx_int]==true);
			
			combination_ArrStr[i]=GENES_ArrStr[randomIdx_int];//fill String in String[]
			selected_ArrBoo[randomIdx_int]=true;
		}

		return combination_ArrStr;
	}
	
	public static void main(String[] args) {
		int nCombinations_int=10;//number of combinations to be printed
		int maxCombinationSize_int=3;//maximum number of genes per Combination
		boolean enableLesser_boo=true;//whether lesser combinations should be allowed 
			//(i.e. if maxCombinationSize_int=5, Combinations with 2, 3 and 4 genes are also allowed)
		
		//return and print nCombinations_int combinations 
		for(int i=0;i<nCombinations_int;i++) {
			print(Arrays.toString(getCombination(maxCombinationSize_int,enableLesser_boo)));
		}
	}
	
}
