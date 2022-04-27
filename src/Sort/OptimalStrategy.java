package Sort;

public class OptimalStrategy {
	/*
	 consider a row of n coins of values v1... vn
	 where n is even 
	 we play a game against an opponenet by alternating turns 
	 in each turn, a player selects either the first of last coin from the row 
	 removes it from the row permanently, and receives the value of the coin 
	 determine the maximum possible amount of money we can definitely win 
	 if we move first
	 */
	
	
	static int [] dataSet = {20, 30, 2, 2, 2, 10};
	
	static int [] oppenentSet = new int [(dataSet.length)/2];
	static int [] playerSet = new int [(dataSet.length)/2];
	
	static int first =0 ;
	static int last = dataSet.length-1;
	
	public static void main(String [] arg) {

		int [] answer = returnOptimalValue();
		
		for(int i =0; i<answer.length; i++) {
			System.out.print(answer[i]+ " ");
		}
	}
	
	public static int [] returnOptimalValue() {

		int p = 0;
		int o = 0;
		
		boolean playerTurn = true;
		boolean oppenentTurn = false;
		
		for(int i=0; i<dataSet.length; i++) {
			if(playerTurn == true) {
				playerSet[p] =choseValue(dataSet);
				p++;
				playerTurn = false;
				oppenentTurn = true;
				
			}else if(oppenentTurn == true) {
				
				oppenentSet[o] = choseValue(dataSet);
				o++;
				playerTurn = true;
				oppenentTurn = false;
			}
		}
		return playerSet;
	}
	
	
	private static int choseValue(int [] dataSet) {
		int returnValue = 0;
		if(dataSet[first] > dataSet[last]) {
			if(dataSet[first+1]>dataSet[first]) {
				returnValue = dataSet[last];
				last--;
				return returnValue;
			}else if(dataSet[first+1]<dataSet[first]) {
				returnValue = dataSet[first];
				 first++;
				 return returnValue;
			}else {
				return returnValue;
			}
		}else if(dataSet[last]>dataSet[first]) {
			
			if(dataSet[last-1]>dataSet[last]) {
				returnValue = dataSet[first];
				first++;
				return returnValue;
			}else if(dataSet[last-1]<dataSet[last]) {
				 returnValue = dataSet[last];
				last--;
				return returnValue;
			}else {
				return returnValue;
			}
		}else {
		    return returnValue;
		}
	}
	// 0.11 s 
	
}
