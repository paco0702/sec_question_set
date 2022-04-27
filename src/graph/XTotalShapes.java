package graph;

public class XTotalShapes {
	/*
	 given a grid of n*m consisiting of 0's
	 and x's 
	 the task is to find the number of 'x' total shapes
	 note: 'x' shape consits of one or more adjacent x's 
	 diagonals not included 
	 
	 */
	XTotalShapes(){
		
		
	}
	
	public static void main(String [] args	)	{
		char [][] grid = {
				{'X','O','X'},
				{'O','X','O'},
				{'X','X','X'}
		};
		
		XTotalShapes x = new XTotalShapes ();
		int numberOfShape = x.findShape(grid);
		System.out.println(numberOfShape);
		char [][] grid2 = {
				{'X','O','X','X'},
				{'O','X','O','X'},
				{'X','O','X','O'}
		};
		numberOfShape= x.findShape(grid2);
		System.out.println(numberOfShape);
		
	}
	
	public int findShape(char [][]grid) {
		int r=0;
		int c=0;
		int shape = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == 'X') {
					grid = lookForAdjacency( grid,  i,  j);
					shape++;
				}
			}
		}
		return shape;
	}
	
	private char [][] lookForAdjacency(char [][] grid, int i, int j) {
		if(grid[i][j]=='X') {
			grid[i][j] = 'U';
			if((i-1)>=0) {
				grid = lookForAdjacency( grid, i-1, j);
			}
			if((i+1)<grid.length) {
				grid = lookForAdjacency( grid, i+1, j);
			}
			if((j+1)<grid[0].length) {
				grid = lookForAdjacency( grid, i, j+1);
			}
			
			if((j-1)>=0) {
				grid = lookForAdjacency( grid, i, j-1);
			}
		}
		
		return grid;
	}
}
