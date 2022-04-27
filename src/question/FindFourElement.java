package question;

import java.util.ArrayList;
import java.util.List;

public class FindFourElement {
	/*
	 given an array of integers 
	 find anyone combination of four elements 
	 in the array whose sum is equal to a given value 
	 
	 
	 */
	int [] input;
	int [] countArray;
	int [] outputArray;
	int [] justifiedArray;
	List<Integer> subArray = new ArrayList<>();
	List<Integer> subSecArray = new ArrayList<>();
	
	int subSum =0;
	int secSubSum = 0;
	
	 FindFourElement(int [] input){
		this.input = input;
		this.countArray = new int [21];
		this.outputArray = new int [input.length+1];
	}
	
	public void sort() {
		count();
		culmulate();
		doSort();
		printArray();
	}
	
	public int [] getOutPut() {
		return this.justifiedArray;
	}

	private void count () {
		for(int i=0; i<this.input.length; i++) {
			if(input[i]<0) {
				int negDigIndex = -(input[i]);
				this.countArray[negDigIndex] = this.countArray[negDigIndex] + 1;
			}else {
				int posDigIndex = input[i]+10;
				this.countArray[posDigIndex] = this.countArray[posDigIndex]+1;
				
			}
		}
	}
	
	private void culmulate() {
		for(int i=1; i<this.countArray.length; i++) {
			this.countArray[i] = this.countArray[i-1]+this.countArray[i];
			//System.out.printf("%d ", this.countArray[i]);
		}
		/*
		System.out.println();
		int lastIndex = this.countArray.length/2;
		for(int i=1; i<=(this.countArray.length/2)/2; i++) {
			int first = this.countArray[i];
			int sec = this.countArray[lastIndex-i+1];
			this.countArray[i] = sec;
			this.countArray[lastIndex-i+1] = first;
		}
		
		for(int i=1; i<this.countArray.length; i++) {
			System.out.printf("%d ", this.countArray[i]);
		}
		*/

	
	}
	
	private void doSort() {
		int indexNeg = 0;
		int indexPos = 0;
		int lastAppaeredNeg = 0;
		int lastAppaeredPos = 0;
		for(int i =0; i<this.input.length;i ++) {
			if(input[i]<0) {
				int checkDig = -(input[i]);
				int index = this.countArray[checkDig];
				this.outputArray[index] = input[i];
				this.countArray[checkDig]--;
				
			}else if(input[i]>0) {
				int checkDig = input[i]+10;
				int index = this.countArray[checkDig];
				this.outputArray[index] = input[i];
				this.countArray[checkDig]--;
				
			}
		}
		justifiedArray = new int [outputArray.length-1];
		int j=0;
		for(int i =0; i<justifiedArray.length; ) {
			if(outputArray[j]==0) {
				j++;
			}else {
				justifiedArray [i]= outputArray[j];
				j++;
				i++;
			}
		}
	}
	
	private void printArray() {
		for(int i=0; i<this.justifiedArray.length; i++) {
			System.out.printf("%d ",justifiedArray[i]);
		}
	}
	
	public int [] findFourDigit(int sum) {
		int [] [] matric = new int [justifiedArray.length][justifiedArray.length];
		int [] list = new int [4];
		int count = 0;
		// create matric
		
		System.out.println();
		for(int i=0; i<matric.length; i++) {
			for(int j=0; j<matric[i].length; j++) {
				matric[i][j] = justifiedArray[i]+justifiedArray[j];
				System.out.printf("%d ", matric[i][j]);
			}
			System.out.println();
		}
		int min = matric[0][1];
		int remain =sum;
	
		System.out.println(matric.length);
		System.out.println(matric[0].length);
		for(int i=matric.length-1; i>=0; i--) {
			for(int j=matric[i].length-1; j>=0; j--) {
				if(i!=j) {
					int tryTo = remain-matric[i][j];
					if(tryTo>=min) {
						list [count] = justifiedArray[i];
						list[count+1] = justifiedArray[j];
						count = count+2;
						remain = sum - matric[i][j];
						min = remain - min;
					}
				}
			}

		}
		return list;
	}

	public static void main(String [] args) {
		int [] input = {10, 2, 3, 4, 5, 9, 7, 8};
		FindFourElement f = new FindFourElement(input);
		f.sort();
		int [] output = f.getOutPut();
		int [] list = f.findFourDigit(23);
		
		for(int i=0; i<list.length; i++) {
			System.out.printf("%d ", list[i]);
		}
		
		System.out.println();
		
		int [] input2 =  {1, 2, 3, 4, 5, 9, 7, 8};
		FindFourElement f2 = new FindFourElement(input2);
		f2.sort();
		int [] list2 = f2.findFourDigit(16);
		for(int i=0; i<list2.length; i++) {
			System.out.printf("%d ", list2[i]);
		}
		
		//System.out.println(output.length);
		
	}
}
