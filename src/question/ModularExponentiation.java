package question;
import java.lang.Math;

public class ModularExponentiation {
	ModularExponentiation(){
		
	}
	public int computeMe(int x, int y , int p) {
		// return (((int)Math.pow(x, y)%p)%p);
		// without using power function 
		int powerValue = power(x,y);
		
		return (powerValue%p)%p;
	}
	
	private int power(int x, int y) {
		int result = 1;
		
		while(y>0) {
			result = result*x;
			y--;
		}
		return result;
	}
	
	public static void main(String [] args) {
		int x = 2; 
		int y = 3;
		int p = 5;
		ModularExponentiation me = new ModularExponentiation();
		int result = me.computeMe(x, y, p);
		System.out.println(result);
		x  =2;
		y = 5;
		p = 13;
		result = me.computeMe(x, y, p);
		System.out.println(result);
	}
	
	
}
