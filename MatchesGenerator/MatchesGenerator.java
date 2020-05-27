package exercises;

import static net.mindview.util.Print.print;

/**
 * Implements a Map generator with a next-method that 
 * puts in a Map as many elements as specified in constructor.
 * The generator is Iterable; a Map is printed in console (see Application).
 * 
 * Adapted from containers/MapDataTest.java, Chapter 17, page 594, Think in Java (4th edition) - Bruce Eckel
 * 
 * REQUIRE:
 * MatchesGeneratorComplement.java
 * 
 * Application:
 * In order to assess relationships between DNA sequences in a frequentist manner, 
 * random kmers can be generated and then, for each sequences-pair, it can be checked 
 * weather a certain number of matches occur for each kmer. 
 * 
 * Prints a Map where the keys represent kmers and the values matches-count. 
 * Each Map element printed represents a condition that needs to be fulfilled 
 * to conclude that two sequences are similar.
 * Keys and values are generated randomly according to user specifications.
 * 
 * @author feBueno, May 2020
 * fernando.bueno.gutie@gmail.com
 */


import java.util.*;
import net.mindview.util.*;//https://github.com/rawbenny/ThinkInJava4/tree/master/src/net/mindview/util
	/*the following is used: class: Pair.java, CollectionData.java, MapData.java
							 interface: Generator.java*/


class SequencesGenerator implements Generator<Pair<String,Integer>>,Iterable<Integer> {
	
	int kmerSize_int;//kmer size (number of nucleotides)
	int nConditions_int;//number of conditions to claim similarity
	int maxNmatches_int;//maximum number of matches per kmer to claim similarity

	ArrayList<String> kmers_StrArrLis;//each element will be a kmer of kmerSize
	ArrayList<Integer> nMatch_IntArrLis;//each element will be a minimum-number-of-matches
	
	public SequencesGenerator(int kmerSize_int, int nConditions_int, int maxNmatches_int){
		this.kmerSize_int=kmerSize_int;
		this.nConditions_int=nConditions_int;
		this.maxNmatches_int=maxNmatches_int;
	}

	public Pair<String,Integer> next() {
	  new MatchesGeneratorSupplement(maxNmatches_int);
      ArrayList<String> kmers_StrArrLis = new ArrayList<String>(CollectionData.list(new MatchesGeneratorSupplement.String(kmerSize_int), nConditions_int));
	  ArrayList<Integer> nMatch_IntArrLis = new ArrayList<Integer>(new CollectionData<Integer>(new MatchesGeneratorSupplement.Integer(), nConditions_int));

	  return new Pair<String,Integer>(kmers_StrArrLis.get(number), + nMatch_IntArrLis.get(number++));
	  //make a pair with each kmers_StrArrLis-nMatch_IntArrLis element
	}
	
	private int size = 3;
	private int number = 0;
	public Iterator<Integer> iterator() {
	  //enable java.lang.Iterable() properties.
	  return new Iterator<Integer>() {
	    public Integer next() { return number++; }
	    public boolean hasNext() { return number < size; }
	    public void remove() {
	      throw new UnsupportedOperationException();
	    }
	  };
	}
}



public class MatchesGenerator {
	public static void main(String[] args) {
		
		//DEFINE BY USER
		int kmerSize_int=8;//kmer size (number of nucleotides)
		int nConditions_int=5;//number of conditions to claim similarity
		int maxNmatches_int=400;//maximum number of matches per kmer to claim similarity
		
	    print(MapData.map(new SequencesGenerator(kmerSize_int,nConditions_int,maxNmatches_int), nConditions_int));
	}
} /* Output:
{TCTAATAC=303, GTGAACGT=261, CAAAACAG=242, TCGTTGAC=250, CTACACGT=25}
*/
