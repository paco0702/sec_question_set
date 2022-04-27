package question;

public class EggDropping {
	/*
	 suppose you have N eggs and you want to ]
	 determine from which floor in a K floor building 
	 you can drop an egg such that it doesnt break 
	 you have to determine the minimum number 
	 of attempts you need in order find the critical
	 floor in the worse case while using the best strategy 
	 there are few rule given below 
	 
	 an egg that survives a fall can be used again
	 a broken egg must be discarded 
	 the effect of a fall is the samefor all eggs 
	 if the egg doesnt break at a certain floor, it will not break at any floor below  
	 if the eggs breas at a certain floor, it will break at nay floor above
	 */
	
	int [][] eggMatrix;
	int e ;
	int f;
	EggDropping(int e, int f){
		this.eggMatrix = new int [e+1][f+1];
		this.e = e;
		this.f = f;
	}
	
	public void getMinAttempt() {
		this.eggMatrix = getMinAttempt(this.eggMatrix);
		System.out.println("With "+e+" number of eggs and at "+ f+" height of building "+ "the min try to drop egg is "+this.eggMatrix[e][f]);
	}
	private int [][] getMinAttempt(int [][]eggMatrix) { 
		
		for(int i=0; i<eggMatrix.length; i++) {
			for(int j=0; j<eggMatrix[i].length; j++) {
				if(i==0 || j ==0) {
					eggMatrix[i][j] = 0;
				}else
				if(i==1) {
					eggMatrix[i][j] = j;
				}else if(i>1 && j>=1){
					eggMatrix = tryCase(i, j,eggMatrix);
				}
			
			}
		}
		return eggMatrix ;
	}
	
	private int[][] tryCase(int i, int j, int [][] eggMatrix) {
		int min = j;
		int breakCase = 0;
		int nonBreakCase = 0;
		int max = 0;
		
		for(int k=1; k<=j; k++) {
			max = 0;
			if(k==1) {
				breakCase = 0;
				nonBreakCase = eggMatrix[i][j-k];
			}else if(k==j) {
				breakCase = eggMatrix[i-1][j-1];
				nonBreakCase = 0;
			}else {
				breakCase = eggMatrix[i-1][k-1];
				nonBreakCase = eggMatrix[i][j-k];
			}
			max = 1+getMax(breakCase, nonBreakCase);
			
			if(min>max) {
				min = max;
			}
		}
		
		eggMatrix[i][j] =  min;
		
		return eggMatrix;
	}
	private int getMax(int a, int b) {
		if (a>b) {
			return a;
		}else 
			return b;
	}
	
	public static void main(String [] args) {
		EggDropping eg = new EggDropping(2, 10);
		eg.getMinAttempt();
	}
}
