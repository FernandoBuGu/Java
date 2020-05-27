package exercises;

/**
 * Supplementary code for MatchesGenerator.java
 * Adapted from:
 * 		containers/MapDataTest.java/CollectionDataGeneration.java Chapter 17, page 592, Think in Java (4th edition) - Bruce Eckel
 *  	net/mindview/util/CollectionData.java //https://github.com/rawbenny/ThinkInJava4/tree/master/src/net/mindview/util
 * 		net/mindview/util/RandomGenerator.java
 * 		net/mindview/util/CountingGenerator.java
 * 
 * 
 * @author feBueno, May 2020
 * fernando.bueno.gutie@gmail.com
 */

import java.util.Random;
import net.mindview.util.Generator;//https://github.com/rawbenny/ThinkInJava4/tree/master/src/net/mindview/util

class MatchesGeneratorSupplement{
	private static Random r = new Random(47);
	
	static int maxNmatches_int;
	
	MatchesGeneratorSupplement(int maxNmatches_int){
		this.maxNmatches_int=maxNmatches_int;
	}
	public static class Integer implements Generator<java.lang.Integer> {
		//adapted from net/mindview/util/RandomGenerator.java 
		//let maxNmatches_int (maximum number of matches per kmer to claim similarity) be controlled by user
		private int mod = maxNmatches_int;
	    public Integer() {}
	    public Integer(int modulo) { mod = modulo; }
	    public java.lang.Integer next() {
	      return r.nextInt(mod);
	    }
	}
	
	
	static char[] chars = ("ACTG").toCharArray();
	//adapted from net/mindview/util/CountingGenerator.java 
	//limit random String sampling to DNA nucleotides
	
	 
	public static class Character implements Generator<java.lang.Character> {
		//from net/mindview/util/RandomGenerator.java
		public java.lang.Character next() {
			return chars[r.nextInt(chars.length)];
	    }
	}
	
	public static class String implements Generator<java.lang.String> {
		//from net/mindview/util/CountingGenerator.java
		//handle the change made in the "chars"-field within the same class
	    private int length = 2;
	    Generator<java.lang.Character> cg = new Character();
	    public String() {}
	    public String(int length) { this.length = length; }
	    public java.lang.String next() {
	      char[] buf = new char[length];
	      for(int i = 0; i < length; i++)
	        buf[i] = cg.next();
	      return new java.lang.String(buf);
	    }
	  }
	
	public static class mString extends String {
			//from net/mindview/util/RandomGenerator.java
		    // Plug in the random Character generator:
		    { cg = new Character(); } // Instance initializer
		    public mString() {}
		    public mString(int length) { super(length); }
	}
}