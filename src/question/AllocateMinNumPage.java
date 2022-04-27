package question;

public class AllocateMinNumPage {
	/*
	 given number of page in n different books 
	 and m students 
	 the books are arranged in ascending order 
	 of number of pages. 
	 every student is assigned to read 
	 some consecutive books.
	 The task is to assign books in such a way that 
	 the maximum number of pages assigned to a
	 student is minimum 
	 */
	class Student{
		int [] ownBook;
		int initialNum;
		Student(int numberOfBook ,int initialNum){
		this.ownBook = new int [numberOfBook];
		this.initialNum = initialNum;
		
		}
		
		public void assignBookValue() {
			for(int i=0; i<this.initialNum ;i++) {
				
			}
		}
	}
	AllocateMinNumPage(){
		
	}
	
	
	
	public void allocation(int [] input, int m) {
		int [] numberOfS = new int [m];
		Student[] students = new Student[m];
		
		// maximum possible numbers of book
		int max = maxNum(input.length, m);
		//construct the max num of book for each student 
		int initialNumber = 1;
		int goneBook = 0;
		for(int i=0; i<m; i++) {
			
			if(i == m-1){
				// if that is the last student, assign book is the max
				students[i] = new Student(max, input.length-goneBook);
			}else {
				students[i] = new Student(max , initialNumber);
				goneBook++;
			}
		}
		
		// assign book 
		int maxMin=0;
		// input length times for combination 
		for(int j = 0; j<input.length-1; j++) {
			// each loop for all the element 
			
		}
	}
	
	public int maxNum(int length, int m) {
		m = m-1;
		for(int i=0; i<m; i++) {
			length = length -1;
		}
		return length;
	}

	public static void main(String [] args) {
		int input [] = {12, 34, 67, 90};
		// number of student 
		int m = 2;
		AllocateMinNumPage mp = new AllocateMinNumPage();
		mp.allocation(input, m);
		m = 3;
		mp.allocation(input, m);
		int input2[] = {12, 34, 67, 90, 100};
		m = 3;
		mp.allocation(input2, m);
	}
	
}
