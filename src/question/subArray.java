package question;

import java.util.ArrayList;
import java.util.List;

public class subArray {
	/*
	 given an array of integers
	 find two non overlapping contiguous sub arrays 
	 such that the absolute difference between the sum of two 
	 sub array is max 
	 */
	// using count sort to solve it
	int [] input;
	int [] countArray;
	int [] outputArray;
	
	List<Integer> subArray = new ArrayList<>();
	List<Integer> subSecArray = new ArrayList<>();
	
	int subSum =0;
	int secSubSum = 0;
	
	subArray(int [] input){
		this.input = input;
		this.countArray = new int [21];
		this.outputArray = new int [input.length+1];
	}
	
	public void sort() {
		count();
		culmulate();
		doSort();
		printArray();
		subArray();
		secSubArray();
	}
	
	private void subArray() {
		int lastOne = 0;
		for(int i=0; i<this.outputArray.length; i++	){
			if(this.outputArray[i]<0 && lastOne!=this.outputArray[i]) {
				subArray.add(this.outputArray[i]);
				subSum = subSum + outputArray[i];
				lastOne = this.outputArray[i];
			}
		}
	}
	
	private void secSubArray() {
		int lastOne = 0;
		for(int i=0; i<this.outputArray.length; i++	){
			if(this.outputArray[i]>0 && lastOne!=this.outputArray[i]) {
				subSecArray.add(this.outputArray[i]);
				secSubSum = secSubSum + outputArray[i];
				lastOne = this.outputArray[i];
			}
		}
	}
	public List subArry() {
		return this.subArray;
	}
	
	public List secSubArry() {
		return this.subSecArray;
	}
	
	public int maxDiff() {
		return secSubSum - subSum;
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
			System.out.printf("%d ", this.countArray[i]);
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
		System.out.println();
	
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
	}
	
	private void printArray() {
		for(int i=0; i<this.outputArray.length; i++) {
			System.out.println(outputArray[i]);
		}
	}
	public static void main(String [] args) {
		int [] input = {-2, -3, 4, -1, -2, 1, 5, -3};
		subArray sb = new subArray(input);
		sb.sort();
		
		List subArray = sb.subArry();
		List secSubArray = sb.secSubArry();
		
		System.out.println(sb.maxDiff());
	}
}
