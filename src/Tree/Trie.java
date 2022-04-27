package Tree;

import org.apache.commons.lang3.StringUtils;

public class Trie {
	// Trie is an efficient informtion re Trieval data structure
	// Using Trie, search complexities can be brought to optimal limit (key length)
	// if we store keys in binary search tree, a well balanced BST will beed time proportinal to 
	//            m*longn
	// m is maximum string length and n is number of key in tree 
	// using Trie , we can search the key in O(M) time
	// penalty is on Trie storage requriement 
	
	// only compare the characters and move down 
	// 
	
	static final int ALPHABET_SIZE = 26;
	 static class TrieNode {
		 
		 TrieNode [] children = new TrieNode[ALPHABET_SIZE];
		 boolean isEndOfWord;
		 
		 TrieNode(){
			 isEndOfWord = false;
			 for(int i =0; i<ALPHABET_SIZE; i++){
				 children[i]=null;
			 }
		 }
		 
		 
	 }
	 
	 static TrieNode root;
	 
	 static void insert (String key){
		 int level; 
		 int length = key.length();
		 int index;
		 
		 TrieNode pCrawl = root;
		 
		 for(level = 0; level < length; level++){
			 index= key.charAt(level) - 'a'; // change to be integer 
			 System.out.println("key.charAt(level): "+ key.charAt(level));
			 System.out.println("index: "+ index);
			 // chekc the node is existed or not 
			 if(pCrawl.children[index] == null){
				 // the first round 
				 // 't' is root child 
				 // and 't' is new
				 // so assign 't' to as a  new TrieNode 
				 pCrawl.children[index] = new TrieNode();
			 }
			 // then move the root to child not just inserted and  continue inserting the string 
			 
			 System.out.println("(before declare the inserting node's children) "
			 		+ "pCrawl.children["+index+"]: "+pCrawl.children[index]);
			 // root -> root.child which is 't' 
			 // 't' will connect the remaining string as a parent node 
			 pCrawl = pCrawl.children[index];
			 System.out.println(" (after declare the inserting node's children "
			 		+ "pCrawl.children["+index+"]: "+pCrawl.children[index]);
			 System.out.println("pCrawl "+pCrawl);
		 }
		 
		 pCrawl.isEndOfWord = true;
		 
	 }
	 
	 public static boolean search(String key){
		 char [] theKey = key.toCharArray();
		 String theResult = "";
		 
		 TrieNode goSearch = root;
		 int index;
		 for(int i=0; i<theKey.length; i++){
			 index= theKey[i] - 'a';
			 System.out.println(index);
			 if(goSearch.children[index]!=null){
				 System.out.println("enter with the index "+ index);
				 theResult = theResult+key.charAt(i);
				 goSearch = goSearch.children[index];
			 }else {
				 break;
			 }
		 }
		 System.out.println(key);
		 System.out.println(theResult);
		 if(StringUtils.compare(key, theResult)==0){
			return true;
		 }else {
			 return false;
		 }
	 }
	
	 
	 public static void main(String [] args){
	     // Input keys (use only 'a' through 'z' and lower case) 
	        String keys[] = {"the", "a", "there", "answer", "any", 
	                         "by", "bye", "their"}; 
	       
	        String output[] = {"Not present in trie", "Present in trie"}; 
	       
	       
	        root = new TrieNode(); 
	        int i; 
	        for (i = 0; i < keys.length ; i++) 
	            insert(keys[i]); 
	        
	        System.out.println(search("the"));
	        if(search("the")==true){
	        	System.out.println("this word inserted before");
	        }else{
	        	System.out.println("this word is not in the tree");
	        }
	        
	        if(search("their")==true){
	        	System.out.println("this word inserted before");
	        }else{
	        	System.out.println("this word is not in the tree");
	        }
	        
	        if(search("these")==true){
	        	System.out.println("this word inserted before");
	        }else{
	        	System.out.println("this word is not in the tree");
	        }
	        
	        if(search("thaw")==true){
	        	System.out.println("this word inserted before");
	        }else{
	        	System.out.println("this word is not in the tree");
	        }
	       
	 }
}
