package question;

import java.util.ArrayList;
import java.util.List;

public class PrintMaxA {
	private List <String> storeResult = new ArrayList<>();
	private List <Integer> coorespondingIndex = new ArrayList<>();
	
	

	int usedMemories = 0;
	int referMemories = 0;
	
	PrintMaxA(){
		
	}
	
	public void maxFuntion(int input) {
		List <Character>  temp = new ArrayList<>();
		List <Character>  temp2 = new ArrayList<>();
		if (storeResult.size()<3) {
			if(input-4>=4) {
				// start with four As
				temp = fourMax(input);
				temp2 = threeMax(input);
				if(temp.size()>temp2.size()) {
					String target = "";
					for(int i =0; i<temp.size(); i++) {
						target = target+temp.get(i);
					}
					System.out.println(target.length());
					storeResult.add(target);
					
				}else {
					String target = "";
					for(int i =0; i<temp2.size(); i++) {
						target = target+temp2.get(i);
					}
					System.out.println(target.length());
					storeResult.add(target);
				}
			}else if(input -3 >=4){
				temp = threeMax(input);
				String target = "";
				for(int i =0; i<temp.size(); i++) {
					target = target+temp.get(i);
				}
				System.out.println(target.length());
				storeResult.add(target);
			}
			coorespondingIndex.add(input);
		}else {
			List <Character> compareList = new ArrayList<>();
			// have the memories to use
			
			// start with the last element of the memories to find out
			// which one should use 
			for(int i=coorespondingIndex.size()-1; i>=0; i--) {
				// if the number of instruction left more than 3
				// use that memory
				
				if(input-coorespondingIndex.get(i)>=3) {
					//System.out.println(input-coorespondingIndex.get(i));
					// 2 is the ctrl¡@A ctrl C 
					temp2 = tryList(input,  i);
					if(compareList.isEmpty()|| temp2.size()>compareList.size()) {
						compareList = temp2;
					}
				}
			}
			temp2 = compareList;
			String storedString = "";
			for(int j =0; j<temp2.size();j++) {
				storedString = storedString+temp2.get(j);
			}
			System.out.println(storedString.length());
			storeResult.add(storedString);
			coorespondingIndex.add(input);
		}
	}
	
	private List tryList(int input, int i) {
		List <Character>  temp = new ArrayList<>();
		List <Character>  temp2 = new ArrayList<>();
		int numberOfCopy = input - coorespondingIndex.get(i)-2;
		int index = i;
		for(int j=0; j<storeResult.get(index).length(); j++) {
			temp.add('A');
		}
	
		for(int j=0; j<=numberOfCopy ; j++) {
			temp2.addAll(temp);
		}
		
		return temp2;
	}
	private List fourMax(int input) {
		List <Character>  temp = new ArrayList<>();
		List <Character>  temp2 = new ArrayList<>();
		int numberOfCopy = input - 6;
		for(int i =0; i<4; i++) {
			temp.add('A');
		}
		
		
		for(int i =0; i<=numberOfCopy; i++) {
			temp2.addAll(temp);
		}
		return temp2;
	}
	
	private List threeMax(int input) {
		List <Character>  temp = new ArrayList<>();
		List <Character>  temp2 = new ArrayList<>();
		int numberOfCopy = input -5;
		for(int i =0; i<3; i++) {
			temp.add('A');
		}
		
		
		for(int i =0; i<=numberOfCopy; i++) {
			temp2.addAll(temp);
		}
		return temp2;
	}
	public static void main(String [] args) {
		PrintMaxA op = new PrintMaxA();
		op.maxFuntion(7);
		op.maxFuntion(8);
		op.maxFuntion(9);
		op.maxFuntion(10);
		op.maxFuntion(11);
		op.maxFuntion(12);
		op.maxFuntion(13);
		op.maxFuntion(14);
		op.maxFuntion(15);
		op.maxFuntion(16);
		op.maxFuntion(17);
		op.maxFuntion(18);
		op.maxFuntion(19);
		op.maxFuntion(20);
	}
	

}
