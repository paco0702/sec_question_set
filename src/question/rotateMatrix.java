package question;



public class rotateMatrix {
	//Given a square matrix, turn it by 90 degrees in anti clockwise 
	//direction without using any extra space
	
	rotateMatrix(){
		
	}
	public static void main(String [] args)	{
		
		int [][] input = { {1,2,3},
							{4,5,6},
							{7,8,9}};
		rotateMatrix rm = new rotateMatrix();
		rm.rotate(input);
		
	}
	
	public int [][] rotate(int [][] input){

		int theLength = input[0].length-1;
		int c = input[0].length-1;
		int r = input[0].length-2;
		int l = 1;
		for(int i =0 ; i<input.length; i++) {
			l = i +1;
			r = c -1;
			for(int j=0; j<theLength; j++ ) {
				int firstOne = input[i][r];
				int secOne = input[l][c];
				//System.out.print(firstOne+" ");
				//System.out.print(secOne+" ");
				input[i][r] = secOne;
				input[l][c] = firstOne;
				r--;
				l++;
			}
			theLength = theLength-1;
			c--;
		}
		
	    int c1 = 0;
	    int c2 = input[0].length-1;
	    
	    for(int i=0; i<input.length/2; i++) {
	    	for(int j=0; j<input[i].length; j++) {
		    	int firstOne = input[j][c1];
				int secOne = input[j][c2];
				
				input[j][c1] = secOne;
				input[j][c2] = firstOne;
	    	}
	    	c1 ++;
	    	c2--;
	    }
		
		printRotatedMatrix(input);
		return input;
	}
	
	private void printRotatedMatrix(int [][] input	) {
		for(int i =0; i<input.length; i++) {
			for(int j=0; j<input[i].length; j++) {
				System.out.printf("%d ",input[i][j]);
			}
			System.out.println();
		}
	}
	
}

