package Sort;

//import bucket.linkedList;

public class bucketSort {
	static linkedList [] bucket = new linkedList[10];
	public static void main(String [] args ) {
		bucketSort b = new bucketSort();
		initiate();
		b.insert(0.12);
		b.insert(0.17);
		
		b.insert(1.12);
		b.insert(1.17);
		bucket[0].printList();
		System.out.println();
		bucket[1].printList();
	}
	
	private static void initiate() {
		for(int i=0; i<bucket.length; i++) {
			bucket[i] = new linkedList();
		}
	}
	
	public void insert(double data) {
		int inprt = (int) data;
		System.out.println(inprt);
		if(inprt>=0 && inprt <=9 ) {
			// do insert
			bucket[inprt].insert(data);
		}
	}
}
