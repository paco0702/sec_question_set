package question;

public class PaperCut {
	/*
	 given a paper of size AxB 
	 task is to cut the paper into squares of any size 
	 find the minimum number of squares that can be cut
	 from the paper 
	 */
	
	PaperCut(){
		
	}
	
	public static void main(String [] args) {
		//for(int i=0; i<4; i++) {
		//	for(int j=0; j<5; j++) {
		//		System.out.print("*");
		//	}
		//	System.out.println();
		//}
		
		PaperCut p = new PaperCut();
		p.numberOfSquare(36, 30);
		p.numberOfSquare(4, 5);
	}
	
	
	public void numberOfSquare(int x, int y) {
		double a =  Math.floor(y/2.0);
		double b = Math.ceil(y/2.0);
		//System.out.printf("a: %d, b: %d", a, b);
		int maxA =0;
		int maxB =0;
		int returnA =0;
		int returnB =0;
		for(int i=0; i<Math.ceil(y/2); i++) {
			a = a-i;
			b = b+i;
			if(a==0||b==0) {
				break;
			}
			if(checkValue(a,x)==true && checkValue(b,x)==true) {
				
				int newA =(int)( x/(a));
				int newB = (int) (x/(b));
				if((newA+newB)>(maxA+maxB)) {
					maxA = newA;
					maxB = newB;
					returnA = (int)a;
					returnB = (int)b;
				}
			}
		}
		
		System.out.println(maxA+" squares of size "+returnA+"x"+returnA);
		System.out.println(maxB+" squares of size "+returnB+"x"+returnB);
	}
	
	private boolean checkValue(double input, int x) {
		if(x%input==0) {
			return true;
		}else return false;
	}
}
