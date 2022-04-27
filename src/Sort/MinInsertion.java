package Sort;
import java. util. Scanner;

public class MinInsertion {
	/*
	 given a string str, 
	 the task is to find the min number of characters 
	 to be inserted to convert it to palindrome
	  
	 */
	static char[] originalString;
	static char [] reversedStringC;
	static char[] skippedChar ;
	public static void main(String [] args) {
		
		String inputStr = "ab";
		//char [] convertToCharArray = inputStr.toCharArray();
		beginOperation(inputStr);
//		inputStr = "abcda";
//		beginOperation(inputStr);
//		
//		inputStr = "aa";
//		beginOperation(inputStr);
//		
//		
//		inputStr = "abcd";
//		beginOperation(inputStr);
		
	}
	
	public static void beginOperation(String inputStr) {
		if(check(inputStr)== true) {
			//do sth 
			originalString = inputStr.toCharArray();
			skippedChar = new char [originalString.length];
			//System.out.println("needed to convert");
//			for(int i=0; i<reversedStringC.length; i++) {
//				System.out.println(reversedStringC[i]);
//			}
			checkCondition();
		}
		
	}
	public static boolean check(String inputStr) {
		if(neededToConvert(inputStr)==0) {
			System.out.println("Number of insertions required is 0. "+inputStr);
			return false;
		}else {
			// do check 
			return true;
		}
	}
	public static int neededToConvert(String inputStr) {
		StringBuilder newString = new StringBuilder(inputStr);
		if(inputStr.compareTo(newString.reverse().toString())== 0) {
			return 0 ;
		}else {
			String reversedString = newString.toString();
			//System.out.println(reversedString)	;
			reversedStringC = reversedString.toCharArray();
			return 1;
		}
	}
	  
	public static void checkCondition() {
		int startDoingIndex = 0;
		int i = 0;
		
		do{
			//System.out.println(originalString[0]+" "+ reversedStringC[i]);
			if(originalString[0] != reversedStringC[i]) {
				break;
			}
			i++;
			startDoingIndex ++;
						
		}while(originalString[i] == reversedStringC[i]);
	
	    // know which index to start 
		prepareTheInsert(startDoingIndex);
		
	}
	
	private static void prepareTheInsert(int startIndex) {
		int skippedIndex = 0;
		int i = startIndex;
		int j = 0;
		while(originalString[startIndex] != reversedStringC[i]) {
			skippedIndex++;
			skippedChar[j] = reversedStringC[i];
			i++;
			j++;
		}
		//System.out.println(originalString[startIndex]+" "+reversedStringC[i]);
		for(int k=0; k<skippedChar.length; k++) {
			//System.out.print(skippedChar[k] );
		}
		//System.out.printf("\n skipped index %d \n", skippedIndex);
		//System.out.printf("\n start index is %d \n", startIndex);
		doTheInsert(skippedIndex, startIndex);
	}
	
	private static void doTheInsert(int skippedIndex, int startIndex) {
		String insertString = new String (skippedChar);
		String insertedString = "";
		
		insertString = insertString.trim();
		//System.out.println(insertString);
		if(startIndex==0) {
			// directly insert 
			String newString = insertString + new String(originalString);;
			//System.out.println(newString);
			insertedString = newString;
		}else {
			//skipped index 
			char [] newString = new char[originalString.length+skippedChar.length];
			int i=0;
			while(i!=startIndex) {
				newString[i] = originalString[i];
				i++;
			}
			int k = 0;
			while(k<skippedChar.length) {
				if(skippedChar[k]!=0) {
				newString[i] = skippedChar[k];
				i++;
				}
				k++;
			}
			int j = startIndex;
			while(j<originalString.length) {
				newString[i] = originalString[j];
				j++;
				i++;
			}
			insertedString = new String(newString);
			//System.out.println(insertedString);
		}
		System.out.println(outPutAnswer(insertedString, skippedIndex));
	}

	private static String outPutAnswer(String insertedString, int skippedIndex) {
		return "Number of insertions required is " + skippedIndex +". "+insertedString;
	}
	
	// or use two d array 
	
	//Sec 0.21
}
