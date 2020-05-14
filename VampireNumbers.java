package VampireNumbers;

/**
 * Finding Vampire Numbers
 * Exercises 5 - Chapter 4, page 128 Think in Java (4th edition) - Bruce Eckel
 * 
 * A vampire number has an even number of digits and is formed by
 * multiplying a pair of numbers containing half the number of digits of the result. The digits
 * are taken from the original number in any order. Pairs of trailing zeroes are not allowed.
 * Examples include:
 * 1260 = 21 * 60
 * 1827 = 21 * 87
 * 2187 = 27 * 81
 * Write a program that finds all the 4-digit vampire numbers.
 * @author feBueno - March 2020
 */

import static net.mindview.util.Print.*;
import java.util.*;

public class VampireNumbers {
	/*prints a list of list with all 4-digits vampire numbers. 
	 * Each inner-list is a 4-digits vampire number, 
	 * Each integer is a digit within the vampire number
	 * 
	 * output:
	 * [[1, 3, 9, 5], [1, 2, 6, 0], [6, 8, 8, 0], [2, 1, 8, 7], [1, 8, 2, 7], [1, 4, 3, 5], [1, 5, 3, 0]]
	 * 
	 * example: 1395 is a vampire number since: 
	 * 	(i)  15x93=1395
	 * 	(ii) each 1-digit involved in the multiplication (1,5,9,3) appears as many times in the result (1,3,9,5)
	 * moreover, 1395 is a 4-digits vampire number since: 
	 *  (i)  the multipliers are two 2-digits-numbers and the result is a 4-digits-number
	 * */
	
	public static <T> Set<T> convertListToSet(List<T> list) 
    { 
        // create an empty resultsSet 
        Set<T> resultsSet = new HashSet<>(); 
  
        // Add each element of list into the resultsSet 
        for (T t : list) 
            resultsSet.add(t); 
  
        // return the resultsSet 
        return resultsSet; 
    }
	
