package exercises;

/**
 * Define any class as java.lang.Comparable. Thus, simplifying arrays-creation and comparison of elements within.
 * Adapted from arrays/CompType.java, Chapter 16, page 557, Think in Java (4th edition) - Bruce Eckel
 * 
 * The class has a Generator method that can be called from java.lang.Generated.array a number of times.
 * Each time it is called, next() is called and an instance of the class is filled into an array.
 * The array has java.lang.Comparable properties.
 * 
 * Applications:
 * In this case, the Comparable type is CompGene and enables to compare genes based on data. 
 * Data for 6 genes is simulated and allocated into an array. Then, the array is sorted.
 * 
 * @author feBueno, May 2020
 * fernando.bueno.gutie@gmail.com
 */

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class CompGene implements Comparable<CompGene> {
	
  //Gene properties. Each CompGene object represents a gene. 
  //For each new CompGene(), provide this data in constructor
  static int geneIdx_int;//index with respect to genes_strArr
  int conc_int;//concentration
  int degra_int;//degradation
  int nTrans_int;//number of transcripts
  int compVar_int;//variable that will be use for the comparison in the compareTo method. 
  	//Value will be similar to one of [conc_int,degra_int,nTrans_int] as defined in compVar_str.
  
  //Other CompGene fields
  String name_str;//gene HGNC symbol. To be assigned based on geneIdx_int.
  private static int instanceCount_int = 0;//how many CompType-instances have been previously created
  private static Random ran = new Random(66);//reproducible results?
  
  //DEFINE BY USER: gene names (and array size); maximum concentration, degradation and number of transcripts
  //that will be assigned randomly for each gene; and which variable will be used in CompGene[] comparisons
  //one CompType-instance (gene) will be created for each element in names_strArr (gene name)
  public static String[] names_strArr = new String[]{"BRCA1","BRCA2","PTEN","TP53","PALB2","ATM"};
  static int maxConc_int=7;//maximum gene concentration allowed
  static int maxDegra_int=5;//maximum gene degradation
  static int maxnTrans_int=30;//maximum number of gene transcript
  static String compVar_str="nTrans";//variable used for sorting. Any in ["conc", "degra", "nTrans"]
  
  public CompGene(int geneIdx,int conc, int degra, int nTrans, String compVar_str) {
	//define fields for a particular CompGene-instance given data in CompGene-constructor
	name_str = names_strArr[geneIdx];  
	conc_int = conc;
	degra_int = degra;
	nTrans_int = nTrans;
	switch(compVar_str) {//convert user-defined compVar_str to compareTo-usable compVar_int
		case("degra"): compVar_int = degra;break;
		case("nTrans"):compVar_int = nTrans;break;
		default:compVar_int = conc;//default: compVar_int will be exactly same as conc_int for each gene
	}
  }
  
  public String toString() {
    String result = name_str +"[conc = " + conc_int + ", degra = " + degra_int + ", nTrans = " + nTrans_int +"]";
    if(++instanceCount_int % 3 == 0)//print in new line every 3 CompGene-instances
      result += "\n";
    return result;
  }
  
  public int compareTo(CompGene CompGene) {//Comparable-methods-implementation. For instance, define how Arrays.sort is done for CompGene[]
	  //compVar_int points which CompGene-field should be considered for the Comparison-methods. For instance, in Arrays.sort(CompGene[])  
	  return (compVar_int < CompGene.compVar_int ? -1 : (compVar_int == CompGene.compVar_int ? 0 : 1));
  }
    
  public static Generator<CompGene> geneGenerator() {
	//method that when passed to Generated.array, calls "next" a number of times.
    return new Generator<CompGene>() {
      public CompGene next() {
    	//each time "next" is called, a new CompGene-instance is filled in the CompGene[] returned by Generated.array
        return new CompGene(geneIdx_int++,ran.nextInt(maxConc_int),ran.nextInt(maxDegra_int),ran.nextInt(maxnTrans_int),compVar_str);
      }
    };
  }
  
  public static void main(String[] args) {
	  
    CompGene[] geneData_CompTypeArr = Generated.array(new CompGene[names_strArr.length], geneGenerator());
    
    print("before sorting:");
    print(Arrays.toString(geneData_CompTypeArr));
    Arrays.sort(geneData_CompTypeArr);// or Arrays.sort(geneData_CompTypeArr, Collections.reverseOrder());
    print("after sorting based on nTrans:");
    print(Arrays.toString(geneData_CompTypeArr));
  }
} /* Output:
before sorting:
[BRCA1[conc = 5, degra = 2, nTrans = 13], BRCA2[conc = 2, degra = 1, nTrans = 11], PTEN[conc = 2, degra = 4, nTrans = 2]
, TP53[conc = 0, degra = 2, nTrans = 2], PALB2[conc = 0, degra = 3, nTrans = 13], ATM[conc = 1, degra = 0, nTrans = 4]
]
after sorting based on nTrans:
[PTEN[conc = 2, degra = 4, nTrans = 2], TP53[conc = 0, degra = 2, nTrans = 2], ATM[conc = 1, degra = 0, nTrans = 4]
, BRCA2[conc = 2, degra = 1, nTrans = 11], BRCA1[conc = 5, degra = 2, nTrans = 13], PALB2[conc = 0, degra = 3, nTrans = 13]
]
*/
