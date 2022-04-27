package Sort;

public class MaxKDigit {
	/*
	Given two arrays arr1[] and arr2[] of length M and N consisting of 
	digits [0,9] representing two numbers and an integer K(K<=M+N),
	the task is to find the Maximum K digit number possible by 
	selecting subsequences from the given arrays such that the relative order of 
	the digits is the same as in the given array 
	 
	 */
	int [] countArray;
	int [] data;
	int [] resultArray;
	/*
	MaxKDigit(int arrange, int [] data){
		this.countArray = new int [arrange];
		this.data = data;
		this.resultArray = new int [data.length];
	}
	
	
	MaxKDigit(int [] data){
		this(10, data);
	}
	*/
	
	 
	int []  start(int [] data) {
		this.data = data; 
		this.resultArray = new int [data.length];
		this.countArray = new int [10];
		count(data);
		cumulateCount();
		return sort();
		// printSortedArray();
	}
	
	private void count(int [] data) {
		for(int i=0; i<data.length; i++) {
			this.countArray[data[i]] = this.countArray[data[i]] + 1;
		}
	}
	
	private void cumulateCount() {
		for(int i=1; i<this.countArray.length; i++) {
			this.countArray[i] = this.countArray[i] + this.countArray[(i-1)];
			
		}
		//System.out.println(countArray[countArray.length-1]);
	}
	
	private int [] sort() {
		int lastElementIndex = data.length-1;
		for(int i =0; i<this.data.length; i++) {
			int element = this.data[lastElementIndex];
			int index = this.countArray[element]-1;
			this.countArray[element]--;
			this.resultArray[index] = element;
			lastElementIndex--;
		}
		
		return this.resultArray;
	}
	
	private void printSortedArray(int [] data) {
		for(int i=0; i<this.data.length; i++) {
			System.out.printf("%d ",data[i]);
		}
	}
	
	public int [] returnSortedArray() {
		if(resultArray!=null) {
		return this.resultArray;
		}else 
			return null;
	}
	MaxKDigit(){
		
	}
	
	public static void main(String[] args) {
		int [] arr1 = {3,4,6,5};
		int [] arr2 = {9,1,2,5,8,3};
		
		MaxKDigit mx = new MaxKDigit();
		arr1 = mx.start(arr1);
		mx.printSortedArray(arr1);
		
		System.out.println();
		
		arr2 = mx.start(arr2);
		mx.printSortedArray(arr2);
		
		
		System.out.println(mx.findMaxDigit(arr1, arr2,5));
		System.out.println();
		
		int [] arr3 = {6, 7};
		int [] arr4 = {6, 0, 4};
		
		arr3 = mx.start(arr3);
		mx.printSortedArray(arr3);
		
		System.out.println();
		
		arr4 = mx.start(arr4);
		mx.printSortedArray(arr4);
		
		
		System.out.println(mx.findMaxDigit(arr3, arr4,5));
		
	}
	
	
	public String findMaxDigit(int [] arr1, int [] arr2, int lengthOfDigit) {
		int a = arr1.length-1; // for the index of arr1 
		int b = arr2.length-1; // for the index of arr2
		
		String digit = "";
		// compare the digit in the array 
		// put the larger one into the array 
		// and move the used array to the next index 
		// and loop the comparsion 
		int lastDigit = 0;
		while(lengthOfDigit>0) {
			
			if(a<0) {
				digit = digit + arr2[b];
				b--;
			}else if(b<0) {
				digit = digit + arr1[a];
				a--;
			}else
			if(arr1[a]>=arr2[b]) {
				digit = digit + arr1[a];
				a--;
				
			}else if(arr2[b]>=arr1[a]) {
				digit = digit + arr2[b];
				b--;
			}
			
			lengthOfDigit--;
		}
		
		return digit;
	}
}