	public static void addIfCondition(int couple1, int couple2, int a, int b, int c, int d, List<String> resultsList) {
		/*given two 2-digits-numbers (couple1 and couple2), add to resultsList each of the 4 1-digit-elements
		if 3 conditions are satisfied:
			1- couple1*couple2 yields a 4-digits-number
			2- the 4-digits-number contains each of the 4 1-digit-elements within couple1&couple2
			3- each 1-digit-element appears the same number of times in couple1&couple2 and the 4-digits-number
		*/
		
		//check condition 1
		int FourDigitsNumber= couple1*couple2;
		int mlength = String.valueOf(FourDigitsNumber).length();
		if(mlength>3) {
			//if condition 1 is satisfied, create an inner-list with each 1-digit-element contained in the couple1*couple2 product
			List<Integer> FourDigitsNumberList= new ArrayList<Integer>();
			String number = String.valueOf(FourDigitsNumber);
			for(int i = 0; i < number.length(); i++) {
			    int j = Character.digit(number.charAt(i), 10);
			    FourDigitsNumberList.add(j);
			}
			
			//check condition 2
			Integer[] mdigits_array= new Integer[] {a,b,c,d};
			if(FourDigitsNumberList.containsAll(Arrays.asList(mdigits_array)) && Arrays.asList(mdigits_array).containsAll(FourDigitsNumberList)) {
				
				//if condition 2 is satisfied: 
				//(A) create a map where each key is a 1-digit-element in the 4-digits-number and the value is the count
				Map<Integer,Integer> FourDigitsNumbermap = new TreeMap<Integer,Integer>();
				Integer mvalue = 0;
				Integer mkey = 0;
				for(int i=0;i<FourDigitsNumberList.size();i++) {
					mkey = FourDigitsNumberList.get(i);
					mvalue = FourDigitsNumbermap.get(mkey);
					FourDigitsNumbermap.put(mkey, mvalue==null?1:++mvalue);
				}
				
				//(B) create a map where each key is a 1-digit-element in the couple1&couple2 and the value is the count
				List<Integer> mdigits_list = Arrays.asList(mdigits_array);	
				Map<Integer,Integer> mdigitsmap = new TreeMap<Integer,Integer>();
				for(int i=0;i<mdigits_list.size();i++) {
					mkey = mdigits_list.get(i);
					mvalue = mdigitsmap.get(mkey);
					mdigitsmap.put(mkey, mvalue==null?1:++mvalue);
				}
				
				//check condition 3
				//for each key in both maps previously created, the value needs to be same 
				boolean m_add=true;
				for(int i=0;i<mdigitsmap.size();i++) {
					mkey = FourDigitsNumberList.get(i);
					Integer firtsValue_4D=FourDigitsNumbermap.get(mkey);
					Integer firtsValue_mDigits=mdigitsmap.get(mkey);
					
					if(firtsValue_4D!=firtsValue_mDigits) {
						m_add=false;
					} 
				}
				if(m_add) {
					resultsList.add(FourDigitsNumberList.toString());
				}
			}
		} 
	}
	public static void main(String[] args) {
		
		int[] digit1 = {0,1,2,3,4,5,6,7,8,9};
		int[] digit2 = {0,1,2,3,4,5,6,7,8,9};
		int[] digit3 = {0,1,2,3,4,5,6,7,8,9};
		int[] digit4 = {0,1,2,3,4,5,6,7,8,9};
		List<String> resultsList = new ArrayList<String>();
		
		//iterate over all possible 4-digits combination
		for(int a=0;a<10;a++) {
			for(int b=0;b<10;b++) {
				for(int c=0;c<10;c++) {
					for(int d=0;d<10;d++) {

						//create all 2 digits combinations from 1 digit element (i.e a=1, b=3 -> couple1=13)
						//there are 12 pair-wise combinations for the 4 digits (4^2-4) 
						int couple1=Integer.valueOf(String.valueOf(digit1[a]) + String.valueOf(digit2[b]));
						int couple2=Integer.valueOf(String.valueOf(digit1[a]) + String.valueOf(digit3[c]));
						int couple3=Integer.valueOf(String.valueOf(digit1[a]) + String.valueOf(digit4[d]));
						
						int couple4=Integer.valueOf(String.valueOf(digit2[b]) + String.valueOf(digit1[a]));
						int couple5=Integer.valueOf(String.valueOf(digit2[b]) + String.valueOf(digit3[c]));
						int couple6=Integer.valueOf(String.valueOf(digit2[b]) + String.valueOf(digit4[d]));

						int couple7=Integer.valueOf(String.valueOf(digit3[c]) + String.valueOf(digit1[a]));
						int couple8=Integer.valueOf(String.valueOf(digit3[c]) + String.valueOf(digit2[b]));
						int couple9=Integer.valueOf(String.valueOf(digit3[c]) + String.valueOf(digit4[d]));
						
						int couple10=Integer.valueOf(String.valueOf(digit4[d]) + String.valueOf(digit1[a]));
						int couple11=Integer.valueOf(String.valueOf(digit4[d]) + String.valueOf(digit2[b]));
						int couple12=Integer.valueOf(String.valueOf(digit4[d]) + String.valueOf(digit3[c]));
						
						
						//create all 4 digits combinations from 2-digits-elements 
						//there are 12 pair-wise combinations for the 12 2-digits-elements 
						//considering each combination should contain the 4 digits
						//(i.e a=1, b=3, c=4, d=6 -> couple1=ab=13, couple9=cd=46. couple1 and couple9 contain each in [abcd])
						
						addIfCondition(couple1,couple9,a,b,c,d,resultsList);
						addIfCondition(couple1,couple12,a,b,c,d,resultsList);
						
						addIfCondition(couple2,couple6,a,b,c,d,resultsList);
						addIfCondition(couple2,couple11,a,b,c,d,resultsList);
						
						addIfCondition(couple3,couple5,a,b,c,d,resultsList);
						addIfCondition(couple3,couple8,a,b,c,d,resultsList);
						
						addIfCondition(couple4,couple12,a,b,c,d,resultsList);
						addIfCondition(couple4,couple9,a,b,c,d,resultsList);
						
						addIfCondition(couple5,couple10,a,b,c,d,resultsList);
						
						addIfCondition(couple6,couple7,a,b,c,d,resultsList);
						
						addIfCondition(couple7,couple11,a,b,c,d,resultsList);
						
						addIfCondition(couple8,couple10,a,b,c,d,resultsList);	
					}
				}
			}
		}
	
	Set<String> resultsSet = convertListToSet(resultsList);//remove duplicates
	print(resultsSet);
	}
}
