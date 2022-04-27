package graph;

public class KnightWalk {
	
	int[] moveR = new int [6];
	int[] moveC = new int [6];
	
	int impossibleR; 
	int impossibleC;
	
	int gR;
	int gC;
	
	int perviousR = 0;
	int perviousc = 0;
	
	int move = 0;
	
	KnightWalk(int r, int c){
		this.gR = r;
		this.gC = c;
		setImpossibleRange(r,c);
	}
	
	private void setImpossibleRange(int r, int c) {
		this.impossibleC = c-2;
		this.impossibleR = r +2;
	}
	// rule of knight move 
	// two squares in any direction horizontally 
	// and followed by one square vertically 
	// or two square vertical followed by one square horizontally 
	
	public static void main(String[]args) {
		int [][] chessePosition = {
				{0,1,0,0,0,1},
				{0,0,0,2,0,0},
				{0,1,0,0,0,1},
				{0,0,1,0,1,0},
				{0,0,1,0,0,0},
				{0,0,0,0,0,0}
		};
		
		//your position 
		int r = 5;
		int c = 0;
		
		int gR = 1;
		int gC = 3;
		
		KnightWalk k = new KnightWalk(gR, gC);
		k.tryMoveShortest(chessePosition, r,c, 0);
		System.out.println(k.move);
		
	}
	
	public void tryMoveShortest(int [][] chessePosition, int r, int c, int move) {
		int position = chessePosition[r][c];
		if(position == 2) {
			System.out.println("Reached the goal");
		    return;
		}else {
			// save move 
			this.perviousc = c;
			this.perviousR = r;
			if(checkRangePossible(r-2, c+1, chessePosition)==true) {
				
				tryMoveShortest(chessePosition, r-2, c+1, move++);
				
			} 
			if(checkRangePossible(r-2, c-1, chessePosition)==true) {
				
				tryMoveShortest(chessePosition, r-2, c-1, move++);
				
			}
			if(checkRangePossible(r-1, c+2, chessePosition)==true){
				
				tryMoveShortest(chessePosition, r-1, c+2, move++);
				
			}
			if(checkRangePossible(r-1, c-2, chessePosition)==true) {
				
				tryMoveShortest(chessePosition, r-1, c+2, move++);
				
			}
		}
		
	}
	
	private boolean checkRangePossible(int r, int c, int [][] chessePosition) {
		if(r>=0 && c>=0) {	
			if(r<=this.impossibleR && c >=this.impossibleC ) {
				if(chessePosition[r][c]!=1 && chessePosition[r][c] !=2) {
					return false;
				}else {
					return true;
				}
			
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
}
