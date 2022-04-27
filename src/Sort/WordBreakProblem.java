package Sort;

import java.util.ArrayList;
import java.util.List;

public class WordBreakProblem {
	/*
	 given an input string and a dictionary of words
	 find out if the input string can be segmented into a space -separated sequence 
	 of dictionary word 
	 
	 consider the following dictionary 
	 {i, like, sam, sung, samsung, mobile, ice
	 cream, icecream, man, go mango}
	 
	 input ilike 
	 because 
	 i and like are in the dictionary
	 so output is yes 
	 
	 
	 */
	
	public static String [] dictionary = {"i", "like", "sam", "sung", 
			"samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
	
	public static void main(String [] args) {
		
		String input = "ilikesamsung";
		int lengthOfInput = input.length();
		//System.out.println(input.charAt(0));
		
		List <String> matchedString = new ArrayList<String>();
		String mactedStringStored  = "";
		    int i =0;
			for(int j =0; j<dictionary.length; j++) {
				int k =0;
				//char dictionaryFirstChar = dictionary[j].charAt(k);
				if(input.charAt(i)==dictionary[j].charAt(k)) {
					if((input.charAt(i)+"").compareTo(dictionary[j])==0) {
						System.out.println("The char is in the dictionary");
						matchedString.add(dictionary[j]);
						mactedStringStored = mactedStringStored + dictionary[j];
						i++;
					}else {
						k =0;
						int startIndex = i;
						int count = i;
						boolean isBreak = false;
						while(k<dictionary[j].length()) {
							if(input.charAt(count) == dictionary[j].charAt(k)) {
								count++;
								k++;
								//if match the char, keep going on to check
							}else {
								isBreak=true;
								break;
							}
						}
						
						System.out.println(input.substring(startIndex, count));
						if(isBreak==false) {
							matchedString.add(dictionary[j]);
							i = i+dictionary[j].length();
							mactedStringStored = mactedStringStored + dictionary[j];
						}
						
						
						if(i==lengthOfInput) {
							break; 
						}
					}
				}
			}
			
			System.out.println(mactedStringStored);
			if(mactedStringStored.compareTo(input)==0) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
	}
}
