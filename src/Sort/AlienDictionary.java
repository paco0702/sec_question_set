package Sort;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	/*
	 Given a sorted dictionary of an alien language having 
	 N words and k starting alphabets of standard 
	 dictionary 
	 Find the order of characters in the alien language
	 */
	List <Character> language = new ArrayList<>();
	
	AlienDictionary(){
		
	}
	
	public static void main(String [] args) {
		int n =  5;
		int k = 4;
		
		String [] dict =  {"baa","abcd","abca","cab","cad"};
		AlienDictionary a = new AlienDictionary();
		a.findOrder(dict, k);
	}
	
	public int  findOrder(String [] dict, int k) {

		int count = 0;
		char []  sort = new char [k];
		int k1 = 0;

		for(int i=0; i<dict.length; i++) {
			if(count == k) {
				break;
			}
			if(i== 0) {
				sort[count] = dict[i].charAt(k1);
				count ++;
			}else {
				if(dict[i+1].charAt(k1)==dict[i].charAt(k1) && dict[i+1].length()== dict[i].length()) {
					char [] token = dict[i].toCharArray();
					char [] token2 = dict[i+1].toCharArray();
					int u = 0;
					int t1 = 0;
					int t2 = 0;
					while(u<token2.length) {
						if(token[t1]==token2[t2]) {
							t1++;
							t2++;
							u++;
						}else {
							if(isThere(sort, token[t1], count)==false) {
								sort[count] = token[t1];
								count++;
								t1++;
								
							}
						
							if(isThere(sort, token2[t2], count)==false) {
								sort[count] = token2[t2];
								count++;
								t2++;
							}
							u++;
						
						}
					}
				}
				if(isThere(sort, dict[i].charAt(k1), count)==false) {
				sort[count] = dict[i].charAt(k1);
				count++;
				}
			}
		}
		if(count == k) {
			return 1 ;
		}else 
			return 0;
	}
	
	boolean isThere (char [] sort , char c,int count) {
		int n = 0;
		boolean appeared = false;
		while(n <count) {
			if(sort[n]==c) {
				appeared = true;
				break;
			}else {
				n++;
			}
		}
		if(appeared == false) {
			return false;
		}else 
			return true;
	}

}
