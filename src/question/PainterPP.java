package question;

public class PainterPP {
	/*
	 Dilpreet wants to paint his dog 
	 Buzo's home that has n boards with 
	 different lengths [A1, A2, ...., An]
	 He kired k painters for this work 
	 and each painter takes 1 unit time to paint 1 unit of the board
	 The problem is to find the minimum time to get this job done 
	 under the constraints that any apinter will only paint continuous sections of boards 
	 say board{2,3,4} or only board {1} or nothing but not {2,4,5} 
	 */
	PainterPP(){
		
	}
	public static void main(String [] args ) {
		int numberOfTestCase = 1;
		
		int numberOfPainter = 2; // k 
		int numberOfBoard = 4; // n 
		
		int [] sizeForEachBoard = new int [4] ;
		sizeForEachBoard [0] =10;
		sizeForEachBoard [1] =10;
		sizeForEachBoard [2] =10;
		sizeForEachBoard [3] =10;
		
		//  what painter do is paralled 
		
		PainterPP p = new PainterPP();
		p.findMin(sizeForEachBoard, numberOfBoard, numberOfPainter);
		
		sizeForEachBoard [0] =10;
		sizeForEachBoard [1] =20;
		sizeForEachBoard [2] =30;
		sizeForEachBoard [3] =40;
		p.findMin(sizeForEachBoard, numberOfBoard, numberOfPainter);
		
	}
	
	public void findMin(int [] s, int n, int p) {
		int leftSide =0; 
		int rightSide = 0;
		int lastLeft = 0;
		int lastRight = 0;
		int j =1; 
		int k =0;
		int max = 0;
		for(int i =0; i<n; i++) {
			if(i == 0) {
				leftSide = DAC(s, k , j);
				rightSide = DAC(s, j, n);
				max = findMax(leftSide, rightSide);
				lastLeft = leftSide;
				lastRight = rightSide;
				
			}else {
				leftSide = DAC(s, k , j);
				rightSide = DAC(s, j, n);
				int theMax = findMax(leftSide, rightSide);
				if(max>theMax) {
					lastLeft = leftSide;
					lastRight = rightSide;
					max = theMax ;
				}
			}
			j++;
		}
		
		if(lastLeft<lastRight) {
			System.out.println(lastRight);
		}else {
			System.out.println(lastLeft);
		}
	}
	
	private int findMax(int a, int b) {
		if(a>b) {
			return a;
		}else 
			return b;
	}
	
	private int DAC(int [] s, int i, int j ) {
		int sum =0;
		for(int k=i; k<j; k++) {
			sum = sum + s[k];
		}
		
		return sum;
	}
}

// change it to more than 3 painter 